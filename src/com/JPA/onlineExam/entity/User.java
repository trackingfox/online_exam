//package com.JPA.onlineExam.entity;
//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "User")
//public class User {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private int id;
//
//	@Column(name = "userName")
//	private String userName;
//
//	@Column(name = "password")
//	private String password;
//
//	// @OneToMany
//	private List<AttemptedTest> atemptTestSet;
//
//	// @OneToOne
//	private List<User> friends;
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
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", userName=" + userName + "]";
//	}
//
//}
