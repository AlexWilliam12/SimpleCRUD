package br.com.web_pi.ado1.services;

import java.util.List;

import br.com.web_pi.ado1.models.AlunoResponse;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.web_pi.ado1.exceptions.AlunoException;
import br.com.web_pi.ado1.models.Aluno;
import br.com.web_pi.ado1.repositories.AlunoRepository;
import br.com.web_pi.ado1.utils.AlunoUtils;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> selectAll() throws AlunoException {
        var list = repository.findAll();
        if (!list.isEmpty())
            return list;
        else
            throw new AlunoException("Não há alunos cadastrados");
    }

    public Object selectOne(String ra) throws AlunoException {
        var optionalAluno = repository.findById(ra);
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            try {
                var optionalEndereco = AlunoUtils.getEndereco(aluno.getCep());
                var endereco = optionalEndereco.get();
                endereco.setNumero(aluno.getNumero());
                endereco.setComplemento(aluno.getComplemento());
                return new AlunoResponse(aluno.getRa(),
                        aluno.getNome(),
                        endereco,
                        aluno.getNotaAdo1(),
                        aluno.getNotaPi());
            }
            catch (Exception e) {
                return aluno;
            }
        }
        else
            throw new AlunoException("Aluno não encontrado");
    }

    public Aluno insert(Aluno aluno) throws AlunoException {
        if (repository.findOne(Example.of(aluno)).isEmpty()) {
            aluno.setRa(AlunoUtils.generatedRa());
            return repository.save(aluno);
        }
        else
            throw new AlunoException("Aluno já existente");
    }

    public Aluno update(String ra, Aluno aluno) throws AlunoException {
        var optional = repository.findById(ra);
        if (optional.isPresent()) {
            aluno.setRa(ra);
            return repository.save(aluno);
        }
        else
            throw new AlunoException("Aluno não encontrado");
    }

    public boolean delete(String ra) throws AlunoException {
        if (repository.findById(ra).isPresent()) {
            repository.deleteById(ra);
            return true;
        }
        else {
            throw new AlunoException("Aluno não encontrado");
        }
    }
}
