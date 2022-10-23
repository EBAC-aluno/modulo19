import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Tabela{

  public String name();
}

public class App {

  @Tabela(name = "TABLE_NAME")
  public static void myMethod() {

      Method[] methods = App.class.getMethods();
      Method method = null;

      for (Method m : methods) {
        if (m.getName().equals("myMethod"))
          method = m;
      }

      System.out.println(method.getAnnotation(Tabela.class).name());
  }

  public static void main(String args[]) {
    myMethod();
  }
}
