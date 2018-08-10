package br.com.cad.domain;

import java.io.Serializable;
import java.util.Objects;
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
public class CompraID implements Serializable {

    @NotNull(message = "campo deve ser informado")
    @Column(nullable = false)
    private Integer numero;

    @NotNull(message = "pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa_juridica", referencedColumnName = "id", nullable = false)
    private PessoaJuridica pessoaJuridica;

    public CompraID() {
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.numero);
        hash = 97 * hash + Objects.hashCode(this.pessoaJuridica);
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
        final CompraID other = (CompraID) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.pessoaJuridica, other.pessoaJuridica)) {
            return false;
        }
        return true;
    }

}
