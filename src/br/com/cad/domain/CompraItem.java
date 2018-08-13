package br.com.cad.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eveton
 */
@Entity
@Table(name = "tbl_compra_item")
public class CompraItem implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_compra_item",sequenceName = "seq_compra_item_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_compra_item",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(nullable = false,columnDefinition = "numeric(10,2)")
    @NotNull(message = "quantidade deve ser informada")
    @Min(value = 0,message = "Valor deve ser maior que {0}")
    private Double quantidade;
    
    @Column(nullable = false,columnDefinition = "numeric(10,2)")
    @Min(value = 0,message = "Valor deve ser maior que {0}" )
    @NotNull(message = "Valor deve ser informadp")
    private BigDecimal valorUnitario;
    
    @Column(nullable = false,columnDefinition = "numeric(10,2)")
    @Min(value = 0,message = "Valor deve ser maior que {0}" )
    @NotNull(message = "Valor deve ser informadp")
    private BigDecimal valorTotal;
    
    @Column(name = "produto_compra_item")
    @NotNull(message = "produto deve ser informado")
    @ManyToOne
    @JoinColumn(name = "produto",referencedColumnName = "id",nullable = false)
    private Produto produto;
    
    @Column(name = "compra_compra_item")
    @NotNull(message = "compra deve ser informado")
    private Compra compra;

    public CompraItem() {
    }
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the quantidade
     */
    public Double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valorUnitario
     */
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the valorTotal
     */
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the compra
     */
    public Compra getCompra() {
        return compra;
    }

    /**
     * @param compra the compra to set
     */
    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CompraItem other = (CompraItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}

