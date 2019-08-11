package edu.ifpb.dac.controladores;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.ifpb.dac.model.entidades.PedidoItem;
import edu.ifpb.dac.services.PedidoService;

/**
 *
 * @author ericl
 */
@SuppressWarnings("serial")
@ViewScoped
@Named
public class PedidoController implements Serializable {

    @Inject
    private PedidoService service;
    private String codigoProduto;
    private String cpfCliente;
    
    public String inserirProduto() {
    	service.incluirItem(this.codigoProduto);
    	this.codigoProduto = "";
    	return "";
    }
    
    public String excluirProduto(PedidoItem pedidoItem) {
    	service.removerItem(pedidoItem.getId());
    	return "";
    }
    
    public String finalizarPedido() {
    	if (!service.informarClientePeloCpf(cpfCliente))
    		return null;
    	service.efetuarPedido(); 
    	cpfCliente = "";
    	return "";
    }
    
    public List<PedidoItem> getListaItens(){
    	return service.listarItens();
    }
    
    public Double getTotalPedido () {
    	return service.totalPedido().doubleValue();
    }

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	

}
