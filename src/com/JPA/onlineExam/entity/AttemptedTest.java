package com.JPA.onlineExam.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "AttemptedTest")
public class AttemptedTest extends MyTest {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "testId")
//	private int testId;
//
//	@Column(name = "testName")
//	private String testName;
//
//	@Column(name = "testLevel")
//	private String testLevel;

	@Column(name = "user_ans")
	private String user_ans;

	@Column(name = "finalScore")
	private int finalScore;

	private List<Question> questionPaper;

	public String getUser_ans() {
		return user_ans;
	}

	public void setUser_ans(String user_ans) {
		this.user_ans = user_ans;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

//	public int getTestId() {
//		return testId;
//	}
//
//	public void setTestId(int testId) {
//		this.testId = testId;
//	}
//
//	public String getTestName() {
//		return testName;
//	}
//
//	public void setTestName(String testName) {
//		this.testName = testName;
//	}
//
//	public String getTestLevel() {
//		return testLevel;
//	}
//
//	public void setTestLevel(String testLevel) {
//		this.testLevel = testLevel;
//	}

	// method to calculate finalscore

	// key value pair for question and answer.

}
