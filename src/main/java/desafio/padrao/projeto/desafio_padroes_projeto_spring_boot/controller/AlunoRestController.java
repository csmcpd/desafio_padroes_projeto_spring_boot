package desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.model.Aluno;
import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.service.impl.AlunoServviceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/")
public class AlunoRestController {

    @Autowired
    private AlunoServviceImpl alunoServbiceImpl;

    @GetMapping
    public Iterable<Aluno> buscarTodosAlunosController() {
        return alunoServbiceImpl.buscarTodosAlunos();
    }

    @GetMapping("{id}")
    public ResponseEntity<Aluno> biscarAlunoPorIdController(@PathVariable Long id) {
        return ResponseEntity.ok(alunoServbiceImpl.buscarAlunoPorId(id));
    }

    @PostMapping
    public ResponseEntity<Aluno> salvarAlunoController(@RequestBody Aluno aluno) {
        alunoServbiceImpl.salvarAluno(aluno);
        return ResponseEntity.ok(aluno);

    }

}
