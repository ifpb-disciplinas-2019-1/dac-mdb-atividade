package edu.ifpb.dac.model.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PedidoItem implements Serializable{
	
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private Produto produto;
	private int quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal valor;
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	private void calcularValor() {	
		if (this.quantidade < 0)
			this.quantidade = 0;
		if(this.valorUnitario.doubleValue() < 0.0)
			this.valorUnitario = BigDecimal.ZERO;
		Double valorDouble = this.valorUnitario.doubleValue();
		valorDouble *= this.quantidade;
		this.valor = BigDecimal.valueOf(valorDouble);
	}
	
	private void calcularPeloProduto() {
		if (this.produto == null)
			return;
		this.valorUnitario = this.produto.getPreco();
		calcularValor();		
	}
	
	public PedidoItem() {}

	public PedidoItem(long id, Produto produto, int quantidade, BigDecimal valorUnitario) {
		super();
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		calcularValor();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		pedido.addItem(this);
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		calcularPeloProduto();
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		calcularValor();		
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
		calcularValor();
	}

	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoItem other = (PedidoItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PedidoItem [id=" + id + ", produto=" + produto + ", quantidade=" + quantidade + ", valorUnitario="
				+ valorUnitario + ", valor=" + valor + "]";
	}
	
}
