package com.nishu.bank.dao;


import java.util.List;

import com.nishu.bank.model.Person;


public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}
