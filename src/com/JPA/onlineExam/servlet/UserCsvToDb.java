package com.JPA.onlineExam.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.JPA.onlineExam.entity.AttemptedTest;
import com.JPA.onlineExam.entity.MyTest;
import com.JPA.onlineExam.entity.Question;
import com.JPA.onlineExam.entity.User;

public class UserCsvToDb {

	@Test
	public void userToDb() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		User user4 = new User();

		List<MyTest> unattemptTestSet = FetchTestpaper();

		List<AttemptedTest> atemptTestSet = FetchAttemptedTestPaper1();

		List<User> friends = new ArrayList<User>();

		user1.setUserName("Sharif");
		user1.setPassword("password1");
		user1.setUnattemptTestSet(unattemptTestSet);
		user1.setAtemptTestSet(atemptTestSet);
		// user1.setFriends(friends);

		em.merge(user1);

		user2.setUserName("Ramesh");
		user2.setPassword("password2");
		user2.setUnattemptTestSet(unattemptTestSet);
		user2.setAtemptTestSet(atemptTestSet);
		// user2.setFriends(friends);

//		friends.add(user1);
//		friends.add(user2);
		em.merge(user2);

		user3.setUserName("Nilesh");
		user3.setPassword("password3");
		user3.setUnattemptTestSet(unattemptTestSet);
		user3.setAtemptTestSet(atemptTestSet);
//		user3.setFriends(friends);

		em.merge(user3);

		user4.setUserName("Somesh");
		user4.setPassword("password4");
		user4.setUnattemptTestSet(unattemptTestSet);
		user4.setAtemptTestSet(atemptTestSet);
//	    user4.setFriends(friends);

		em.merge(user4);
		em.getTransaction().commit();

		em.getTransaction().begin();

		friends.add(user1);
		friends.add(user2);
		friends.add(user3);
		friends.add(user4);

		user1.setFriends(friends);
		em.merge(user1);
		user2.setFriends(friends);
		em.merge(user2);
		user3.setFriends(friends);
		em.merge(user3);
		user4.setFriends(friends);
		em.merge(user4);

		em.getTransaction().commit();

		// u.setFriends(friends);

		// creating user

		// updating user with mapping(min 2 objects)

		// creating hashmap for storing topic object and score object as key: value pair
		// List<Topics> topics = new List<Topics>();

		em.close();
		emf.close();
	}

//	public Map<Topics, Score> topic_Score_object(Topics topics, Score scores) {
//
//		Map<Topics, Score> hashmap = new HashMap<Topics, Score>();
//
//		hashmap.put(topics, scores);
//
//		return hashmap;
//
//	}

	public List<AttemptedTest> FetchAttemptedTestPaper1() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("FROM AttemptedTest where sl_no>=1 AND sl_no <=4");
		List<AttemptedTest> testPaper = query.getResultList();
		for (AttemptedTest obj : testPaper) {

			System.out.println(obj.getQuestionAnswersSet() + "\n" + obj.getFinalScore() + "    ");

		}

		em.close();
		emf.close();
		return testPaper;
	}

	public List<MyTest> FetchTestpaper() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("FROM MyTest where testId>=1 AND testId<=4");
		List<MyTest> testPaper = query.getResultList();
		for (MyTest obj : testPaper) {
			for (Question q : obj.getQuestionSet()) {
				System.out.println(q.getQuestion() + "        " + q.getChoice_1() + "     " + q.getChoice_2() + "      "
						+ q.getChoice_3() + "     " + q.getChoice_4());
			}
			System.out.println(obj.getTestId() + "   " + obj.getTestName() + "    " + obj.getTestLevel() + "    ");

		}

		em.close();
		emf.close();

		return testPaper;

	}
}
