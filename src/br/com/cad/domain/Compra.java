package br.com.cad.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

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
    private Calendar data;

    @Column(name = "valor_total", nullable = false, precision = 9, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "numero_nota", nullable = false, length = 11)
    @NotNull(message = "Informe o número da nota")
    private Integer numeroNota;

    @OneToMany(mappedBy = "compra",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CompraItem> compraItems = new ArrayList<>();
    
    public Compra() {
    }

    public Compra(Calendar data, BigDecimal valorTotal, Integer numeroNota) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.numeroNota = numeroNota;
    }
    
    public void adicionarItens(CompraItem obj){
        obj.setCompra(this);
        valorTotal.add( obj.getValorTotal());
        this.compraItems.add(obj);
    }
    
    public void removerItem(int index){
        CompraItem compraItem = (CompraItem) this.compraItems.get(index);
        valorTotal.subtract(compraItem.getValorTotal());
        this.compraItems.remove(valorTotal);
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
