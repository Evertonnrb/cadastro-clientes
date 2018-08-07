package br.com.cad.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
/**
 *
 * @author eveton
 */
@Entity
@Table(name = "tbl_pessoa_juridica")
public class PessoaJuridica extends Pessoa implements Serializable{
    
    @Column(name = "inscricao_estadual",nullable = false,length = 50,unique = true)
    @Length(max = 50,message = "Codigo da inscrição não deve ter mais que {max} ")
    @NotBlank(message = "Campo IE não pode estar em branco")
    @NotNull(message = "campo IE não pode ser nulo")
    private String ie;
    
    @Column(name = "cnpj",length = 15,nullable = false,unique = true)
    @CNPJ(message = "CNPJ inválido")
    @Length(max = 15,message = "Campo CNPJ não deve ter mais que {max} caracteres")
    @NotBlank(message = "CNPJ não pode estar em branco")
    @NotNull(message = "CNPJ não pode estar nullo")
    private String cnpj;

    public PessoaJuridica() {
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cnpj);
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
        final PessoaJuridica other = (PessoaJuridica) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + "ie=" + ie + ", cnpj=" + cnpj + '}';
    }
    
    
    
}
