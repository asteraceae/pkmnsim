public class pokemon {
  private final int spd;
  private final int atk;
  private final int sp;
  private final int def;;
  private final int hp;
  private final String type;
  private final String type2;
  private final String name;
  private final String[] move;

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
}
