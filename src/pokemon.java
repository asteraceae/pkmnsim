public class pokemon {
  private final int spd;
  private final int atk;
  private final int spatk;
  private final int def;
  private final int spdef;
  private final int hp;
  private final String type;
  private final String type2;

  public pokemon(int hp, int atk, int def, int spatk, int spdef, int spd, String type, String type2){
    this.spd = spd;
    this.atk = atk;
    this.spatk = spatk;
    this.def = def;
    this.spdef = spdef;
    this.hp = hp;
    this.type = type;
    this.type2 = type2;
  }
}
