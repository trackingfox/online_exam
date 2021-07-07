package com.JPA.onlineExam.servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.JPA.onlineExam.entity.MyTest;

public class MyTest_csv2db {

	public MyTest mytest_name_detail() {

		MyTest st = new MyTest();
		QuesCsv_Insert Quescsv = new QuesCsv_Insert();
		// System.out.println(x + " : " + y);

		st.setTestName();
		st.setQuestion(Quescsv.DataDetails());
		// st.setData(null);
		return st;

	}

	@Test
	public void importTodb() {

		// use persistence.xml configuration

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// System.out.println(x + " : " + y);
		MyTest s = this.mytest_name_detail();

		em.merge(s);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
