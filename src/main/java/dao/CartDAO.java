package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Cart;
import utils.JpaUtil;

public class CartDAO {
private EntityManager em;
	
	public CartDAO() {
		this.em = JpaUtil.getEntityManager();
	}
	public List<Cart> all() {
		String jpql="SELECT obj FROM Cart obj";
		TypedQuery<Cart> query=this.em.createQuery(jpql,Cart.class);
		List<Cart> ds=query.getResultList(); 
		return ds;
	}
	
	public List<Cart> all1() {
		String jpql="SELECT obj FROM Cart obj WHERE obj.trangThai!=0";
		TypedQuery<Cart> query=this.em.createQuery(jpql,Cart.class);
		List<Cart> ds=query.getResultList(); 
		return ds;
	}
	public Cart findById(int id) {
		Cart entity=this.em.find(Cart.class, id);
		return entity;
	}
	
	public List<Cart> findByUserId(int id) {
		String jpql="SELECT obj FROM Cart obj WHERE obj.userId=:id";
		TypedQuery<Cart> query=this.em.createQuery(jpql,Cart.class);
		query.setParameter("id", id);
		List<Cart> ds=query.getResultList(); 
		return ds;
	}
	public List<Cart> findByUserId0(int id) {
		String jpql="SELECT obj FROM Cart obj WHERE obj.userId=:id AND obj.trangThai=0";
		TypedQuery<Cart> query=this.em.createQuery(jpql,Cart.class);
		query.setParameter("id", id);
		List<Cart> ds=query.getResultList(); 
		return ds;
	}
	public List<Cart> findByUserIdkhac0(int id) {
		String jpql="SELECT obj FROM Cart obj WHERE obj.userId=:id AND obj.trangThai!=0";
		TypedQuery<Cart> query=this.em.createQuery(jpql,Cart.class);
		query.setParameter("id", id);
		List<Cart> ds=query.getResultList(); 
		return ds;
	}

	public Cart create(Cart entity) throws Exception{
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
	public Cart update(Cart entity) throws Exception{
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
	public Cart delete(Cart entity) throws Exception{
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
