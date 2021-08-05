package com.JPA.onlineExam.repository;

import com.JPA.onlineExam.entity.User;

public interface UserInterface {

	// Book getBookById(Long id);

	// List<Book> getBookByTitle(String title);

	User saveUser(User b);

	User getUserById(int i);

	User updateUser(User b, User c);

	void deleteUser(User b);

}
