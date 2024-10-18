package desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.model.Curso;
import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.service.impl.CursoServiceImpl;

@RestController
@RequestMapping("/curso")
public class CursoRestController {

    @Autowired
    private CursoServiceImpl cursoServiceImpl;

    @GetMapping
    public Iterable<Curso> buscarTodosCursosController() {
        return cursoServiceImpl.buscarTodosCursos();
    }

    @GetMapping("{id}")
    public ResponseEntity<Curso> biscarCursoPorIdController(@PathVariable Long id) {
        return ResponseEntity.ok(cursoServiceImpl.buscarCursoPorId(id));
    }

    @PostMapping
    public ResponseEntity<Curso> salvarAlunoController(@RequestBody Curso curso) {
        cursoServiceImpl.salvarCurso(curso);
        return ResponseEntity.ok(curso);

    }
    
}
