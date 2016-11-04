package eu.mh.jpa.repos;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import eu.mh.jpa.domain.Standard;

/**
 * 
 * Integration tests for {@link ElementCollectionExampleRepository}.
 *  
 * @author mh.bato
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ElementCollectionExampleITest {

	@Autowired
	private ElementCollectionExampleRepository repository;

	@Test
	public void testCRUD() {


		Map<String, String> langTitles3 = new HashMap<String, String>();
		langTitles3.put("de", "title deutsch 3");
		langTitles3.put("en", "title english 3");		
		langTitles3.put("fr", "title france 3");

		Map<String, String> langAbstracts3 = new HashMap<String, String>();
		langAbstracts3.put("de", "abstract de 3");
		langAbstracts3.put("en", "abstract en 3");
		langAbstracts3.put("fr", "abstract fr 3");

		Standard norm3 = new Standard();
		norm3.setName("std-3");
		norm3.setInstitution("DIN");
		norm3.setReleased("2016-11-03");
		norm3.setTitles(langTitles3);		
		norm3.setAbstracts(langAbstracts3);
		this.repository.saveAndFlush(norm3);
		
		
		// Page<ExampleElementCollection> elements = this.repository.findAll(new PageRequest(0, 10));
		Iterable<Standard> norms =  this.repository.findAll();
		norms.forEach(System.out::println);
		// assertThat(elements.getTotalElements()).isGreaterThan(20L);
		
		Standard norm =  this.repository.findByName("std-1");
		Map<String, String> langTitles = norm.getTitles();
		langTitles.put("en", "title english - modified 3");
		norm.setTitles(langTitles);
		this.repository.saveAndFlush(norm);
		
		norms =  this.repository.findAll();
		norms.forEach(System.out::println);

	}
	
}
