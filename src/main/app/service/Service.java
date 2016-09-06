package main.app.service;

/**
 * Created by rishabh.garg on 9/5/16.
 */
public interface Service<T> {

  Iterable<T> findAll();

  T find(Long id);

  void delete(Long id);

  T createOrUpdate(T object);

}
