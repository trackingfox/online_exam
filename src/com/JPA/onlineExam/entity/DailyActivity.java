package com.JPA.onlineExam.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DailyActivity")
public class DailyActivity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ActId")
	private int ActId;
	private Date day;

	@Override
	public String toString() {
		return "DailyActivity [ActId=" + ActId + ", day=" + day + "]";
	}

	public int getActId() {
		return ActId;
	}

	public void setActId(int actId) {
		ActId = actId;
	}

	// collection of task

	// map with user

}
