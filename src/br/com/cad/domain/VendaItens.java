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
@Table(name="tbl_venda_itens")
public class VendaItens implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_venda_itens",sequenceName = "seq_venda_itens_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_venda_itens",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "quantidade",nullable = false,columnDefinition = "decimal(10,2)")
    @NotNull(message = "quantidade deve ser informada")
    private Double quantidade;
    
    @Column(name = "valor_total",nullable = false,columnDefinition = "decimal(10,2)")
    @Min(value = 0, message = "Valor nao pode ser menos que 0")
    @NotNull(message = "Informe o valor total")
    private BigDecimal valorTotal;
    
    @NotNull(message = "Venda não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "venda",referencedColumnName = "id",nullable = false)
    private Venda venda;
    
    @NotNull(message = "produto deve ser informado")
    @ManyToOne
    @JoinColumn(name = "pessoa_fisica",referencedColumnName = "id",nullable = false)
    private Produto produto;
    
    public VendaItens() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final VendaItens other = (VendaItens) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
