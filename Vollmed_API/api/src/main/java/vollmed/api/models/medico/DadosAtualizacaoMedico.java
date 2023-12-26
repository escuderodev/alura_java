package vollmed.api.models.medico;

import jakarta.validation.constraints.NotNull;
import vollmed.api.models.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
