package org.cejug.cc_jsf.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	
	private static EntityManagerFactory entityManagerFactory = null;
	
	public EntityManagerUtil(){}
	
	public static EntityManagerFactory getEntityManagerFacotory(){
		if(entityManagerFactory == null){
			entityManagerFactory = Persistence.createEntityManagerFactory("cc_jsf_persistence_unit");
		}
		return entityManagerFactory;
	}
	
}
