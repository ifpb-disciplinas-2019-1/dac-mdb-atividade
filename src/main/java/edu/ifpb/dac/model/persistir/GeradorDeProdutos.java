package edu.ifpb.dac.model.persistir;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import edu.ifpb.dac.model.dao.interfaces.ProdutoDAO;
import edu.ifpb.dac.model.entidades.Produto;

@Startup
@Singleton
public class GeradorDeProdutos {
	
	@Inject
	private ProdutoDAO produtoDAO;
	
	@PostConstruct
	private void init() {
		produtoDAO.save(new Produto("Tv LG",BigDecimal.valueOf(1500.0)));
		produtoDAO.save(new Produto("Som",BigDecimal.valueOf(850.0)));
		produtoDAO.save(new Produto("Fogão",BigDecimal.valueOf(450.0)));
		produtoDAO.save(new Produto("Notebook",BigDecimal.valueOf(2500.0)));
		produtoDAO.save(new Produto("Smartphone",BigDecimal.valueOf(1250.0)));
		produtoDAO.save(new Produto("Xiaomi Hifi Sound",BigDecimal.valueOf(129.88)));
		produtoDAO.save(new Produto("Parafusadeira e Furadeira Philco",BigDecimal.valueOf(139.99)));
		produtoDAO.save(new Produto("Servidor HPE ISS Microserver Gen10",BigDecimal.valueOf(2300.0)));
		produtoDAO.save(new Produto("Notebook Gamer Aspire AN515-51-50U2",BigDecimal.valueOf(3778.26)));
		produtoDAO.save(new Produto("Camera Digital 720p 16x Zoom",BigDecimal.valueOf(145.92)));
		produtoDAO.save(new Produto("Roteador Dell",BigDecimal.valueOf(849.99)));
		produtoDAO.save(new Produto("Câmera Externa De Segurança Wi-fi Full Hd Com Infravermelho",BigDecimal.valueOf(499.90)));
		produtoDAO.save(new Produto("Roteador Wireless N 300mbps Iwr 3000n",BigDecimal.valueOf(74.99)));
		produtoDAO.save(new Produto("Roteador Mesh Twibi Giga",BigDecimal.valueOf(469.99)));
		produtoDAO.save(new Produto("Lf606 Mini Drone Com Câmera",BigDecimal.valueOf(100.62)));
		produtoDAO.save(new Produto("Xb950 Bluetooth Fone De Ouvido",BigDecimal.valueOf(104.14)));
		produtoDAO.save(new Produto("Sweatproof Smarcent X9 De Metal Bluetooth",BigDecimal.valueOf(155.54)));
		produtoDAO.save(new Produto("Geladeira/Refrigerador 500L - Inox",BigDecimal.valueOf(3129.99)));
		produtoDAO.save(new Produto("Microondas Lg Ms3059La 30L",BigDecimal.valueOf(435.53)));
		produtoDAO.save(new Produto("Smart TV LED 40\" Samsung Ultra HD",BigDecimal.valueOf(1665.02)));
		produtoDAO.save(new Produto("Lavadora de Roupas Brastemp 11kg",BigDecimal.valueOf(1448.99)));
		produtoDAO.save(new Produto("Kit Ferramentas Sparta 129 Peças",BigDecimal.valueOf(69.90)));
		produtoDAO.save(new Produto("Lavadora de alta pressão 2.000 libra",BigDecimal.valueOf(1288.00)));
		produtoDAO.save(new Produto("Kit Premium Wine Philco com Liquidificador",BigDecimal.valueOf(294.41)));
		produtoDAO.save(new Produto("Pneu Aro 14\" Firestone 175/65R14",BigDecimal.valueOf(312.00)));
		produtoDAO.save(new Produto("Churrasqueira à Carvão",BigDecimal.valueOf(94.91)));
		produtoDAO.save(new Produto("Caixa de Som Bluetooth JBL",BigDecimal.valueOf(389.00)));
		produtoDAO.save(new Produto("Impressora Multifuncional",BigDecimal.valueOf(314.91)));
		produtoDAO.save(new Produto("Guarda-roupa Casal",BigDecimal.valueOf(552.95)));
		produtoDAO.save(new Produto("Aparelho de Barbear",BigDecimal.valueOf(98.90)));
	}

}
