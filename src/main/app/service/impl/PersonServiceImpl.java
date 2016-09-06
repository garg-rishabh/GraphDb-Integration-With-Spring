package main.app.service.impl;

/**
 * Created by rishabh.garg on 9/5/16.
 */

import main.app.models.Person;
import main.app.repository.PersonRepository;
import main.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("personService")
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository personRepository;

  @Override
  public Person find(Long id) {
    return personRepository.findOne(id);
  }

  @Override
  public void delete(Long id) {
    personRepository.delete(id);
  }

  @Override
  public Person createOrUpdate(Person object) {
    return personRepository.save(object);
  }

  @Override
  public Iterable<Person> findAll() {
    return personRepository.findAll();
  }


}