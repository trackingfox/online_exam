package com.JPA.onlineExam.servlet;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.JPA.onlineExam.entity.MyTest;
import com.JPA.onlineExam.entity.Question;

public class MyTest_csv2db {

	// method to generate questions
//		private void generateQuestion() {
//			for (int question = 0; question < questionSet.size(); question++) {
//				System.out.println(questionSet.get(question).getQuestion());
//				int numChoices = questionSet.get(question).getChoices().size();
	//
//				// show choices from questions in question set
	//
//				for (int choice = 0; choice < numChoices; choice++) {
//					System.out.println((choice + 1) + ":" + questionSet.get(question).getChoices().get(choice));
//				}
//			}
	//
//		}

//	public MyTest mytest_name_detail() {
//
//		MyTest st = new MyTest();
//		QuesCsv2db_Insert Quescsv = new QuesCsv2db_Insert();
//		// System.out.println(x + " : " + y);
//
//		st.setTestName(testName);
//		st.setQuestionSet(Quescsv.DataDetails());
//
//		// st.setData(null);
//		return st;
//
//	}

	@Test
	public void generateQuestions() {

		// use persistence.xml configuration

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em
				.createQuery("FROM Question where Qid>=FLOOR(RAND()*(25-10+1))+10 AND Qid<FLOOR(RAND()*(50-10+1))+30 ");
		List<Question> results = query.getResultList();

		for (Question obj : results) {
			System.out.println(obj.getQuestion() + "   " + obj.getChoice_1() + "   " + obj.getChoice_2() + "    "
					+ obj.getChoice_3() + "    " + obj.getChoice_4());

		}

		MyTest test1 = new MyTest();
		test1.setQuestionSet(results);
		test1.setTestName("Full Stack JAVA");
		test1.setTestLevel("I");
		// System.out.println(x + " : " + y);
		// MyTest s = this.mytest_name_detail();

		em.merge(test1);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
