package br.com.web_pi.ado1.controllers;

import br.com.web_pi.ado1.models.Aluno;
import br.com.web_pi.ado1.records.AlunoRecord;
import br.com.web_pi.ado1.services.AlunoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = "*")
public class AlunoController {
    
    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(service.selectAll());
        }
        catch (Exception e) {
            LinkedHashMap<String, String> response = new LinkedHashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/{ra}")
    public ResponseEntity<?> getOne(@NotBlank(message = "RA não informado") @PathVariable String ra) {
        try {
            return ResponseEntity.ok(service.selectOne(ra));
        }
        catch (Exception e) {
            LinkedHashMap<Object, Object> response = new LinkedHashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody AlunoRecord record) {
        Aluno aluno;
        try {
            aluno = new Aluno();
            BeanUtils.copyProperties(record, aluno);
            return ResponseEntity.ok(service.insert(aluno));
        }
        catch (Exception e) {
            LinkedHashMap<Object, Object> response = new LinkedHashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/{ra}")
    public ResponseEntity<?> put(@NotBlank(message = "RA não informado") @PathVariable String ra, @Valid @RequestBody AlunoRecord record) {
        try {
            Aluno aluno = new Aluno();
            BeanUtils.copyProperties(record, aluno);
            return ResponseEntity.ok(service.update(ra, aluno));
        }
        catch (Exception e) {
            LinkedHashMap<Object, Object> response = new LinkedHashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/{ra}")
    public ResponseEntity<?> delete(@NotBlank(message = "RA não informado") @PathVariable String ra) {
        LinkedHashMap<Object, Object> response = new LinkedHashMap<>();
        try {
            response.put("status", service.delete(ra));
            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
