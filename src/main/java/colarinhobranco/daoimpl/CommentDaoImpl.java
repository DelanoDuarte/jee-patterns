/**
 * 
 */
package colarinhobranco.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import colarinhobranco.dao.CommentDao;
import colarinhobranco.model.Comment;
import colarinhobranco.util.JPAUtil;

/**
 * @author Delano Jr
 *
 */
@SuppressWarnings("unchecked")
public class CommentDaoImpl implements CommentDao {

	@Override
	public Comment salvar(Comment comment) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.merge(comment);
			manager.flush();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();

			if (transaction.isActive()) {
				transaction.rollback();
			}

		} finally {

			manager.close();
		}

		return null;
	}

	@Override
	public List<Comment> buscarCommentariosPorPost(Integer id) {

		EntityManager manager = new JPAUtil().getEntityManager();

		try {
			return manager.createQuery("select c from Comment c where c.news.id = :idNews").setParameter("idNews", id)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return null;
	}

}
