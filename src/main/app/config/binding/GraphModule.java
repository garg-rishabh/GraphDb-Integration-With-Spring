package main.app.config.binding;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import main.app.service.PersonService;
import main.app.service.impl.PersonServiceImpl;

/**
 * Created by rishabh.garg on 9/5/16.
 */
public class GraphModule extends AbstractModule {

  @Override
  protected void configure() {

    bind(PersonService.class).to(PersonServiceImpl.class).in(Scopes.SINGLETON);
  }
}

