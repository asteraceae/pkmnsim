import java.util.List;

public class move{

    public String name;
    private String type;
    public int power;
    private boolean physical;
    private boolean passive;

    public move(String name, String type, int power, boolean p, boolean pa){
      this.type = type;
      this.power = power;
      this.physical = p;
      this.passive = pa;
    }


    public move (String name){
        this.name = name;
        findStats(name);
    }
    public void findStats(String id){
      parse p = new parse();
      List<String> data = p.parsemove(id);
      if (data.size() == 7){
          type = data.get(3);
          power = Integer.parseInt(data.get(5));
          if (data.get(4).equals("Physical")){
              physical = true;
              passive = false;
          }
          else if (data.get(4).equals("Special")){
              physical = false;
              passive = false;
          }
          else {
              physical = false;
              passive = true;
          }
      }
      else {
          type = data.get(2);
          power = Integer.parseInt(data.get(4));
          if (data.get(3).equals("Physical")){
              physical = true;
              passive = false;
          }
          else if (data.get(3).equals("Special")){
              physical = false;
              passive = false;
          }
          else {
              physical = false;
              passive = true;
          }

      }

    }
}
