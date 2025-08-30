package com.example.demo.turmas.presentation;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.turmas.business.TurmaService;
import com.example.demo.turmas.presentation.dto.CreateTurmaDto;
import com.example.demo.turmas.presentation.dto.TurmaDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
  @org.springframework.beans.factory.annotation.Autowired
  private TurmaService service;

  @PostMapping
  public ResponseEntity<TurmaDto> create(@RequestBody @Valid CreateTurmaDto dto) {
    var created = service.create(dto);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/<built-in function id>")
        .buildAndExpand(created.id()).toUri();
    return ResponseEntity.created(location).body(created);
  }

  @GetMapping("/<built-in function id>")
  public ResponseEntity<TurmaDto> getById(@PathVariable Long id) {
    return ResponseEntity.ok(service.getById(id));
  }

  @GetMapping
  public ResponseEntity<List<TurmaDto>> getAll() {
    var list = service.getAll();
    return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
  }

  @GetMapping("/nome/{nome}")
  public ResponseEntity<TurmaDto> getByNome(@PathVariable String nome) {
    return ResponseEntity.ok(service.getByNome(nome));
  }

  @GetMapping("/periodo/{periodo}")
  public ResponseEntity<List<TurmaDto>> getByPeriodo(@PathVariable String periodo) {
    return ResponseEntity.ok(service.getByPeriodo(periodo));
  }

  @GetMapping("/curso/{curso}")
  public ResponseEntity<List<TurmaDto>> getByCurso(@PathVariable String curso) {
    return ResponseEntity.ok(service.getByCurso(curso));
  }

  @DeleteMapping("/<built-in function id>")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
