package colarinhobranco.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import colarinhobranco.dao.UserDao;
import colarinhobranco.model.News;
import colarinhobranco.model.User;
import colarinhobranco.util.JPAUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User save(User user) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(user);
			manager.flush();
			transaction.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			
			if (transaction.isActive()) {
				transaction.rollback();
			}
			
			return null;			
		} finally {
			manager.close();
		}
		
	}

	@Override
	public User get(Integer id) {
EntityManager manager = new JPAUtil().getEntityManager();
		
		try {
			return manager.find(User.class, id);
		} finally {
			manager.close();
		}
	}

	@Override
	public List<User> findAll() {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		try {
			return manager.createQuery("select n from User n", User.class).getResultList();
		} finally {
			manager.close();
		}
	}

}
