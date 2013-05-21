package org.cejug.cc_jsf.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.cejug.cc_jsf.pojo.Produto;

public class ProdutoDAO {

	private EntityManager entityManager;
	
	public ProdutoDAO() {
	}
	
	public ProdutoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void salvarOuAlterar(Produto produto) {
		entityManager.getTransaction().begin();
		if (produto.getDataDeCadastro() == null) {
			produto.setDataDeCadastro(new Date());
			entityManager.persist(produto);
		}else{
			entityManager.merge(produto);
		}
		entityManager.getTransaction().commit();
	}

	public void deletar(Produto produto) {
		entityManager.getTransaction().begin();
		entityManager.remove(produto);
		entityManager.getTransaction().commit();
	}

	public Produto getById(int id) {
		entityManager.getTransaction().begin();
		Produto produto = entityManager.find(Produto.class, id);
		entityManager.getTransaction().commit();
		return produto;
	}

	@SuppressWarnings("unchecked")
	public List<Produto> getAll() {
		Query query = entityManager.createQuery("SELECT p FROM Produtos p");
		return query.getResultList();
	}

}
