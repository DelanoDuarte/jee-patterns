/**
 * 
 */
package colarinhobranco.dao;

import java.util.List;

import colarinhobranco.model.Comment;

/**
 * @author Delano Jr
 *
 */
public interface CommentDao {

	public Comment salvar(Comment comment);

	public List<Comment> buscarCommentariosPorPost(Integer id);
}
