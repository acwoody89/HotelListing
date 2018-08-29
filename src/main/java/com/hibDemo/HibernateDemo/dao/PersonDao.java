package com.hibDemo.HibernateDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hibDemo.HibernateDemo.entity.Person;

//our CRUD methods should live here
// (C)reate (R)ead (U)pdate (D)elete

@Repository // this is technically know as repository
@Transactional // allows us to manage all of the transactions That take place in regards to the DBO
public class PersonDao {
	@PersistenceContext // entities are stored in teh persistence context
	// and the EntityManager is an interface that manages this process
	EntityManager eManager;
	
	public Person findById(int id) {
		return eManager.find(Person.class, id);
	}
	
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = eManager.createNamedQuery("find_all_persons", Person.class);
		
		return namedQuery.getResultList();
	}
	
	// to update or insert we will use the merge() method
	//it will insert a value if it doesn't exist in the tables
	// otherwise it will update the value if it exists
	public Person update(Person p) {
		
		return eManager.merge(p);
	}
	
	// the delete method
	public void deleteById(int id) {
		Person p1 = findById(id);
		eManager.remove(p1);
	}
	
}
