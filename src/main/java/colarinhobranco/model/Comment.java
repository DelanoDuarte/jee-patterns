/**
 * 
 */
package colarinhobranco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Delano Jr
 *
 */
@Entity
@Table(name = "tb_comment")
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "comments_seq", sequenceName = "comment_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_seq")
	@Column()
	private Long id;

	@Column(nullable = false, name = "comment", length = 1000)
	private String comment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_news")
	private News news;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((news == null) ? 0 : news.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (news == null) {
			if (other.news != null)
				return false;
		} else if (!news.equals(other.news))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", news=" + news + "]";
	}

}
