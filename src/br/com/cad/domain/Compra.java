package br.com.cad.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author eveton
 */
@Entity
@Table(name = "tbl_compra")
public class Compra implements Serializable {

    @EmbeddedId
    private CompraID iD;

    @Column(name = "data_compra", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Data da compra tem que ser informada")
    private Calendar data;

    @Column(name = "valor_total", nullable = false, precision = 9, scale = 2)
    @NotNull(message = "valor da compra deve ser informado")
    private BigDecimal valorTotal;

    @Column(name = "numero_nota", nullable = false, length = 11)
    @Length(max = 11, message = "Número da nota exede valores {max} maxímos permitidos")
    @NotNull(message = "Nota não pode estar em branco")
    private Integer numeroNota;

    public Compra() {
    }

    public Compra(Calendar data, BigDecimal valorTotal, Integer numeroNota) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.numeroNota = numeroNota;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(Integer numeroNota) {
        this.numeroNota = numeroNota;
    }

}
