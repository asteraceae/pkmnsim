import java.util.*;
import java.math.*;

    public class battle {

        public String message = " ";

        private boolean criticalHit() {
            float probability = 1/16;
            if (probability >= Math.random()) {
                return true;
            } else {
                return false;
            }
        }
        public boolean goesFirst(pokemon player, pokemon opponent) {
            if (player.spd > opponent.spd) {
                return true;
            } else if (opponent.spd > player.spd) {
                return false;
          } else {
                return true;
            }

        }
        public void damageCalc(pokemon px, pokemon p2, String move){
            //int c = (int)(Math.random() * 100);
            move m = px.findMove(move);
            int c = (m.power * px.atk * 50) - p2.def;
            px.decreaseHP(-c);

        }
        public void changeMessage(){

        }
    }
