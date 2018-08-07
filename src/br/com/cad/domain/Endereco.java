package br.com.cad.domain;

import java.io.Serializable;
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
 * @email everton.nrb@gmail.com
 * @author eveton
 */

@Entity
@Table(name = "tbl_endereco")
public class Endereco implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_endereco",sequenceName = "seq_endereco_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_endereco",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nickname",nullable = false,length = 50)
    @Length(max = 50,message = "campo não pode ter mais que {max} caracteres")
    @NotBlank(message = "campo não pode estar em branco")
    @NotNull(message = "campo não pode estar nulo")
    private String nickName;
    
    @Column(name = "endereco",nullable = false,length = 80)
    @Length(max = 80,message = "campo não pode ter mais que {max} caracteres")
    @NotBlank(message = "campo não pode estar em branco")
    @NotNull(message = "campo não pode estar nulo")
    private String endereco;

    @Column(name = "numero",nullable = false,length = 9)
    @Length(max = 9,message = "campo não pode ter mais que {max} caracteres")
    @NotBlank(message = "campo não pode estar em branco")
    @NotNull(message = "campo não pode estar nulo")
    private String numero;
    
    @Column(name = "complemento",nullable = false,length = 50)
    @Length(max = 50,message = "campo não pode ter mais que {max} caracteres")
    @NotBlank(message = "campo não pode estar em branco")
    @NotNull(message = "campo não pode estar nulo")
    private String complemento;
    
    @Column(name = "cep",nullable = false,length = 15)
    @Length(max = 15,message = "campo não pode ter mais que {max} caracteres")
    @NotBlank(message = "campo não pode estar em branco")
    @NotNull(message = "campo não pode estar nulo")
    private String cep;
    
    @Column(name = "bairro",nullable = false,length = 50)
    @Length(max = 50,message = "campo não pode ter mais que {max} caracteres")
    @NotBlank(message = "campo não pode estar em branco")
    @NotNull(message = "campo não pode estar nulo")
    private String bairro;
    
    @Column(name = "referencia",nullable = false,length = 50)
    @Length(max = 50,message = "campo não pode ter mais que {max} caracteres")
    @NotBlank(message = "campo não pode estar em branco")
    @NotNull(message = "campo não pode estar nulo")
    private String referencia;
    
    @NotNull(message = "residente do endereço deve ser informado")
    @ManyToOne
    @JoinColumn(name = "pessoa_id",referencedColumnName = "id",nullable = false)
    @ForeignKey(name = "fk_pessoa")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "tipo_endereco",referencedColumnName = "id",nullable = false)
    @ForeignKey(name = "fk_tipo_endereco")
    private TipoEndereco tipoEndereco;
    
    public Endereco() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.cep);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
