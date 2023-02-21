package br.paulotrc.svcbacen.entites.enumerados;

public enum TipoRestricaoBacen {
    DIVIDA("Dívida"),
    SITUACAO_CADASTRAL("Situação Cadastral"),
    CPF_CANCELADO("CPF Cancelado"),
    CPF_PENDENTE("CPF Pendente"),
    CPF_NULO("CPF Nulo");

    private String descricao;

    TipoRestricaoBacen(String descricao) {
        this.descricao = descricao;
    }
}
