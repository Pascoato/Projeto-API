package com.example.demo.turmas.business;
import com.example.demo.turmas.presentation.dto.*; import java.util.List;
public interface TurmaService {
  TurmaDto create(CreateTurmaDto dto);
  TurmaDto getById(Long id);
  List<TurmaDto> getAll();
  TurmaDto getByNome(String nome);
  List<TurmaDto> getByPeriodo(String periodo);
  List<TurmaDto> getByCurso(String curso);
  void deleteById(Long id);
}
