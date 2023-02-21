package br.paulotrc.svcbacen.transportlayers.dto.request;

import br.paulotrc.svcbacen.entites.enumerados.TipoRestricaoBacen;
import br.paulotrc.svcbacen.entites.validators.TipoRestricaoBacenValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class BacenRequest {

    private UUID id = UUID.randomUUID();
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;
    @NotNull(message = "Indicativo de se tem restrição é obrigatório")
    private Boolean temRestricao;
    @TipoRestricaoBacenValidator(regexp = "EXCLUSAO_CLIENTE|EXCLUSAO_OPERACAO|MARCACAO_SUBJUDICE|VICIO_CONTRATO|MANIFESTACAO_DISCORDANCIA")
    private TipoRestricaoBacen tipoRestricaoBacen;
    @Positive(message = "Valor da restrição deve ser maior que zero.")
    private BigDecimal valorRestricao;
}

