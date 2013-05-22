package org.cejug.cc_jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.cejug.cc_jsf.pojo.Produto;

@ManagedBean(name = "produtoBean")
@RequestScoped
public class ProdutoBean {

	private Produto produto = new Produto();

	public String cadastro() {
		return "sucesso";
	}

	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
