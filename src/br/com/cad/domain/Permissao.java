package br.com.cad.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author eveton
 */
@Entity
@Table(name = "permissao")
public class Permissao implements Serializable{

    @Id
    @Column(name = "nome",nullable = false)
    @Length(max = 50,message = "nome deve ser informado")
    @NotBlank(message = "nome não pode estar em branco")
    @NotNull(message = "nome nao pode estar em branco")
    private String nome;
    
    @Column(name = "descricao")
    @Length(max = 50,message = "descricao deve ser informado")
    @NotBlank(message = "descricao não pode estar em branco")
    @NotNull(message = "descricao nao pode estar em branco")
    private String descricao;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nome);
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
        final Permissao other = (Permissao) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    
}
