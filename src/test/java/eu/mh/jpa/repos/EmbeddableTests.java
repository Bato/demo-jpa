package eu.mh.jpa.repos;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import eu.mh.jpa.domain.Employee;
import eu.mh.jpa.domain.EmploymentPeriod;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmbeddableTests {

	@Autowired
	private EmbeddableRepository repo;

	@Test
	public void testCRUD() {
		
		EmploymentPeriod period = new EmploymentPeriod();
		period.setStartDate(new java.sql.Date(new java.util.Date().getTime()));
		period.setEndDate(new java.sql.Date(new java.util.Date().getTime() + 172800000));
		Employee e = new Employee();
		e.setFirstname("aa");
		e.setLastname("cc");
		e.setPeriod(period);
		repo.saveAndFlush(e);
		
		System.out.println(e.getId());
		repo.findAll().forEach(System.out::println);
		Employee e1 = repo.findAll().get(0);
		System.out.println(e1);
	}

}
