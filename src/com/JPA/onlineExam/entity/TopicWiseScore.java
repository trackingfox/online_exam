package com.JPA.onlineExam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TopicWiseScore")
public class TopicWiseScore {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
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
		TopicWiseScore other = (TopicWiseScore) obj;
		if (Id != other.Id)
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@OneToOne
	private Topic topic;

	@OneToOne
	private Score score;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

}
