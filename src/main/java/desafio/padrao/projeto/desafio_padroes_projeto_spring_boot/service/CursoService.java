package desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.service;

import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.model.Curso;


public interface CursoService {

    Iterable<Curso> buscarTodosCursos();

	Curso buscarCursoPorId(Long id);

	void salvarCurso(Curso curso);
}
