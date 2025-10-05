package com.example.cp05.controller;

import com.example.cp05.dto.EmprestimoForm;
import com.example.cp05.model.Emprestimo;
import com.example.cp05.model.Livro;
import com.example.cp05.model.Usuario;
import com.example.cp05.repository.EmprestimoRepository;
import com.example.cp05.repository.LivroRepository;
import com.example.cp05.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;

    public EmprestimoController(EmprestimoRepository emprestimoRepository,
                                LivroRepository livroRepository,
                                UsuarioRepository usuarioRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public String listar(Model model) {
        List<Emprestimo> ativos = emprestimoRepository.findByDevolvidoFalse();
        model.addAttribute("emprestimos", ativos);
        return "emprestimos/list";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("form", new EmprestimoForm());
        model.addAttribute("livros", livroRepository.findByEmprestadoFalse());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "emprestimos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid EmprestimoForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("livros", livroRepository.findByEmprestadoFalse());
            model.addAttribute("usuarios", usuarioRepository.findAll());
            return "emprestimos/form";
        }

        if (!form.getDataPrevistaDevolucao().isAfter(form.getDataRetirada())) {
            result.rejectValue("dataPrevistaDevolucao", "error.data", "Data de devolução deve ser posterior à retirada");
            model.addAttribute("livros", livroRepository.findByEmprestadoFalse());
            model.addAttribute("usuarios", usuarioRepository.findAll());
            return "emprestimos/form";
        }

        Livro livro = livroRepository.findById(form.getLivroId()).orElseThrow();
        Usuario usuario = usuarioRepository.findById(form.getUsuarioId()).orElseThrow();

        livro.setEmprestado(true);
        livroRepository.save(livro);

        Emprestimo e = new Emprestimo();
        e.setLivro(livro);
        e.setUsuario(usuario);
        e.setDataRetirada(form.getDataRetirada());
        e.setDataPrevistaDevolucao(form.getDataPrevistaDevolucao());
        e.setDevolvido(false);
        emprestimoRepository.save(e);

        return "redirect:/emprestimos";
    }

    @PostMapping("/devolver/{id}")
    public String devolver(@PathVariable("id") Long id) {
        Emprestimo e = emprestimoRepository.findById(id).orElseThrow();
        e.setDevolvido(true);
        emprestimoRepository.save(e);

        Livro livro = e.getLivro();
        livro.setEmprestado(false);
        livroRepository.save(livro);

        return "redirect:/emprestimos";
    }
}
