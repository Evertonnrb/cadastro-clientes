package br.com.cad.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author eveton
 */
@Entity
@Table(name="tbl_foto")
public class Foto implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_foto",sequenceName = "seq_foto_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_foto",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "campo nome deve ser informado")
    @NotBlank(message = "campo nome deve ser informado")
    @Column(nullable = false,length = 50)
    private String nome;
    
    @NotNull(message = "campo descrição deve ser informado")
    @NotBlank(message = "campo descrição deve ser informado")
    @Column(nullable = false,length = 50)
    private String descricao;
    
    @NotNull(message = "campo arquivo deve ser informado")
    @Lob
    @Column(nullable = false)
    private byte[] arquivos;
    
    @NotNull(message = "campo produto deve ser informado")
    @ManyToOne
    @JoinColumn(name = "produto",referencedColumnName = "id")
    private Produto produto;

    public Foto() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getArquivos() {
        return arquivos;
    }

    public void setArquivos(byte[] arquivos) {
        this.arquivos = arquivos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Foto other = (Foto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
