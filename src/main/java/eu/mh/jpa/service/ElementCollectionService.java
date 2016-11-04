package eu.mh.jpa.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.mh.jpa.domain.Standard;
import eu.mh.jpa.repos.ElementCollectionExampleRepository;


@Service
public class ElementCollectionService {

	@Autowired
	private ElementCollectionExampleRepository repository;

	public Collection<Standard> getAllStandards() {
		Collection<Standard> norms =  this.repository.findAll();
		return norms;
		
	}
}
