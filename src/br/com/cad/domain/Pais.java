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
@Table(name = "tbl_pais")
public class Pais implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_pais",sequenceName = "seq_pais_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_pais",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max = 50,message = "O nome não pode ter mais de {max} caracteres")
    @NotBlank(message = "O nome do país deve ser informado")
    @NotNull(message = "O nome do país não pode estar nulo")
    @Column(name = "nome_pais",nullable = false,length = 50)
    private String nome;
    
    @Length(max = 3,message = "A iso do país não deve ter mais de que {max} caracteres")
    @NotBlank(message = "A iso do país deve ser informada")
    @NotNull(message = "A iso do país não pode ser nula")
    @Column(name = "iso_pais",nullable = false,length = 3)
    private String iso;

    public Pais() {
    }
    public Pais(String nome, String iso) {
        this.nome = nome;
        this.iso = iso;
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

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Pais other = (Pais) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
