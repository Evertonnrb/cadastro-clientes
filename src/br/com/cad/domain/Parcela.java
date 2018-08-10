package br.com.cad.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eveton
 */
@Entity
@Table(name = "parcela")
public class Parcela implements Serializable{
    
    @EmbeddedId
    private ParcelaId id;
    
    @NotNull(message = "valor deve ser informado")
    @Min(value = 0,message = "Valor não deve ser menor que 0")
    @Column(nullable = false,columnDefinition = "decimal(10,2)")
    private BigDecimal valor;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_vencimento",nullable = false)
    @NotNull(message = "data de vencimento deve ser informada")
    private Calendar dataVencimento;
    
    @NotNull(message = "valor pagamento deve ser informado")
    @Min(value = 0,message = "Valor não deve ser menor que 0")
    @Column(nullable = false,columnDefinition = "decimal(10,2)")
    private BigDecimal valorPagamento;
   
    @Temporal(TemporalType.DATE)
    @Column(name = "data_pagamento",nullable = false)
    private Calendar dataPagamento;

    public Parcela() {
    }

    public ParcelaId getId() {
        return id;
    }

    public void setId(ParcelaId id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Calendar getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Calendar dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(BigDecimal valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
    
}
