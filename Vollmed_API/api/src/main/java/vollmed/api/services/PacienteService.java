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

    public Optional<Paciente> findById(Long id) {
        var paciente = repository.findById(id);
        return paciente;
    }

    public void update(DadosAtualizacaoPaciente dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
