//package com.JPA.onlineExam.servlet;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import org.junit.Test;
//
//import com.JPA.onlineExam.repoTest.BookRepositoryImpl;
//
//public class UserRun {
//
//	@Test
//	public void User_Run() {
//
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//
//		User b = new User();
//		User c = new User()
//
//		BookRepositoryImpl bookImpl = new BookRepositoryImpl(em);
//
//		bookImpl.saveBook(b);
//		bookImpl.saveBook(c);
//		bookImpl.saveBook(d);
//
//		System.out.println(bookImpl.getBookById(3).toString());
//
//		// System.out.println(bookImpl.getBookByTitle("The Sun").toString());
//
//		bookImpl.deleteBook(b);
//
//		em.getTransaction().commit();
//
//		em.close();
//		emf.close();
//
//	}
//
//}
