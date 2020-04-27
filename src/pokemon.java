public class pokemon {
  public final int spd;
  public final int atk;
  public final int sp;
  public final int def;;
  public int hp;
  public final String type;
  public final String type2;
  public final String name;
  public final String[] move;

  public pokemon(int hp, int atk, int def, int spd, int sp, String type, String type2, String name, String[] moves){
    this.spd = spd;
    this.atk = atk;
    this.sp = sp;
    this.def = def;
    this.hp = hp;
    this.type = type;
    this.type2 = type2;
    this.name = name;
    this.move = moves;
  }
  public String getName(){
    return this.name;
  }
  public String getNameL(){
    String n = name.toLowerCase();
    return n;
  }
  public String[] getMoves(){
    return move;
  }
  public void decreaseHP(int c){
    hp = hp - c;
  }
    public int getHP(){
    return hp;
    }

}
