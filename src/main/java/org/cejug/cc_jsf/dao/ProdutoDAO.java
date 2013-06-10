package org.cejug.cc_jsf.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.cejug.cc_jsf.pojo.Produto;

/**
 * Classe responsável por fazer as operações básicas de CRUD com a classe produto
 *
 */
public class ProdutoDAO {
	
	/**
	 * O EntityManager é uma API que nos da a possibilidade de realizar as operações de salvar, deletar, e prover
	 * meios de consulta para gerenciar uma entidade (ex: neste caso a entidade é o produto).
	 * 
	 */
	private EntityManager entityManager = null;
	
	//Construtor
	
	/**
	 * Ao instanciar a classe ProdutoDAO o EntityManager é instanciado.
	 * A classe EntityManagerUtil retorna uma fábrica de entity manager que é o responsável por criar 
	 * instancias de EntityManagar, veja a classe EntityManagerUtil.
	 * 
	 */
	public ProdutoDAO() { 
		entityManager = EntityManagerUtil.getEntityManagerFacotory().createEntityManager(); 
	}
	
	/**
	 * Salvar ou alterar um produto
	 * 
	 * @param produto
	 */
	public void salvarOuAlterar(Produto produto) { 
		entityManager.getTransaction().begin(); //inicia uma transação com o banco
		if (produto.getDataDeCadastro() == null) { //caso o getDataDeCadastro seja null, retorna a data atual
			produto.setDataDeCadastro(new Date());
			entityManager.persist(produto); //inserir os produtos declarado nos campos
		}else{
			entityManager.merge(produto); //devolve o objeto para ser preenchido
		}
		entityManager.getTransaction().commit(); //retorna a transação e faz o commit para o banco
	}

	/**
	 * Deletar um produto
	 * 
	 * @param produto
	 */
	public void deletar(Produto produto) { 
		entityManager.getTransaction().begin(); //inicia uma transação com o banco
		entityManager.remove(produto); //remove o produto
		entityManager.getTransaction().commit(); //retorna a transação e faz o commit para o banco
	}

	/**
	 * Retorna uma lista com todos produtos cadastrados
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Produto> getTodos() { 
		Query query = entityManager.createQuery("SELECT p FROM Produto p"); //retorna todos os produtos do banco utilizando a lingaugem JPQL de consulta do JPA
		return query.getResultList(); //mostra o resultado da lista de produtos cadastro no banco
	} 

}
