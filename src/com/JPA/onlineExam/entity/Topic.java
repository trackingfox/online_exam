package com.JPA.onlineExam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Topic")
public class Topic {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((titletopic == null) ? 0 : titletopic.hashCode());
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
		Topic other = (Topic) obj;
		if (Id != other.Id)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (titletopic == null) {
			if (other.titletopic != null)
				return false;
		} else if (!titletopic.equals(other.titletopic))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;

//	@ManyToMany
//	private List<TestPaper> TestPapers;

	// private List<AttemptedTest> TestAttempted;
	private String titletopic;
	private String content;

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getTitletopic() {
		return titletopic;
	}

	public void setTitletopic(String titletopic) {
		this.titletopic = titletopic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Topic [Id=" + Id + ", titletopic=" + titletopic + ", content=" + content + "]";
	}

}
