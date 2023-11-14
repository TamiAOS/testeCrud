package com.example.demo.service;

import com.example.demo.entity.Aluno;
import com.example.demo.repository.AlunoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private AlunoRepository repository;
    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public Aluno criar(Aluno aluno){
        return repository.save(aluno);
    }

    public void deletar(Long aluno){
         repository.deleteById(aluno);
    }
    public Aluno buscar(Long aluno){
        return repository.findById(aluno).orElseThrow(() -> new RuntimeException("Aluno Não Encontrado"));
    }
}
