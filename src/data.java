import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class data{

  Method method = null;

  public String[] pkmn = new String[] {"Pikachu", "Charmander", "Eevee", "Bulbasaur", "Squirtle"};
  public pokemon px;
  public String name;

  public void randomize(){
    List<String> l = Arrays.asList(pkmn);
    Collections.shuffle(l);
    l.toArray(pkmn);
  }
  public void setP1(String pkmn){
    String p = pkmn;
    //this will invoke the correct method associated w pkmn and set values accordingly
    try {
     method = this.getClass().getMethod(p, pokemon.class);
    } catch (SecurityException e) {  }
      catch (NoSuchMethodException e) { }
    try {
      method.invoke(this, px);
    } catch (IllegalArgumentException e) {  }
      catch (IllegalAccessException e) { }
      catch (InvocationTargetException e) { }
    }
  public String getName(){
    return name;
  }
  public void Pikachu(pokemon px){
    System.out.println("TEST 0");
    //Base stats,
      //max stats 274, 229, 196, 218, 218, 306
      //idk how it works
    this.px = new pokemon(35, 55, 40, 50, 50, 90, "Electric", null);
   this.name = "Pikachu";
    }
  public void Eevee(pokemon p){
    System.out.println("TEST 1");
    this.px = new pokemon(35, 55, 40, 50, 50, 90, "Electric", null);
    this.name = "Eevee";
    }
  public void Charmander(pokemon p){
    System.out.println("TEST 2");
    this.px = new pokemon(35, 55, 40, 50, 50, 90, "Electric", null);
    this.name = "Charmander";
    }
  public void Bulbasaur(pokemon p){
    System.out.println("TEST 3");
    this.px = new pokemon(35, 55, 40, 50, 50, 90, "Electric", null);
    this.name = "Bulbasaur";
    }
  public void Squirtle(pokemon p){
    System.out.println("TEST 4");
    px = new pokemon(35, 55, 40, 50, 50, 90, "Electric", null);
    this.name = "Squirtle";
    }
  }
