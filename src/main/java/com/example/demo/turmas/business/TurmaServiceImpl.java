package com.example.demo.turmas.business;
import com.example.demo.turmas.business.exception.*; import com.example.demo.turmas.data.*; import com.example.demo.turmas.presentation.dto.*;
import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.util.List;
@Service @Transactional
public class TurmaServiceImpl implements TurmaService {
  private final TurmaRepository repo;
  public TurmaServiceImpl(TurmaRepository repo) { this.repo = repo; }

  public TurmaDto create(CreateTurmaDto dto) { var saved = repo.save(new Turma(dto.nome(), dto.curso(), dto.periodo())); return toDto(saved); }
  @Transactional(readOnly = true) public TurmaDto getById(Long id) {
    var t = repo.findById(id).orElseThrow(() -> new NotFoundException("Turma com id %d não encontrada".formatted(id)));
    return toDto(t);
  }
  @Transactional(readOnly = true) public List<TurmaDto> getAll() { return repo.findAll().stream().map(this::toDto).toList(); }
  @Transactional(readOnly = true) public TurmaDto getByNome(String nome) {
    var t = repo.findByNomeIgnoreCase(nome).orElseThrow(() -> new NotFoundException("Nenhuma turma com o nome '%s'".formatted(nome)));
    return toDto(t);
  }
  @Transactional(readOnly = true) public List<TurmaDto> getByPeriodo(String periodo) {
    var list = repo.findByPeriodoIgnoreCase(periodo); if (list.isEmpty()) throw new NotFoundException("Nenhuma turma no período '%s'".formatted(periodo));
    return list.stream().map(this::toDto).toList();
  }
  @Transactional(readOnly = true) public List<TurmaDto> getByCurso(String curso) {
    var list = repo.findByCursoIgnoreCase(curso); if (list.isEmpty()) throw new NotFoundException("Nenhuma turma do curso '%s'".formatted(curso));
    return list.stream().map(this::toDto).toList();
  }
  public void deleteById(Long id) { if (!repo.existsById(id)) throw new NotFoundException("Turma com id %d não encontrada".formatted(id)); repo.deleteById(id); }
  private TurmaDto toDto(Turma t) { return new TurmaDto(t.getId(), t.getNome(), t.getCurso(), t.getPeriodo()); }
}
