package org.cejug.cc_jsf.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.cejug.cc_jsf.pojo.Produto;

public class ProdutoDAO {
	
	private EntityManager entityManager = null;
	
	public ProdutoDAO() {
		entityManager = EntityManagerUtil.getEntityManagerFacotory().createEntityManager();
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

	@SuppressWarnings("unchecked")
	public List<Produto> getTodos() {
		Query query = entityManager.createQuery("SELECT p FROM Produto p");
		return query.getResultList();
	}

}
