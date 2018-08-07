package br.com.cad.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
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
@Inheritance(strategy = InheritanceType.JOINED)//Herança
@Table(name = "tbl_pessoa")
public class Pessoa implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_pessoa",sequenceName = "seq_pessoa_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome_pessoa",length = 50,nullable = false)
    @Length(max = 50,message = "Nome não pode ultrapassar {max} caracteres")
    @NotNull(message = "Nome não pode estar em branco")
    @NotBlank(message = "Nome deve ser informado")
    private String nome;
    
    @Column(name = "email_pessoa",length = 50,nullable = false)
    @Length(max = 50,message = "email não pode ultrapassar {max} caracteres")
    @NotBlank(message = "email não pode estar em branco")
    @NotNull(message = "email não pode ser nullo")
    private String email;
    
    @Column(name = "telefone_pessoa",length = 12,nullable = false)
    @Length(max = 12,message = "Telefone de ter no maxímo {max} caracteres")
    @NotNull(message = "Campo não pode ser nulo")
    @NotBlank(message = "campo não pode estar em branco")
    private String telefone;
    
    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Endereco> enderecos = new ArrayList<>();
    
    public void addEndereco(Endereco obj){
        obj.setPessoa(this);
        this.enderecos.add(obj);
    } 
    
    public void removerEndereco(int index){
        this.enderecos.remove(index);
    }
    
    public Pessoa() {
    }

    public Pessoa(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
