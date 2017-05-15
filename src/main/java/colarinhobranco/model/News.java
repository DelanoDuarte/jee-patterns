package colarinhobranco.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_news")
public class News implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "news_seq", sequenceName = "news_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_seq")
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "date")
	private Date date;

	@Column(name = "headline_content")
	private String headlineContent;

	@Column(name = "headline_image")
	private String headlineImage;

	@Column(name = "content", length = 3000)
	private String content;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Comment> comments;

	@Column
	private Integer likes;

	public News() {
		super();
	}

	public News(String title, Date date, String headlineContent, String headlineImage, String content) {
		super();
		this.title = title;
		this.date = date;
		this.headlineContent = headlineContent;
		this.headlineImage = headlineImage;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHeadlineContent() {
		return headlineContent;
	}

	public void setHeadlineContent(String headlineContent) {
		this.headlineContent = headlineContent;
	}

	public String getHeadlineImage() {
		return headlineImage;
	}

	public void setHeadlineImage(String headlineImage) {
		this.headlineImage = headlineImage;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((headlineContent == null) ? 0 : headlineContent.hashCode());
		result = prime * result + ((headlineImage == null) ? 0 : headlineImage.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((likes == null) ? 0 : likes.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		News other = (News) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (headlineContent == null) {
			if (other.headlineContent != null)
				return false;
		} else if (!headlineContent.equals(other.headlineContent))
			return false;
		if (headlineImage == null) {
			if (other.headlineImage != null)
				return false;
		} else if (!headlineImage.equals(other.headlineImage))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (likes == null) {
			if (other.likes != null)
				return false;
		} else if (!likes.equals(other.likes))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", date=" + date + ", headlineContent=" + headlineContent
				+ ", headlineImage=" + headlineImage + ", content=" + content + ", comments=" + comments + ", likes="
				+ likes + "]";
	}

}