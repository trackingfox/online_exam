package com.JPA.onlineExam.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.JPA.onlineExam.entity.AttemptedTest;
import com.JPA.onlineExam.entity.MyTest;
import com.JPA.onlineExam.entity.Question;

public class AttemptedTest_csv2db {

	// method to calculate finalscore

	public List<MyTest> FetchTestpaper() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("FROM MyTest where testId=1");
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

	public MyTest FetchTestpaper1() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("FROM MyTest where testId=4");
		MyTest testPaper = (MyTest) query.getResultList().get(0);

		for (Question q : testPaper.getQuestionSet()) {
			System.out.println(q.getQuestion() + "        " + q.getChoice_1() + "     " + q.getChoice_2() + "      "
					+ q.getChoice_3() + "     " + q.getChoice_4());
		}
		System.out.println(
				testPaper.getTestId() + "   " + testPaper.getTestName() + "    " + testPaper.getTestLevel() + "    ");

		em.close();
		emf.close();

		return testPaper;

	}

//res=res+alphabet[(int)(Math.random()*10%26)];

	// key value pair for question and answer.
	// @Test
	public Map<Question, Character> testAnswers() {

		Map<Question, Character> hashmap = new HashMap<Question, Character>();
		Random randNum = new Random();
		List<MyTest> testPaper = FetchTestpaper();
		char user_ans = ' ';
		char[] alphabet = { 'A', 'B', 'C', 'D' };

		for (MyTest obj : testPaper) {
			// user_ans=(int)(Math.random()*(max-min+1)+min);
			System.out.println(obj.toString());

			List<Question> obj1 = obj.getQuestionSet();
			for (Question q : obj1) {
				user_ans = alphabet[(int) (Math.random() * 10 % 4)];
				hashmap.put(q, user_ans);
				// System.out.println(q.toString());
			}
		}

		return hashmap;

	}

	public int calculateFinalScore() {
		List<MyTest> testPaper = FetchTestpaper();

		int finalScore = 0;
		for (MyTest obj : testPaper) {
			// user_ans=(int)(Math.random()*(max-min+1)+min);
			// System.out.println(obj.toString());

			Map<Question, Character> hashmap = new HashMap<Question, Character>();
			hashmap = testAnswers();

			// printing the objects of hashmap
			Set<Map.Entry<Question, Character>> entries = hashmap.entrySet();
			for (Map.Entry<Question, Character> hm : entries) {
				String ans = hm.getKey().getAnswer();
				char user_ans = hm.getValue();
				String st = Character.toString(user_ans);
				// System.out.println(x + " : " + y);
				if (ans.equals(st)) {
					finalScore += 1;
				}
			}

		}

		return finalScore;
	}

	public int calculateFinalScore1() {
		MyTest testPaper = FetchTestpaper1();

		int finalScore = 0;

		// user_ans=(int)(Math.random()*(max-min+1)+min);
		// System.out.println(obj.toString());

		Map<Question, Character> hashmap = new HashMap<Question, Character>();
		hashmap = testAnswers();

		// printing the objects of hashmap
		Set<Map.Entry<Question, Character>> entries = hashmap.entrySet();
		for (Map.Entry<Question, Character> hm : entries) {
			String ans = hm.getKey().getAnswer();
			char user_ans = hm.getValue();
			String st = Character.toString(user_ans);
			// System.out.println(x + " : " + y);
			if (ans.equals(st)) {
				finalScore += 1;
			}
		}

		return finalScore;

	}

	// @Test
	public void FetchAttemptedTestPaper() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("FROM AttemptedTest where sl_no=1");
		List<AttemptedTest> testPaper = query.getResultList();
		for (AttemptedTest obj : testPaper) {

			System.out.println(obj.getQuestionAnswersSet() + "\n" + obj.getFinalScore() + "    ");

		}

		em.close();
		emf.close();
	}

	@Test
	public void insertAttemptedTest() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		MyTest test = new MyTest();
		test = FetchTestpaper1();

		AttemptedTest test2 = new AttemptedTest();
		int finalScore = calculateFinalScore();

		Map<Question, Character> hashmap = new HashMap<Question, Character>();
		hashmap = testAnswers();

		// printing the objects of hashmap
		Set<Map.Entry<Question, Character>> entries = hashmap.entrySet();
		for (Map.Entry<Question, Character> hm : entries) {
			Question x = hm.getKey();
			char y = hm.getValue();
			System.out.println(x + " : " + y);
		}

		test2.setFinalScore(finalScore);
		test2.setQuestionAnswersSet(hashmap);
		test2.setTest(test);

		em.merge(test2);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
