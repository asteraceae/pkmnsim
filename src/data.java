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
    parse parse = new parse();
    parse.parse(pkmn);
    String[] stats = parse.getStats();
    String[] type = parse.getType();
    String[] moves = parse.getMoves();
    px = new pokemon(Integer.parseInt(stats[0]), Integer.parseInt(stats[1]), Integer.parseInt(stats[2]), Integer.parseInt(stats[3]), Integer.parseInt(stats[4]), type[0], type[1], pkmn, moves);
  }

  public String getName(){
    return px.getName();
  }
  public String getNameL(){
    return px.getNameL();
    }
    public String[] getMoves(){
      return px.getMoves();
    }
    public int getHP(){
      return px.getHP();
    }
    public int getBaseHP(){
      return px.basehp;
    }
    public pokemon getPokemon(){
      return px;
    }
  }
