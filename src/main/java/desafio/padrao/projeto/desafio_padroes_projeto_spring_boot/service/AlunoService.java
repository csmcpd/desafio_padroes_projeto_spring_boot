package desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.service;


import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.model.Aluno;

public interface AlunoService {

    Iterable<Aluno> buscarTodosAlunos();

	Aluno buscarAlunoPorId(Long id);

	void salvarAluno(Aluno aluno);

	void atualizarAluno(Long id, Aluno aluno);

	void deletarAluno(Long id);

}
