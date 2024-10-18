package desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.model.Curso;
import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.repository.CursoRepository;
import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.service.CursoService;

@Service
@Component
public class CursoServiceImpl implements CursoService {

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public Iterable<Curso> buscarTodosCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso buscarCursoPorId(Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        curso.orElseGet(() -> {
            return null;
        });

        return curso.get();
    }

    @Override
    public void salvarCurso(Curso curso) {
        boolean existe = false;
        Iterable<Curso> cursoLista = buscarTodosCursos();
        for (Curso curso2 : cursoLista) {
            if (curso.getNome().equals(curso2.getNome())) {
                System.out.println("Curso já esta cadastrado!!!");
                existe = true;
                break;
            }
        }
        if ( !(existe == true)) {
            cursoRepository.save(curso);
            System.out.println("Curso salvo com sucesso");

        }
    }

}
