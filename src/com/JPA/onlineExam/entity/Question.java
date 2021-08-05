package com.JPA.onlineExam.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
@Entity
@Table(name = "Question")
public class Question {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((Question == null) ? 0 : Question.hashCode());
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((choice_1 == null) ? 0 : choice_1.hashCode());
		result = prime * result + ((choice_2 == null) ? 0 : choice_2.hashCode());
		result = prime * result + ((choice_3 == null) ? 0 : choice_3.hashCode());
		result = prime * result + ((choice_4 == null) ? 0 : choice_4.hashCode());
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
		Question other = (Question) obj;
		if (Id != other.Id)
			return false;
		if (Question == null) {
			if (other.Question != null)
				return false;
		} else if (!Question.equals(other.Question))
			return false;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (choice_1 == null) {
			if (other.choice_1 != null)
				return false;
		} else if (!choice_1.equals(other.choice_1))
			return false;
		if (choice_2 == null) {
			if (other.choice_2 != null)
				return false;
		} else if (!choice_2.equals(other.choice_2))
			return false;
		if (choice_3 == null) {
			if (other.choice_3 != null)
				return false;
		} else if (!choice_3.equals(other.choice_3))
			return false;
		if (choice_4 == null) {
			if (other.choice_4 != null)
				return false;
		} else if (!choice_4.equals(other.choice_4))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int Id;
	@Column(length = 3000)
	private String Question;
	@Column(length = 1000)
	private String choice_1;
	@Column(length = 1000)
	private String choice_2;
	@Column(length = 1000)
	private String choice_3;
	@Column(length = 1000)
	private String choice_4;
	@Column(length = 1000)
	private String answer;

	public Question() {

	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		Id = Id;
	}

	public void setQuestion(String question) {
		this.Question = question;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return Question;
	}

	public String getAnswer() {
		return answer;
	}

	public String getChoice_1() {
		return choice_1;
	}

	public void setChoice_1(String choice_1) {
		this.choice_1 = choice_1;
	}

	public String getChoice_2() {
		return choice_2;
	}

	public void setChoice_2(String choice_2) {
		this.choice_2 = choice_2;
	}

	public String getChoice_3() {
		return choice_3;
	}

	public void setChoice_3(String choice_3) {
		this.choice_3 = choice_3;
	}

	public String getChoice_4() {
		return choice_4;
	}

	public void setChoice_4(String choice_4) {
		this.choice_4 = choice_4;
	}

	@Override
	public String toString() {
		return "Question [Id=" + Id + ", Question=" + Question + ", choice_1=" + choice_1 + ", choice_2=" + choice_2
				+ ", choice_3=" + choice_3 + ", choice_4=" + choice_4 + ", answer=" + answer + "]";
	}

}
