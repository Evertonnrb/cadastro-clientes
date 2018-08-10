package br.com.cad.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eveton
 */
@Entity
@Table(name = "tbl_venda")
public class Venda implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_venda",sequenceName = "seq_venda_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_venda",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_venda",nullable = false)
    private Calendar data;
    
    @Column(name = "quantidade_parcelas")
    @NotNull(message = "informe a quantidade de parcelas")
    private Integer parcelas;
    
    @Column(name = "valor_unitario",precision = 2,scale = 10)
    @NotNull(message = "informe o valor unitario")
    @Min(value = 0,message = "O valor não pode ser menor que 0")
    private BigDecimal valorUnitario;
    
    @Column(name = "valor_total",precision = 2,scale = 10)
    @NotNull(message = "informe o valor total")
    @Min(value = 0,message = "O valor não pode ser menor que 0")
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "pessoa_fisica",referencedColumnName = "id",nullable = false)
    private PessoaFisica pessoaFisica;
    
    @OneToMany(mappedBy = "venda",cascade = CascadeType.ALL,orphanRemoval = false,fetch = FetchType.LAZY)
    private List<VendaItens> vendaItens = new ArrayList<>();
    
     @OneToMany(mappedBy = "parcelaId.venda",cascade = CascadeType.ALL,orphanRemoval = false,fetch = FetchType.LAZY)
    private List<Parcela> listaParcelas  = new ArrayList<>();
    
  
     
    public void adicionaVenda(VendaItens itens){
        itens.setVenda(this);
        this.valorTotal.add(itens.getValorTotal());
        vendaItens.add(itens);
    }
    
    public void remove(int id){
        vendaItens = (List<VendaItens>) this.vendaItens.get(id);
    }
    
    public void gerarParcelas(){
        
    }
    
    public Venda() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return parcelas;
    }

    public void setQuantidade(Integer quantidade) {
        this.parcelas = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<VendaItens> getVendaItens() {
        return vendaItens;
    }

    public void setVendaItens(List<VendaItens> vendaItens) {
        this.vendaItens = vendaItens;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public List<Parcela> getListaParcelas() {
        return listaParcelas;
    }

    public void setListaParcelas(List<Parcela> listaParcelas) {
        this.listaParcelas = listaParcelas;
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
