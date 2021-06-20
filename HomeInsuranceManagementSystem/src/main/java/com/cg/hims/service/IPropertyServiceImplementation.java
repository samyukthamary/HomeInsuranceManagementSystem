package com.cg.hims.service;

import java.util.List;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.hims.entities.Property;
import com.cg.hims.exceptions.PropertyNotFoundException;
import com.cg.hims.repository.IPropertyRepository;

@Service
public class IPropertyServiceImplementation implements IPropertyService 
{
	
	@Autowired
	private IPropertyRepository property_repository;

	
						//Adding Property
	@Override
	public Property addProperty(Property property) 
	{
		return property_repository.save(property);
	}
	

						//Showing Properties
	@Override
	public List<Property> viewProperty() 
	{
		return  property_repository.findAll();
	}

	
						//Showing Property with Id
	@Override
	public Property findPropertyById(int id) throws PropertyNotFoundException
	{
		Supplier<PropertyNotFoundException> propexc =()-> new PropertyNotFoundException("property with Id: "+id+" does not exist");
		Property pr=property_repository.findById(id).orElseThrow(propexc);
		return pr;
	 }
	
}
