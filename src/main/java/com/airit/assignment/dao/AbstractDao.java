package com.airit.assignment.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}
	
	public void update(String s, T entity) {
		getSession().update(s,entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	@SuppressWarnings("deprecation")
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}
	
	@SuppressWarnings("deprecation")
	protected Criteria createEntityCriteria(String s){
		return getSession().createCriteria(persistentClass,s);
	}
	
	

}
