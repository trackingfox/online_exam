//package com.JPA.onlineExam.repoTest;
//
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//
//public class BookRepositoryImpl {
//
//	private EntityManager em;
//
//	public BookRepositoryImpl(EntityManager em) {
//		this.em = em;
//	}
//
//	@Override
//	public Book getBookById(Long id) {
//		return em.find(Book.class, id);
//	}
//
//	@Override
//	public Book getBookByTitle(String title) {
//		TypedQuery<Book> q = em.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class);
//		q.setParameter("title", title);
//		return q.getSingleResult();
//	}
//
//	@Override
//	public Book saveBook(Book b) {
//		if (b.getId() == null) {
//			em.persist(b);
//		} else {
//			b = em.merge(b);
//		}
//		return b;
//	}
//
//	@Override
//	public void deleteBook(Book b) {
//		if (em.contains(b)) {
//			em.remove(b);
//		} else {
//			em.merge(b);
//		}
//	}
//
//}
