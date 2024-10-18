package desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.model.Aluno;

@Repository
public interface AlunoRepository  extends CrudRepository<Aluno, Long>{

}
