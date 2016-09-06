package main.app.controllers;

import main.app.models.Person;
import main.app.service.PersonService;
import main.app.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rishabh.garg on 9/5/16.
 */

@RestController
@RequestMapping(value = "/person")
public class PersonController extends Controller<Person> {

  @Autowired
  private PersonService personService;

  @Override
  public Service<Person> getService() {
    return personService;
  }



}
