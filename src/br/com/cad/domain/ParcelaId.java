package br.com.cad.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eveton
 */
@Embeddable
public class ParcelaId implements Serializable{
    
    @NotNull(message = "O número não pode ser nula")
    @Column(name = "numero", nullable = false)
    private Integer numero;
    
    @NotNull(message = "venda não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "venda", referencedColumnName = "id", nullable = false)
    private Venda venda;

    public ParcelaId() {
    }

    
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    
}
