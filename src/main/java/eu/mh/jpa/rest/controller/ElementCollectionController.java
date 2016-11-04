package eu.mh.jpa.rest.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.mh.jpa.domain.Standard;
import eu.mh.jpa.service.ElementCollectionService;

@RestController
public class ElementCollectionController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
    /**
     * The CollectionTableService business service 
     */
    @Autowired
    private ElementCollectionService collectionTableService;
    
    @RequestMapping(
            value = "/api/ElementCollection",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Standard>> getStandards() {
        logger.info("> getStandards");	
        
        Collection<Standard> norms = collectionTableService.getAllStandards();
        
        return new ResponseEntity<Collection<Standard>>(norms,
                HttpStatus.OK);
        
    }
}
