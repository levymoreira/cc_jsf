package org.cejug.cc_jsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.cejug.cc_jsf.dao.ProdutoDAO;
import org.cejug.cc_jsf.pojo.Produto;

/**
 * ManegedBean para gerenciar as páginas de listagem e edição/cadastro de produto.
 * 
 */ 
//Mapeamento via annotation
@ManagedBean(name = "produtoBean") // produtoBean representará a classe ProdutoBean, caso campo name nao fosse declarado a classe ProdutoBean seria representado por seu proprio nome em minusculo (produtoBean)
@RequestScoped //menor escorpo do JSF
public class ProdutoBean {

	// Propriedades
	
	/**
	 * Instancia da classe Produto para acessar os atributos da classe
	 * Representa o produto selecionado atualmente para editar, deletar ou alterar
	 */ 
	private Produto produtoSelecionado = new Produto(); 

	/**
	 * instancia da classe ProdutoDAO para salvar,alterar,deletar e listar os objetos	 * 
	 */ 
	private ProdutoDAO produtoDAO = new ProdutoDAO();

	/**
	 * Lista de produtos, usada para exibir a listagem no dataTable do JSF 
	 */ 
	private List<Produto> lista = null; 

	// Constantes
	
	/**
	 * Redirecionamento para a página listagem e cadastro, usando constantes para facilitar a manutenção
	 */ 
	private final String PAGINA_LISTAGEM = "listagem?faces-redirect=true";
	private final String PAGINA_CADASTRO = "cadastro"; 

	// Construtor Padrão sem argumentos

	public ProdutoBean() {
	}

	// Métodos

	/**
	 * Método responsável por salvar (caso seja um novo registro) ou alterar (caso o registro já exista na base) um produto
	 */ 
	public String salvar() {
		produtoDAO.salvarOuAlterar(produtoSelecionado); //usa o  método salvarOuAlterar da classe produtoDAO para salvar o produto selecionado
		return PAGINA_LISTAGEM; //após de salvar, retorna a página de listagem dos produtos
	}

	public String inserir() {	//método inserir o produto na pagina cadastro
		produtoSelecionado = new Produto(); //instancia a classe produto para cadastro produto
		return PAGINA_CADASTRO; //retorna a página de cadastro/alteração do produto
	}
	
	public String editar() { //método para editar o produto cadastrado		
		return PAGINA_CADASTRO; //retorna a página de cadastro/alteração do produto
	}

	public String cancelar() { //metodo para cancelar o cadastramento do produto
		return PAGINA_LISTAGEM; //não salvar nada e retorna para a página de listagem dos produtos
	}	
	
	public String deletar(){ //metodo para deletar o produto
		produtoDAO.deletar(produtoSelecionado); //chama o metodo deletar da classe produtoDAO para deletar o produto selecionado
		return PAGINA_LISTAGEM; //retorna a pagina listagem dos produtos
	}

	// Getters e Setters
	// Os get e set abaixo são necessários para que o JSF consiga pegar os valores do maneged bean e carregar na página e vice versa

	/**
	 * Retorna a lista de produtos que será exibida no data table, caso a lista esteja null é carregada 
	 * através do método getTodos da classe ProdutoDAO
	 */ 
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
