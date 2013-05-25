package org.cejug.cc_jsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.cejug.cc_jsf.dao.ProdutoDAO;
import org.cejug.cc_jsf.pojo.Produto;

@ManagedBean(name = "produtoBean")
@RequestScoped
public class ProdutoBean {

	// Propriedades

	private Produto produtoSelecionado = new Produto();

	private ProdutoDAO produtoDAO = new ProdutoDAO();

	private List<Produto> lista = null;

	// Constantes

	private final String PAGINA_LISTAGEM = "listagem?faces-redirect=true";
	private final String PAGINA_CADASTRO = "cadastro"; 											

	// Contrutores

	public ProdutoBean() {
	}

	// Métodos

	public String salvar() {	
		produtoDAO.salvarOuAlterar(produtoSelecionado);
		return PAGINA_LISTAGEM;
	}

	public String inserir() {	
		produtoSelecionado = new Produto();
		return PAGINA_CADASTRO;
	}

	public String editar() {		
		return PAGINA_CADASTRO;
	}

	public String cancelar() {
		return PAGINA_LISTAGEM;
	}	
	
	public String deletar(){
		produtoDAO.deletar(produtoSelecionado);
		return PAGINA_LISTAGEM;
	}

	// Getters e Setters

	public List<Produto> getLista() {
		if (lista == null) {
			lista = produtoDAO.getTodos();
		}
		return lista;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
}
