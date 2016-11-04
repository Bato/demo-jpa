package eu.mh.jpa.util;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eu.mh.jpa.domain.Standard;
import eu.mh.jpa.repos.ElementCollectionExampleRepository;

/**
 * Load some dummy data at startup 
 * 
 * @author mh.bato
 *
 */
@Component
@Transactional
class DummyDataCLR implements CommandLineRunner {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ElementCollectionExampleRepository repository;

	@Override
	public void run(String... arg0) throws Exception {
		
		logger.info("*** Imorting DEMO Data in database ...");		

		if (repository.count() > 0) return;
		
		Map<String, String> langTitles1 = new HashMap<String, String>();
		langTitles1.put("de", "title deutsch 1");
		langTitles1.put("en", "title english 1");		
		langTitles1.put("fr", "title france 1");

		Map<String, String> langTitles2  = new HashMap<String, String>();
		langTitles2.put("de", "title de 2");
		langTitles2.put("en", "title en 2");		
		langTitles2.put("fr", "title fr 2");	

		Map<String, String> langAbstracts1 = new HashMap<String, String>();
		langAbstracts1.put("de", "abstract de 1");
		langAbstracts1.put("en", "abstract en 1");
		langAbstracts1.put("fr", "abstract fr 1");

		Map<String, String> langAbstracts2 = new HashMap<String, String>();
		langAbstracts2.put("de", "abstract de 2");
		langAbstracts2.put("en", "abstract en 2");
		
		Standard norm1 = new Standard();
		norm1.setName("std-1");
		norm1.setInstitution("DIN");
		norm1.setReleased("2016-11-00");
		norm1.setTitles(langTitles1);		
		norm1.setAbstracts(langAbstracts1);
		this.repository.saveAndFlush(norm1);
		
		Standard norm2 = new Standard();
		norm2.setName("std-2");
		norm2.setInstitution("DIN");
		norm2.setReleased("2015-11-00");
		norm2.setTitles(langTitles2);
		norm2.setAbstracts(langAbstracts2);
		this.repository.saveAndFlush(norm2);
		 

		Iterable<Standard> elements = repository.findAll();
		elements.forEach(System.out::println);			
	}
	
}
