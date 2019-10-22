package com.lti.vehicleloan.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class GenericDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void upsert(Object obj) {
		entityManager.persist(obj);
	}
	
	public Object fetchById(Class clazz,Object pk) {
		return entityManager.find(clazz, pk);
	}
	
	
	

}
