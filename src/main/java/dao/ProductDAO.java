package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Product;
import utils.JpaUtil;

public class ProductDAO {
private EntityManager em;
	
	public ProductDAO() {
		this.em = JpaUtil.getEntityManager();
	}
	public List<Product> all() {
		String jpql="SELECT obj FROM Product obj";
		TypedQuery<Product> query=this.em.createQuery(jpql,Product.class);
		List<Product> ds=query.getResultList(); 
		return ds;
	}
	public Product findById(int id) {
		Product entity=this.em.find(Product.class, id);
		return entity;
	}
	
	public List<Product> findByCategoryId(int id) {
		String jpql="SELECT obj FROM Product obj INNER JOIN obj.category c WHERE c.id=:id";
		TypedQuery<Product> query=this.em.createQuery(jpql,Product.class);
		query.setParameter("id", id);
		List<Product> ds=query.getResultList(); 
		return ds;
	}

	public Product create(Product entity) throws Exception{
		try {
			this.em.getTransaction().begin();
			this.em.persist(entity);
			this.em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			throw e;
		}
	}
	public Product update(Product entity) throws Exception{
		try {
			this.em.getTransaction().begin();
			this.em.merge(entity);
			this.em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			throw e;
		}
	}
	public Product delete(Product entity) throws Exception{
		try {
			this.em.getTransaction().begin();
			this.em.remove(entity);
			this.em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			throw e;
		}
	}
}
