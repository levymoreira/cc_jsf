package org.cejug.cc_jsf.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.cejug.cc_jsf.pojo.Produto;

/**
 * Teste simples pra verificar se o funcionamento do Derby esta ok.
 * Remover quando o módulo web estiver implementado.
 * 
 * @author Levy Moreira
 *
 */
public class TesteSimples {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cc_jsf_persistence_unit");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			Produto a = new Produto();	
			a.setId(1);
			a.setNome("Produto");
			a.setDataDeCadastro(new Date());
			em.persist(a);
			System.out.println("Produto Cadastrado: " + a.getId());
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		
	}

}
