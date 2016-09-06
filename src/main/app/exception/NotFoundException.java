package main.app.exception;


/**
 * Created by rishabh.garg on 9/5/16.
 */

public class NotFoundException extends mainException {

  public NotFoundException() {
    super("The resource you requested does not exist");
  }
}
