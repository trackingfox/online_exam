package com.JPA.onlineExam.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AttemptedTest")
public class AttemptedTest extends MyTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sl_no")
	private int sl_no;

	@Column(name = "user_ans")
	private String user_ans;

	@Column(name = "finalScore")
	private int finalScore;

	Map<Question, String> hashmap = new HashMap<Question, String>();

	public String getUser_ans() {
		return user_ans;
	}

	public void setUser_ans(String user_ans) {

		this.user_ans = user_ans;
	}

	// method to calculate finalscore
	public int calculateFinalScore() {
		for (Question obj : getQuestionSet()) {
			if (obj.getAnswer() == user_ans) {
				finalScore += 1;
			}
		}
		return finalScore;
	}

	// key value pair for question and answer.
	public Map testAnswers() {
		for (Question obj : getQuestionSet()) {
			hashmap.put(obj, user_ans);
		}

		return hashmap;

	}

}
