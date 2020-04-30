import java.lang.reflect.Array;

public class pokemon {
  public final int spd;
  public final int atk;
  public final int sp;
  public final int def;;
  public int hp;
  public int basehp;
  public final String type;
  public final String type2;
  public final String name;
  public final String[] move;
  public  move m1;
  public  move m2;
  public  move m3;
  public  move m4;

  public pokemon(int hp, int atk, int def, int spd, int sp, String type, String type2, String name, String[] moves){
    this.spd = spd;
    this.atk = atk;
    this.sp = sp;
    this.def = def;
    this.hp = hp;
    this.basehp = hp;
    this.type = type;
    this.type2 = type2;
    this.name = name;
    this.move = moves;
    genMoveData();
  }
  private void genMoveData(){
    this.m1 = new move(move[0]);
    this.m2 = new move(move[1]);
    this.m3 = new move(move[2]);
    this.m4 = new move(move[3]);
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
    if (hp < 0){
      hp = 0;
    }
  }
  public int getHP(){
    return hp;
    }
    public move findMove(String id){
       if (m1.name == id){
         return m1;
       }
       else  if (m1.name == id){
         return m2;
       }
       else if  (m1.name == id){
         return m3;
       }
       else if (m4.name == id){
         return m4;
       }
       return m1;
    }


}
