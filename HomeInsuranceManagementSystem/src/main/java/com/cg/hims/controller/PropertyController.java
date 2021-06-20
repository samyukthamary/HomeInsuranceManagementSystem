package com.cg.hims.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.hims.entities.Property;
import com.cg.hims.exceptions.PropertyNotFoundException;
import com.cg.hims.service.IPropertyService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class PropertyController 
{
	
	@Autowired
	private IPropertyService property_service;
	
								//Adding Property
	@PostMapping("/addProperty")
	public Property add_property(@Valid @RequestBody Property property) 
	{
		return property_service.addProperty(property);
	}
	
    							//Showing Properties
	@GetMapping("/viewingProperties")
	public List<Property> view_property() 
	{
		return property_service.viewProperty();
	}
	
								//Showing Property with Id
	  @RequestMapping (value="/viewPropertyById/{id}",method=RequestMethod.GET)
	  public ResponseEntity<Property> findPropertyById(@PathVariable int id) throws PropertyNotFoundException 
	  {
		  Property p= property_service.findPropertyById(id); 
		  ResponseEntity<Property> resp=new ResponseEntity<>(p,HttpStatus.FOUND);
		  return resp; 
	  }
	  
}
