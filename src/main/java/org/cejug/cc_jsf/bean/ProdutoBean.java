package org.cejug.cc_jsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.cejug.cc_jsf.dao.ProdutoDAO;
import org.cejug.cc_jsf.pojo.Produto;

//Mapeamento via annotation
@ManagedBean(name = "produtoBean") // produtoBean representará a classe ProdutoBean, caso campo name nao fosse declarado a classe ProdutoBean seria representado por seu proprio nome em minusculo (produtoBean)
@RequestScoped //esse tipo de scoped descarta as informações que são armazenada no managedbean
public class ProdutoBean {

	// Propriedades

	private Produto produtoSelecionado = new Produto(); //instancia da classe Produto para acessar os atributos da classe

	private ProdutoDAO produtoDAO = new ProdutoDAO(); //instancia da classe ProdutoDAO para salvar,alterar,deletar e listar os objetos

	private List<Produto> lista = null; //Cria uma lista de produto 

	// Constantes

	private final String PAGINA_LISTAGEM = "listagem?faces-redirect=true"; //redirecionamento para a pagina listagem
	private final String PAGINA_CADASTRO = "cadastro"; //redirecionamento para a pagina cadastro				

	// Construtor Padrão sem argumento

	public ProdutoBean() {
	}

	// Métodos

	public String salvar() { //metodo salvar ou alterar	
		produtoDAO.salvarOuAlterar(produtoSelecionado); //chama a classe produtoDAO e o metodo salvarOuAlterar e passa o produtoSelecionado para ser salvo/alterado no banco
		return PAGINA_LISTAGEM; //depois de salvar/alterar, retorna a pagina listagem dos produtos
	}

	public String inserir() {	//metodo inserir o produto na pagina cadastro
		produtoSelecionado = new Produto(); //instancia a classe produto para cadastro produto
		return PAGINA_CADASTRO; //retorna a pagina cadastro 
	}
	
	public String editar() { //metodo para editar o produto cadastrado		
		return PAGINA_CADASTRO; //retorna a pagina cadastro
	}

	public String cancelar() { //metodo para cancelar o cadastramento do produto
		return PAGINA_LISTAGEM; //retorna pagina listagem dos produtos
	}	
	
	public String deletar(){ //metodo para deletar o produto cadastrado
		produtoDAO.deletar(produtoSelecionado); //chama a classe produtoDAO, o metodo deletar, para deletar algum produto do banco
		return PAGINA_LISTAGEM; //retorna a pagina listagem dos produtos
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
