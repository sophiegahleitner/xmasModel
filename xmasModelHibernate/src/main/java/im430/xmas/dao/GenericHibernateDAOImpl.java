package im430.xmas.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class GenericHibernateDAOImpl<T> implements GenericDAO<T> {

	private Class<T> persistentClass;
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	public GenericHibernateDAOImpl(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOrUpdate(T entity) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public T getById(int id) {
		return this.sessionFactory.getCurrentSession().load(getPersistentClass(),id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return (List<T>)this.sessionFactory.getCurrentSession().createQuery("from "+getPersistentClass().getName()).list();
	}

	@Override
	public void delete(T entity) {
		this.sessionFactory.getCurrentSession().delete(entity);
	}
}
