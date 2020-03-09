import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.*;


public class data{

  Method method = null;

  public String[] pkmn = new String[] {"Squirtle", "Eevee", "Charmander", "Bulbasaur", "Pikachu"};
  private String p1;
  private String p2;

  public void setP1(String pkmn){
    p1 = pkmn;
    try {
     method = this.getClass().getMethod(p1);
    } catch (SecurityException e) {  }
      catch (NoSuchMethodException e) { }
    try {
      method.invoke(this);
    } catch (IllegalArgumentException e) {  }
      catch (IllegalAccessException e) { }
      catch (InvocationTargetException e) { }
    }

  public void Pikachu(){
    System.out.println("yay");
    }
  }
