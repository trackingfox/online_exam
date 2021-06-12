package com.JPA.onlineExam.entity;

import java.util.ArrayList;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class Question {

	@Id
	private int Qid;
	private String question;
	private ArrayList<String> choices;
	private String answer;

	@ManyToOne
	private MyTest test;

	public Question(String question, String[] choices, String answer) {
		this.question = question;
		this.choices = new ArrayList<String>();
		for (int i = 0; i < choices.length; i++) {
			this.choices.add(choices[i]);
		}

		// make sure each test shows questions in different order
		Collections.shuffle(this.choices);
		this.answer = answer;
	}

	public Question() {

	}

	public int getQid() {
		return Qid;
	}

	public void setQid(int qid) {
		Qid = qid;
	}

//	public MyTest getTest() {
//		return test;
//	}
//
//	public void setTest(MyTest test) {
//		this.test = test;
//	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public ArrayList<String> getChoices() {
		return choices;
	}

	public String getAnswer() {
		return answer;
	}

}
