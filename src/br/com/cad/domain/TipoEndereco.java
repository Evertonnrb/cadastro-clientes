package br.com.cad.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author eveton
 */
@Entity
@Table(name = "tbl_tipo_endereco")
public class TipoEndereco implements  Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_tipo_end",sequenceName = "seq_tipo_end_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_tipo_end",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "descricao",nullable = false,length = 80)
    @Length(max = 80,message = "campo não pode ultrapassar {max} caracteres")
    @NotBlank(message = "campo não pode estar em branco")
    @NotNull(message = "campo não pode estar nulo")
    private String descricao;

    public TipoEndereco() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final TipoEndereco other = (TipoEndereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
