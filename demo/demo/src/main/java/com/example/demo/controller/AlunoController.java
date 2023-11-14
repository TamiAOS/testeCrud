package com.example.demo.controller;

import com.example.demo.entity.Aluno;
import com.example.demo.service.AlunoService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoService alunoService;
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/criarAluno")
    public ResponseEntity<Aluno> createAluno(@RequestBody Aluno aluno){
        var request = alunoService.criar(aluno);
        return ResponseEntity.ok(request);
    }

    @DeleteMapping("/deletarAluno/{id}")
    public void deletarAluno(@PathVariable Long id){
         alunoService.deletar(id);
    }
    @GetMapping("/buscarAluno/{id}")
    public ResponseEntity<Aluno> buscarAluno(@PathVariable Long id){
        var request = alunoService.buscar(id);
        return ResponseEntity.ok(request);
    }

}
