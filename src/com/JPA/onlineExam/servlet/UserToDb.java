package com.JPA.onlineExam.servlet;

import java.io.FileNotFoundException;
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
import com.JPA.onlineExam.entity.TestPaper;

public class UserToDb {
	@Test
	public void userToDb() throws IllegalStateException, FileNotFoundException {

		// Get entity Manager
		myEntityManager M = new myEntityManager();
		EntityManager em = M.getentitymanager();
		// You should create entity manger and factory ONLY ONCE.
		// Each creation will regenerate database and wipe out data with 'create' option
		// in persistence.xml

		// import all question to database
		QuesCsv2db_Insert ques = new QuesCsv2db_Insert();
		ques.importTodb(em);

//			// Generate tests with random questions		
		generateTestPaper(em); // generate 4 tests

		// Generate some 'fake' attempted tests
		createAttemptedTest(em, 1); // sample attempt 1
		createAttemptedTest(em, 1); // sample attempt 2
		createAttemptedTest(em, 2); // sample attempt 3
		createAttemptedTest(em, 2); // sample attempt 3

		M.closeAll(); // remember to close the connection
	}

	/*****************************************************
	 * GENERATE TEST PAPERS (SAMPLE)
	 ******************************************************/
	public void generateTestPaper(EntityManager em) {

		// use persistence.xml configuration
		em.getTransaction().begin();

		for (int i = 1; i <= 4; i++) {
			Query query = em.createQuery(
					"FROM Question where Qid>=FLOOR(RAND()*(25-10+1))+10 AND Qid<FLOOR(RAND()*(50-10+1))+30 ");
			List<Question> results = query.getResultList();

			for (Question obj : results) {
				System.out.println(obj.getQuestion() + "   " + obj.getChoice_1() + "   " + obj.getChoice_2() + "    "
						+ obj.getChoice_3() + "    " + obj.getChoice_4());

			}

			TestPaper test1 = new TestPaper();
			test1.setQuestionSet(results);
			test1.setTestName("Full Stack JAVA");
			test1.setTestLevel("I");
			em.merge(test1);
		}

		em.getTransaction().commit();

	}

	/***************************************
	 * ATTEMPTED TEST GENERATION (SAMPLE)
	 ***************************************/

//		@Test
	public void createAttemptedTest() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		createAttemptedTest(em, 1);
	}

	// overload
public void createAttemptedTest(EntityManager em, int testID) {
		em.getTransaction().begin();

//			int finalScore = calculateFinalScore();

		// fetch a test paper by ID
		// TestPaper t = getTestPaperObject(em, testID);
		List<TestPaper> test = FetchTestpaper();

		// create a collection for QuestionAnswersSet
		Map<Question, Character> mymap = new HashMap<Question, Character>();
		Random randNum = new Random();
		char user_ans = ' ';
		char[] alphabet = { 'A', 'B', 'C', 'D' };
		List<Question> qObject = t.getQuestionSet();
		for (Question q : qObject) {
			user_ans = alphabet[(int) (Math.random() * 10 % 4)];
			mymap.put(q, user_ans);
			// System.out.println(q.toString());
		}

		// syso the map
		for (Map.Entry<Question, Character> item : mymap.entrySet())
			System.out.println(item.getKey().toString() + "::" + item.getValue().toString());

		// printing the objects of hashmap
//			Set<Map.Entry<Question, Character>> entries = mymap.entrySet();
//			for (Map.Entry<Question, Character> hm : entries) {
//				Question x = hm.getKey();
//				char y = hm.getValue();
//				System.out.println(x + " : " + y);
//			}

//			create the attempted test object object 
		AttemptedTest test2 = new AttemptedTest();
		int finalScore = 0;

		//

		for (TestPaper test1 : test) {

			if (test1.getTestId() == 1) {

				test2.setTest(test1);
				finalScore = calculateFinalScore(test1);
				hashmap = testAnswers(test1);
				// printing the objects of hashmap
				Set<Map.Entry<Question, Character>> entries = hashmap.entrySet();
				for (Map.Entry<Question, Character> hm : entries) {
					Question x = hm.getKey();
					char y = hm.getValue();
					System.out.println(x + " : " + y);
				}

				test2.setFinalScore(finalScore);
				test2.setQuestionAnswersSet(hashmap);

			}

		em.merge(atest1);
		em.getTransaction().commit();
	}

	private TestPaper getTestPaperObject(EntityManager em, int ID) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("FROM TestPaper where testId=" + ID);
		TestPaper testPaper = (TestPaper) query.getResultList().get(0);

		return testPaper;
	}

	public List<MyTest> FetchTestpaper() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();

		Query query = em.createQuery("FROM MyTest where testId>=1 AND testId<=4");
		List<MyTest> testPaper = query.getResultList();
		for (MyTest obj : testPaper) {
			for (Question q : obj.getQuestionSet()) {
				System.out.println(q.getQuestion() + "        " + q.getChoice_1() + "     " + q.getChoice_2() + "      "
						+ q.getChoice_3() + "     " + q.getChoice_4());
			}
			System.out.println(obj.getTestId() + "   " + obj.getTestName() + "    " + obj.getTestLevel() + "    ");

		}

//		em.close();
//		emf.close();

		return testPaper;

	}

}

class myEntityManager {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
	EntityManager em = emf.createEntityManager();

	public EntityManager getentitymanager() {
		return em;
	}

	public void closeAll() {
		em.close();
		emf.close();

	}

}
