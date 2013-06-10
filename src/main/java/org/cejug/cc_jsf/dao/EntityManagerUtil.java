package org.cejug.cc_jsf.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Esta classe gerência o objeto EntityManagerFactory, é usado o padrão Singleton garantindo uma
 * única instância do objeto em toda a aplicação.
 *
 */
public class EntityManagerUtil {
	
	/**
	 * Classe responsável por criar (fabricar) EntityManagers
	 */
	private static EntityManagerFactory entityManagerFactory = null;
	
	//Construtor Padrão sem argumentos
	public EntityManagerUtil(){}
	
	/**
	 * Para criar a instância de EntityManagerFactory é usado o arquivo persistence.xml que contém as configurações do 
	 * banco de dados a ser utilizado, dentro deste arquivo de configuração é definido um nome para a propriedade
	 * persistence unit, este nome é passado na criacão do EntityManagerFactory.
	 * 
	 * @return
	 */
	public static EntityManagerFactory getEntityManagerFacotory(){
		if(entityManagerFactory == null){
			entityManagerFactory = Persistence.createEntityManagerFactory("cc_jsf_persistence_unit");
		}
		return entityManagerFactory;
	}
	
}
