package com.JPA.onlineExam.servlet;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.JPA.onlineExam.entity.MyTest;

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

	public MyTest mytest_name_detail() {

		MyTest st = new MyTest();
		QuesCsv2db_Insert Quescsv = new QuesCsv2db_Insert();
		// System.out.println(x + " : " + y);

		st.setTestName(testName);
		st.setQuestionSet(Quescsv.DataDetails());

		// st.setData(null);
		return st;

	}

	@Test
	public void importTodb() {

		// use persistence.xml configuration

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery(
				"FROM Data where stockName='A' AND open_price>69 AND  open_price<72 AND Date BETWEEN '2019-01-11' AND '2019-01-17' ");
		List<Data> results = query.getResultList();

		for (Data obj : results) {
			System.out.println(obj.getDate() + "   " + obj.getHigh_price() + "   " + obj.getLow_price() + "    "
					+ obj.getOpen_price() + "    " + obj.getClose_price());

		}

		// System.out.println(x + " : " + y);
		MyTest s = this.mytest_name_detail();

		em.merge(s);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
