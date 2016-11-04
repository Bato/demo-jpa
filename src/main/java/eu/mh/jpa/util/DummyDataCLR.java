package eu.mh.jpa.util;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

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

	@Autowired
	private ElementCollectionExampleRepository repository;

	@Override
	public void run(String... arg0) throws Exception {

		if (repository.count() > 0) return;
		
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
		repository.save(norm);

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
		repository.save(norm);

		Iterable<Standard> elements = repository.findAll();
		elements.forEach(System.out::println);			
	}
	
}
