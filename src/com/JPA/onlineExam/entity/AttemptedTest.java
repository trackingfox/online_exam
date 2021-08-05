package com.JPA.onlineExam.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AttemptedTest")
public class AttemptedTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;

//	@Column(name = "user_ans")
//	private char user_ans;

	@Column(name = "finalScore")
	private int finalScore;

	@ManyToOne
	private TestPaper test;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + finalScore;
		result = prime * result + ((questionAnswersSet == null) ? 0 : questionAnswersSet.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((test == null) ? 0 : test.hashCode());
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
		AttemptedTest other = (AttemptedTest) obj;
		if (Id != other.Id)
			return false;
		if (finalScore != other.finalScore)
			return false;
		if (questionAnswersSet == null) {
			if (other.questionAnswersSet != null)
				return false;
		} else if (!questionAnswersSet.equals(other.questionAnswersSet))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (test == null) {
			if (other.test != null)
				return false;
		} else if (!test.equals(other.test))
			return false;
		return true;
	}

	@OneToOne
	private Score score;

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	@ElementCollection
	private Map<Question, Character> questionAnswersSet;

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public TestPaper getTest() {
		return test;
	}

	public void setTest(TestPaper test) {
		this.test = test;
	}

//	public char getUser_ans() {
//		return user_ans;
//	}
//
//	public void setUser_ans(char user_ans) {
//
//		this.user_ans = user_ans;
//	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

	public Map<Question, Character> getQuestionAnswersSet() {
		return questionAnswersSet;
	}

	public void setQuestionAnswersSet(Map<Question, Character> questionAnswersSet) {
		this.questionAnswersSet = questionAnswersSet;
	}

	@Override
	public String toString() {
		return "AttemptedTest [Id=" + Id + ", finalScore=" + finalScore + ", questionAnswersSet=" + questionAnswersSet
				+ "]";
	}

}
