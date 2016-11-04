package eu.mh.jpa.repos;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import eu.mh.jpa.domain.Standard;

public interface ElementCollectionExampleRepository extends JpaRepository<Standard, Long> {
	
	Page<Standard> findAll(Pageable pageable) ;
}
