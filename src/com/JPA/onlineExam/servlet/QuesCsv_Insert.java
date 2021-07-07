package com.JPA.onlineExam.servlet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.JPA.onlineExam.entity.Question;
import com.JPA.onlineExam.entity.QuestionTemp;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class QuesCsv_Insert {

	public List<QuestionTemp> DatacsvToclass1(String filepath) throws IllegalStateException, FileNotFoundException {

		List<QuestionTemp> Queslist = new CsvToBeanBuilder(new FileReader(filepath)).withType(QuestionTemp.class)
				.build().parse();

//		beans.forEach(System.out::println);

		return Queslist;
	}

	public List<QuestionTemp> DatacsvToclass(String filepath) {

		System.out.println(filepath);

		// create a hashmap of column header to class attribute
		Map<String, String> mapper = new HashMap<String, String>();

		mapper.put("Question", "Question");
		mapper.put("choice_1", "choice_1");
		mapper.put("choice_2", "choice_2");
		mapper.put("choice_3", "choice_3");
		mapper.put("choice_4", "choice_4");
		mapper.put("answer", "answer");

		// HeaderColumnNameTranslateMappingStrategy

		HeaderColumnNameTranslateMappingStrategy<QuestionTemp> strategy = new HeaderColumnNameTranslateMappingStrategy<QuestionTemp>();
		strategy.setType(QuestionTemp.class);
		strategy.setColumnMapping(mapper);

		// csvReader
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(filepath));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// csv to bean
		CsvToBean csvBean = new CsvToBean();

		// call the parse method
		List<QuestionTemp> Queslist = csvBean.parse(strategy, csvReader);

		return Queslist;
	}

	public List<Question> DataDetails() throws IllegalStateException, FileNotFoundException {
		String filename = "D:\\Question_Test\\A_data.csv";
		return DataDetails(filename);

	}

	// @Test
	public List<Question> DataDetails(String filepath) throws IllegalStateException, FileNotFoundException {
		// System.out.println(filepath);
		List<QuestionTemp> queslist = DatacsvToclass(filepath);

		// 2 convert customertemp list to customer list using stream

		List<Question> queslist1 = new ArrayList<Question>();
		queslist1 = queslist.stream().map(cust -> {

			Question cust2 = new Question();

			cust2.setQuestion(cust.getQuestion());

			cust2.setChoice_1(cust.getChoice_1());
			cust2.setChoice_2(cust.getChoice_2());
			cust2.setChoice_3(cust.getChoice_3());
			cust2.setChoice_4(cust.getChoice_4());

			cust2.setAnswer(cust.getAnswer());

			return cust2;
		}).collect(Collectors.toList());

		return queslist1;
	}

	@Test
	public void importTodb() throws IllegalStateException, FileNotFoundException {

		// use persistence.xml configuration

//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Online_Exam");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();

		List<Question> queslist1 = this.DataDetails();
//		queslist1.forEach(x -> em.merge(x));
//		em.getTransaction().commit();
//		em.close();
//		emf.close();

	}

}
