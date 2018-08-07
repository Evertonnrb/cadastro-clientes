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
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author eveton
 */
@Entity
@Table(name = "tbl_produto")
public class Produto implements Serializable{

    @Id
    @SequenceGenerator(name = "seq_prod",sequenceName = "seq_prod_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_prod",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome_prod",length = 80,nullable = false)
    @Length(max = 80, message = "Nome do produto deve ter no max {80} size")
    @NotNull(message = "Nome do produto não pode estar nulo")
    @NotBlank(message = "Nome do produto não pode estar em branco")
    private String nome;

    @Column(name = "preco_prod",scale = 2,precision = 8)
    private BigDecimal preco;
    
    @Column(name = "quantidade_em_estoque",nullable = false)
    private Integer quantidadeEstoque;
    
    @Column(name = "descricao_produto",length = 100,nullable = false)
    @Length(max = 100,message = "descrição do produto não pode exeder {max} caracteres")
    @NotBlank(message = "descrição não pode estar em branco")
    @NotNull(message = "descrição não pode estar nula")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "nome_categoria",referencedColumnName = "id",nullable = false)
    @ForeignKey(name = "fk_catergoria")
    private Categoria categoria;
    
    @ManyToOne
    @JoinColumn(name = "nome_marca",referencedColumnName = "id",nullable = false)
    @ForeignKey(name = "fk_marca")
    private Marca marca;
    
    public Produto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
