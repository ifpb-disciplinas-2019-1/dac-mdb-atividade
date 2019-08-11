package edu.ifpb.dac.controladores;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.ifpb.dac.model.entidades.PedidoItem;
import edu.ifpb.dac.services.PedidoService;

/**
 *
 * @author ericl
 */
@SuppressWarnings("serial")
@RequestScoped
@Named
public class PedidoController implements Serializable {

    @Inject
    private PedidoService service;
    private String codigoProduto;
    
    public String inserirProduto() {
    	service.incluirItem(this.codigoProduto);
    	this.codigoProduto = "";
    	return "";
    }
    
    public String excluirProduto(PedidoItem pedidoItem) {
    	service.removerItem(pedidoItem.getId());
    	return "";
    }
    
    public List<PedidoItem> listaItens(){
    	return service.listarItens();
    }
    
    public Double totalPedido () {
    	return service.totalPedido().doubleValue();
    }

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

}
