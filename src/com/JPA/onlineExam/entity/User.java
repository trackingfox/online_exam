package com.JPA.onlineExam.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.Nullable;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long Id;

	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;

	@ManyToMany
	private List<TestPaper> TestPaperList;

	@OneToMany
	private List<AttemptedTest> attemptTestPaperList;

	// allows nullable
	@Nullable
	@ManyToMany
	private List<User> friends;

	@OneToMany
	private List<DailyActivity> activity;

	@OneToMany
	private List<TopicWiseScore> TopicWiseScoreList;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<TestPaper> getTestPaperList() {
		return TestPaperList;
	}

	public void setTestPaperList(List<TestPaper> testPaperList) {
		TestPaperList = testPaperList;
	}

	public List<AttemptedTest> getAttemptTestPaperList() {
		return attemptTestPaperList;
	}

	public void setAttemptTestPaperList(List<AttemptedTest> attemptTestPaperList) {
		this.attemptTestPaperList = attemptTestPaperList;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<DailyActivity> getActivity() {
		return activity;
	}

	public void setActivity(List<DailyActivity> activity) {
		this.activity = activity;
	}

	public List<TopicWiseScore> getTopicWiseScoreList() {
		return TopicWiseScoreList;
	}

	public void setTopicWiseScoreList(List<TopicWiseScore> topicWiseScoreList) {
		TopicWiseScoreList = topicWiseScoreList;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", userName=" + userName + ", password=" + password + ", TestPaperList="
				+ TestPaperList + ", attemptTestPaperList=" + attemptTestPaperList + ", friends=" + friends
				+ ", activity=" + activity + ", TopicWiseScoreList=" + TopicWiseScoreList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Id ^ (Id >>> 32));
		result = prime * result + ((TestPaperList == null) ? 0 : TestPaperList.hashCode());
		result = prime * result + ((TopicWiseScoreList == null) ? 0 : TopicWiseScoreList.hashCode());
		result = prime * result + ((activity == null) ? 0 : activity.hashCode());
		result = prime * result + ((attemptTestPaperList == null) ? 0 : attemptTestPaperList.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		User other = (User) obj;
		if (Id != other.Id)
			return false;
		if (TestPaperList == null) {
			if (other.TestPaperList != null)
				return false;
		} else if (!TestPaperList.equals(other.TestPaperList))
			return false;
		if (TopicWiseScoreList == null) {
			if (other.TopicWiseScoreList != null)
				return false;
		} else if (!TopicWiseScoreList.equals(other.TopicWiseScoreList))
			return false;
		if (activity == null) {
			if (other.activity != null)
				return false;
		} else if (!activity.equals(other.activity))
			return false;
		if (attemptTestPaperList == null) {
			if (other.attemptTestPaperList != null)
				return false;
		} else if (!attemptTestPaperList.equals(other.attemptTestPaperList))
			return false;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}
