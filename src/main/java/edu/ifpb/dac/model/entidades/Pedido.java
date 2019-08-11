package edu.ifpb.dac.model.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
 
@SuppressWarnings("serial")
@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @OneToMany(mappedBy = "pedido")
    private List<PedidoItem> itens;    
    @ManyToOne
    private Cliente cliente;
    @Column(precision=38, scale=2)
    private BigDecimal valorFinal;
    
    private void vincularItens() {
    	for (PedidoItem pedidoItem : itens) {
			pedidoItem.setPedido(this);
		}
    }
    
    private void calcularValor() {
    	BigDecimal valor = BigDecimal.ZERO;
    	for (PedidoItem pedidoItem : itens) {
			valor.add(pedidoItem.getValor());
		}
    	valorFinal = valor;
    }
    
	public Pedido() {
		this.itens = new ArrayList<PedidoItem>(); 
	}

	public Pedido(int id, List<PedidoItem> itens, Cliente cliente) {
		super();
		this.id = id;
		this.itens = itens;
		this.cliente = cliente;
		calcularValor();
		vincularItens();
	}
	
	public void addItem(PedidoItem item) {
		item.setPedido(this);
		itens.remove(item);
		itens.add(item);
		calcularValor();		
	}
	
	public void removeItem(PedidoItem item) {
		item.setPedido(null);
		itens.remove(item);
		calcularValor();
	}
	
	public void removerItem(Long codigoItem) {
		for (PedidoItem pedidoItem : itens) {
			if (pedidoItem.getId() == codigoItem) {
				removeItem(pedidoItem);
				return;
			}
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
		calcularValor();
		vincularItens();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Pedido other = (Pedido) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", itens=" + itens + ", cliente=" + cliente + ", valorFinal=" + valorFinal + "]";
	}
	
}
