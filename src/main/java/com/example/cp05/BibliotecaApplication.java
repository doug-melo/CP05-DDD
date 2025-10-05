package com.example.cp05;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cp05.model.Livro;
import com.example.cp05.model.Usuario;
import com.example.cp05.repository.LivroRepository;
import com.example.cp05.repository.UsuarioRepository;

@SpringBootApplication
public class BibliotecaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
    }

    @Bean
    CommandLineRunner init(LivroRepository lr, UsuarioRepository ur) {
        return args -> {
            if (lr.count() == 0) {
                Livro l1 = new Livro(null, "Dom Casmurro", "Machado de Assis", 1899, false);
                Livro l2 = new Livro(null, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943, false);
                lr.save(l1);
                lr.save(l2);
            }
            if (ur.count() == 0) {
                ur.save(new Usuario(null, "Ana Silva", "ana@example.com"));
                ur.save(new Usuario(null, "João Souza", "joao@example.com"));
            }
        };
    }
}
