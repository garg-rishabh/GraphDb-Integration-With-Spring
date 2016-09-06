package main.app.controllers;

import main.app.exception.NotFoundException;
import main.app.service.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rishabh.garg on 9/6/16.
 */

@Transactional
public abstract class Controller<T> {

  public abstract Service<T> getService();

  @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
  public T create(@RequestBody T entity) {
    return getService().createOrUpdate(entity);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
  public T update(@PathVariable Long id, @RequestBody T entity) throws NotFoundException {
    if (getService().find(id) != null) {
      return getService().createOrUpdate(entity);
    }
    throw new NotFoundException();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public T find(@PathVariable Long id) throws NotFoundException {
    T entity = getService().find(id);
    if (entity != null) {
      System.out.println("from OGM: " + entity);
      return entity;
    } else
      throw new NotFoundException();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) throws NotFoundException {
    if (getService().find(id) != null) {
      getService().delete(id);
    } else {
      throw new NotFoundException();
    }
  }

  public Iterable<T> list() {
    return getService().findAll();
  }
}