package br.paulotrc.svcbacen.entites;

import br.paulotrc.svcbacen.entites.enumerados.TipoRestricaoBacen;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@Document //Anotação mongo para mapeamento do document.
public class Bacen {

    @Id
    private UUID id = UUID.randomUUID();
    private String cpf;
    private Boolean temRestricao;
    private TipoRestricaoBacen tipoRestricaoBacen;
    private BigDecimal valorRestricao;
}

