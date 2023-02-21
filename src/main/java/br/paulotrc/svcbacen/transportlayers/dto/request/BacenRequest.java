package br.paulotrc.svcbacen.transportlayers.dto.request;

import br.paulotrc.svcbacen.entites.enumerados.TipoRestricaoBacen;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class BacenRequest {

    private UUID id;
    private String cpf;
    private Boolean temRestricao;
    private TipoRestricaoBacen tipoRestricaoBacen;
    private BigDecimal valorRestricao;
}

