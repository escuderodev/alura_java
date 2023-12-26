package vollmed.api.models.paciente;

import vollmed.api.models.endereco.Endereco;
import vollmed.api.models.medico.Especialidade;
import vollmed.api.models.medico.Medico;

public record DadosDetalhamentoPaciente(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        Endereco endereco) {

    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
