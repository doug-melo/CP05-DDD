package com.example.cp05.repository;

import com.example.cp05.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByEmprestadoFalse();
}
