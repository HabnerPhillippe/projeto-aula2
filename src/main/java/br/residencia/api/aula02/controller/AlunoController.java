package br.residencia.api.aula02.controller;


import java.util.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.residencia.api.aula02.model.Aluno;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private static List<Aluno> alunos = new ArrayList<>();
    
    static {
        alunos.add(new Aluno("123", "Habner", "habner@gmail.com"));
        alunos.add(new Aluno("321", "Ana", "a@gmail.com"));
        alunos.add(new Aluno("124", "Jose", "j@gmail.com"));
        alunos.add(new Aluno("126", "Carlos", "c@gmail.com"));
    }

    @GetMapping
    public List<Aluno> lista() {
        return alunos;
    }


    @GetMapping("{matricula}")
    public Aluno buscar(@PathVariable String matricula) {
        for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getMatricula().equals(matricula)) {
				return alunos.get(i);
			}
		}
		return null;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno inserir(@RequestBody Aluno aluno) {
        alunos.add(aluno);
        return aluno;
    }
}