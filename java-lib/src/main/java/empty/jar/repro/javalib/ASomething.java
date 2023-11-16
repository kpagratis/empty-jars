package empty.jar.repro.javalib;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ASomething {
  public String speak() {
    return "howdy!";
  }
}
