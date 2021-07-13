package com.JPA.onlineExam.servlet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.JPA.onlineExam.entity.AttemptedTest;
import com.JPA.onlineExam.entity.Question;

public class AttemptedTest_csv2db {

	@Test
	public void insertAttemptedTest() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		AttemptedTest test2 = new AttemptedTest();
		test2.calculateFinalScore();

		Map<Question, String> hashmap = new HashMap<Question, String>();

		hashmap = test2.testAnswers();

		Set<Map.Entry<Question, String>> entries = hashmap.entrySet();

		for (Map.Entry<Question, String> hm : entries) {
			Question x = hm.getKey();
			String y = hm.getValue();
			System.out.println(x + " : " + y);

		}

		em.merge(test2);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
