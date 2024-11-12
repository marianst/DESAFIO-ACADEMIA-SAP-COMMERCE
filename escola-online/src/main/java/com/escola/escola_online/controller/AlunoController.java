package com.escola.escola_online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/alunos")
@RequestMapping("/testeGet")
public class AlunoController {

    //@Autowired
    //private AlunoRepository alunoRepository;

    //@PostMapping
    //public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        //return alunoRepository.save(aluno);
    //}

    //@GetMapping("/{id}/cursos")
    @GetMapping
    public String testeGet(){
        return "Classe aluno ok";
    }
    //public List<CursoDTO> listarCursos(@PathVariable Long id) {
        //Aluno aluno = alunoRepository.findById(id).orElseThrow();
        //return InscricaoPopulator.toCursoDTOList(List.copyOf(aluno.getCursos()));
    //}
}
