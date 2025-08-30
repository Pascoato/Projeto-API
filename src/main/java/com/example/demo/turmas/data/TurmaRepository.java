package com.example.demo.turmas.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
  Optional<Turma> findByNomeIgnoreCase(String nome);

  List<Turma> findByPeriodoIgnoreCase(String periodo);

  List<Turma> findByCursoIgnoreCase(String curso);
}
