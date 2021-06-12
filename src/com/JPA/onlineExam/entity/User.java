//package com.JPA.onlineExam.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "user")
//public class User {
//
//	// define our fields
//
//	// define constructors
//
//	// define getter setters
//
//	// define tostring
//
//	// annotate fields
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private int id;
//
//	@Column(name = "userName")
//	private String userName;
//
//	// @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
//	// CascadeType.DETACH, CascadeType.REFRESH })
//
//	public User() {
//
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", userName=" + userName + "]";
//	}
//
//}
