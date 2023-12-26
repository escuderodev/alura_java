package vollmed.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import vollmed.api.models.paciente.*;

import java.util.Optional;

@Service
public class PacienteService {

    private PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public void create(Paciente paciente) {
        repository.save(paciente);
    }

    public Page<DadosListagemPaciente> findAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }

    public Paciente findById(Long id) {
        var paciente = repository.getReferenceById(id);
        return paciente;
    }

    public void update(DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    public void delete(Long id) {
        var paciente = repository.getReferenceById(id);
        System.out.println(paciente);
        repository.deleteById(paciente.getId());
    }
}
