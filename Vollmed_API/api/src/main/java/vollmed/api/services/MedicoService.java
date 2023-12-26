package vollmed.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import vollmed.api.models.medico.*;

import java.util.Optional;

@Service
public class MedicoService {

    private MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public void create(Medico medico) {
        repository.save(medico);
    }

    public Page<DadosListagemMedico> findAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    public Medico findById(Long id) {
        var medico = repository.getReferenceById(id);
        return medico;
    }

    public void update(DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    public void delete(Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
