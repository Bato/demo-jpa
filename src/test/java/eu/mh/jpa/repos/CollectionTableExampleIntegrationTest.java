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
public class CollectionTableExampleIntegrationTest {

	@Autowired
	private ElementCollectionExampleRepository repository;

	@Test
	public void testCRUD() {

		Standard norm = new Standard();
		norm.setName("std-1");
		norm.setInstitution("DIN");
		norm.setReleased("2016-11-00");
		Map<String, String> languages = new HashMap<String, String>();
		languages.put("de", "deutsch 1");
		languages.put("en", "english 1");		
		languages.put("fr", "france 1");		
		Map<String, String> abstracts = new HashMap<String, String>();
		abstracts.put("de", "abstract de 1");
		abstracts.put("en", "abstract en 1");
		abstracts.put("fr", "abstract fr 1");
		norm.setTitles(languages);
		norm.setAbstracts(abstracts);
		this.repository.save(norm);
		
		norm = new Standard();
		norm.setName("std-2");
		norm.setInstitution("DIN");
		norm.setReleased("2015-11-00");
		languages = new HashMap<String, String>();
		languages.put("de", "deutsch 2");
		languages.put("en", "english 2");		
		languages.put("fr", "france 2");	
		abstracts = new HashMap<String, String>();
		abstracts.put("de", "abstract de 2");
		abstracts.put("en", "abstract en 2");
		norm.setTitles(languages);
		norm.setAbstracts(abstracts);
		this.repository.save(norm);
		
		
		// Page<ExampleElementCollection> elements = this.repository.findAll(new PageRequest(0, 10));
		Iterable<Standard> elements =  this.repository.findAll();
		//System.out.println(elements.getContent().size());
		// System.out.println(elements.size());
		elements.forEach(System.out::println);
		// assertThat(elements.getTotalElements()).isGreaterThan(20L);
	}
	
}
