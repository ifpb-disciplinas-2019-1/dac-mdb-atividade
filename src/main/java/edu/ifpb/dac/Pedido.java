package edu.ifpb.dac;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Ricardo Job
 */
@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    private List<Produto> produtos;
    
    @ManyToOne
    private Cliente cliente;

    private BigDecimal valorFinal;

    public Pedido() {
        this.produtos = new ArrayList<>();
    }
    
    

    public Pedido(int id, List<Produto> produtos, Cliente cliente, BigDecimal valorFinal) {
		super();
		this.id = id;
		this.produtos = produtos;
		this.cliente = cliente;
		this.valorFinal = valorFinal;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void add(Produto produto) {
        this.produtos.add(produto);
    }

    public void remove(Produto produto) {
        this.produtos.remove(produto);
    }
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }
}
