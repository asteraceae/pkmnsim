import java.util.*;
import java.math.*;

    public class battle {

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
        public void damageCalc(pokemon px){
            int c = (int)(Math.random() * 100);
            px.decreaseHP(c);
        }
    }


