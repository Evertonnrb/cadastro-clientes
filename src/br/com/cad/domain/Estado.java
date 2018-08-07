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
 *
 * @author eveton
 */
@Entity
@Table(name = "tbl_estado")
public class Estado implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_estado",sequenceName = "seq_estado_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_estado",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome_estado",nullable = false,length = 50)
    @Length(max = 50,message = "Campo nome do estado não pode ultrapassar {max} caracteres")
    @NotNull(message = "Nome do estado não pode ser nulo")
    @NotBlank(message = "Nome do estado deve ser informado")
    private String nome;
    
    @Column(name = "uf_estado",nullable = false,length = 2)
    @Length(max = 2,message = "UF do estado tem que ter no max {max} caracteres")
    @NotBlank(message = "UF do estado não poser ser deixada em branco")
    @NotNull(message = "UF do estado não pode ser nulo")
    private String uf;
    
    @NotNull(message = "O país deve ser informado")
    @ManyToOne
    @JoinColumn(name = "tbl_pais",referencedColumnName = "id",nullable = false)
    @ForeignKey(name = "fk_pais")
    private Pais pais;

    public Estado() {
    }

    public Estado(String nome, String uf, Pais pais) {
        this.nome = nome;
        this.uf = uf;
        this.pais = pais;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
