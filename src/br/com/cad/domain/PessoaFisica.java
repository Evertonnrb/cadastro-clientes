package br.com.cad.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author eveton
 */
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa implements Serializable {

    @Column(name = "rg_pessoa", length = 10, nullable = false)
    @Length(max = 10, message = "Campo rg não ter mais que {max} caracteres")
    @NotNull(message = "Campo não pode estar nullo")
    @NotBlank(message = "Campo não pode estar em branco")
    private String rg;

    @Column(name = "cpf_pessoa_fisica", length = 13, nullable = false)
    @CPF(message = "Campo CPF inválido")
    @Length(max = 11, message = "Campo cpf deve conter {max} caracteres")
    @NotNull(message = "Campo não pode ser nulo")
    @NotBlank(message = "Campo não pode estar em branco")
    private String cpf;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento_pessa_fisica", nullable = false)
    @NotNull(message = "campo não pode estar nullo")
    private Calendar dataNascimento;

    @Column(name = "nome_usuario_pessoa_fisica", nullable = false, length = 50, unique = true)
    @Length(max = 50, message = "Campo não pode ultrapassar {max} caracteres")
    @NotBlank(message = "campo não pode estar em branco")
    @NotNull(message = "Campo não pode ser nulo")
    private String nomeUsuario;

    @Column(name = "senha_pessoa_fisica", nullable = false, length = 32)
    @Length(max = 32, message = "Senha não pode ultrapassar {max} caracteres")
    @NotBlank(message = "Senha não pode estar em branco")
    @NotNull(message = "Senha não pode ser nula")
    private String senha;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "desejos",
            joinColumns
            = @JoinColumn(name = "pessoa_fisica", referencedColumnName = "id", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "produto", referencedColumnName = "id", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"pessoa_fisica", "produto"})}
    )
    private List<Produto> produtos = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "permissoes",
            joinColumns = 
                    @JoinColumn(name = "nome_usuario",referencedColumnName = "nome_usuario",nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "permissao",referencedColumnName = "nome",nullable = false),
            uniqueConstraints = {@UniqueConstraint (columnNames ={"nome_usuario","produto"} )}
            )
    private List<Permissao> permissoes = new ArrayList<>();

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public PessoaFisica() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.rg);
        hash = 61 * hash + Objects.hashCode(this.cpf);
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
        final PessoaFisica other = (PessoaFisica) obj;
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" + "rg=" + rg + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", nomeUsuario=" + nomeUsuario + ", senha=" + senha + '}';
    }

}
