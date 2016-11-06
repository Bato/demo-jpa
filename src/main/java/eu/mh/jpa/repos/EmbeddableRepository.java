package eu.mh.jpa.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import eu.mh.jpa.domain.Employee;

public interface EmbeddableRepository extends JpaRepository<Employee, Long> {
	
}
