/**
 * Created by rishabh.garg
 */

package main.app;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.event.AfterDeleteEvent;
import org.springframework.data.neo4j.event.AfterSaveEvent;
import org.springframework.data.neo4j.event.BeforeSaveEvent;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = "main.app.repository")
@SpringBootApplication
public class Application extends Neo4jConfiguration {


  public static void main(String[] args) {

    SpringApplication.run(Application.class, args);
  }

  /**
   * Creates a neo4j configuration, falling back to embedded if config details not present
   */

  @Bean
  public Configuration getConfiguration() {
    Configuration config = new Configuration();
    config.driverConfiguration().setDriverClassName(Constants.NEODB_DRIVER);
    config.driverConfiguration().setCredentials(Constants.NEODB_USER,Constants.NEODB_PASSWORD);
    config.driverConfiguration().setURI(Constants.NEODB_URI);
    return config;
  }

  @Bean
  public SessionFactory getSessionFactory() {
    System.setProperty("username", "neo4j");
    System.setProperty("password", "neo4j");
    return new SessionFactory(getConfiguration(),"main.app.models");
  }

  public Session getSession() throws Exception {
    return super.getSession();
  }

  @Bean
  ApplicationListener<BeforeSaveEvent> beforeSaveEventApplicationListener() {
    return new ApplicationListener<BeforeSaveEvent>() {
      @Override
      public void onApplicationEvent(BeforeSaveEvent event) {
        Object entity = event.getEntity();
        System.out.println("Before save of: " + entity);
      }
    };
  }

  @Bean
  ApplicationListener<AfterSaveEvent> afterSaveEventApplicationListener() {
    return new ApplicationListener<AfterSaveEvent>() {
      @Override
      public void onApplicationEvent(AfterSaveEvent event) {
        Object entity = event.getEntity();
        System.out.println("Before save of: " + entity);
      }
    };
  }

  @Bean
  ApplicationListener<AfterDeleteEvent> deleteEventApplicationListener() {
    return new ApplicationListener<AfterDeleteEvent>() {
      @Override
      public void onApplicationEvent(AfterDeleteEvent event) {
        Object entity = event.getEntity();
        System.out.println("Before save of: " + entity);
      }
    };
  }


}