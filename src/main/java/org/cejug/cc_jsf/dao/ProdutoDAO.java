package org.cejug.cc_jsf.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.cejug.cc_jsf.pojo.Produto;

public class ProdutoDAO {
	
	private EntityManager entityManager = null;
	
	//Construtor
	
	public ProdutoDAO() { 
		entityManager = EntityManagerUtil.getEntityManagerFacotory().createEntityManager(); 
	}
	
	public void salvarOuAlterar(Produto produto) { //metodo salvar/alterar produto
		entityManager.getTransaction().begin(); //inicia uma transação com o banco
		if (produto.getDataDeCadastro() == null) { //caso o getDataDeCadastro seja null, retorna a data atual
			produto.setDataDeCadastro(new Date());
			entityManager.persist(produto); //inserir os produtos declarado nos campos
		}else{
			entityManager.merge(produto); //devolve o objeto para ser preenchido
		}
		entityManager.getTransaction().commit(); //retorna a transação e faz o commit para o banco
	}

	public void deletar(Produto produto) { //metodo deleta produto
		entityManager.getTransaction().begin(); //inicia uma transação com o banco
		entityManager.remove(produto); //remove o produto
		entityManager.getTransaction().commit(); //retorna a transação e faz o commit para o banco
	}

	@SuppressWarnings("unchecked")
	public List<Produto> getTodos() { //metodo lista dos produtos
		Query query = entityManager.createQuery("SELECT p FROM Produto p"); //retorna todos os produtos do banco utilizando a lingaugem JPQL de consulta do JPA
		return query.getResultList(); //mostra o resultado da lista de produtos cadastro no banco
	} 

}
