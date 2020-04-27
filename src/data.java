import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.*;
import java.util.List;


public class data{

  Method method = null;

  public String[] pkmn;
  public pokemon px;
  public String name;

  public data() throws FileNotFoundException {
    Scanner sc = new Scanner(new File("Pokedex.txt"));
    List<String> l = new ArrayList<String>();
    while (sc.hasNextLine()) {
      l.add(sc.nextLine());
    }
    this.pkmn = l.toArray(new String[0]);
  }
  public void randomize(){
    List<String> l = Arrays.asList(pkmn);
    Collections.shuffle(l);
    l.toArray(pkmn);
  }
 public void setP1(String pkmn){
    String p = pkmn;
    px;

    }
    public String[] getMoveset(String id){

  }

  public String getName(){
    return px.getName();
  }
  public String getNameL(){
    return px.getNameL();
    }
  }
