package com.JPA.onlineExam.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TestPaper")
public class TestPaper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;

	@Column(name = "testName")
	private String testName;

	@Column(name = "testLevel")
	private String testLevel;

	@ManyToMany
	private List<Topic> topics;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((questionSet == null) ? 0 : questionSet.hashCode());
		result = prime * result + ((testLevel == null) ? 0 : testLevel.hashCode());
		result = prime * result + ((testName == null) ? 0 : testName.hashCode());
		result = prime * result + ((topics == null) ? 0 : topics.hashCode());
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
		TestPaper other = (TestPaper) obj;
		if (Id != other.Id)
			return false;
		if (questionSet == null) {
			if (other.questionSet != null)
				return false;
		} else if (!questionSet.equals(other.questionSet))
			return false;
		if (testLevel == null) {
			if (other.testLevel != null)
				return false;
		} else if (!testLevel.equals(other.testLevel))
			return false;
		if (testName == null) {
			if (other.testName != null)
				return false;
		} else if (!testName.equals(other.testName))
			return false;
		if (topics == null) {
			if (other.topics != null)
				return false;
		} else if (!topics.equals(other.topics))
			return false;
		return true;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Question> questionSet;

	public List<Question> getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(List<Question> questionSet) {
		this.questionSet = questionSet;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestLevel() {
		return testLevel;
	}

	public void setTestLevel(String testLevel) {
		this.testLevel = testLevel;
	}

	@Override
	public String toString() {
		return "TestPaper [Id=" + Id + ", testName=" + testName + ", testLevel=" + testLevel + ", topics=" + topics
				+ ", questionSet=" + questionSet + "]";
	}

}
