package desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.model.Aluno;
import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.model.Endereco;
import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.repository.AlunoRepository;
import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.repository.EnderecoRepository;
import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.service.AlunoService;
import desafio.padrao.projeto.desafio_padroes_projeto_spring_boot.service.ViaCepService;

@Service
@Component
public class AlunoServviceImpl implements AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ViaCepService viaCepService;

    @Override
    public Iterable<Aluno> buscarTodosAlunos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno buscarAlunoPorId(Long id) {
         Optional<Aluno> aluno = alunoRepository.findById(id);

         aluno.orElseGet(() -> {
            return null;
         });
         
         return aluno.get();
    }

    @Override
    public void salvarAluno(Aluno aluno) {
        String cep = aluno.getEndereco().getCep();

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);

            enderecoRepository.save(novoEndereco);

            return novoEndereco;
        });

        aluno.setEndereco(endereco);

        alunoRepository.save(aluno);
    }

    @Override
    public void atualizarAluno(Long id, Aluno aluno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarAluno'");
    }

    @Override
    public void deletarAluno(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarAluno'");
    }

}
