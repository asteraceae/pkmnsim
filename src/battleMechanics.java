import java.util.*;
import java.math.*;

    public class battleMechanics {

        private String message = "";

        private boolean criticalHit() {
            float probability = 1f/16f;
            if (probability >= Math.random(1.0f)) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * @return True if the player goes first.
         */
        public boolean goesFirst(pokemon player, pokemon opponent) {
            if (player.spd) > opponent.spd) {
                return true;
            } else if (opponent.getStat(STAT.SPEED) > player.getStat(STAT.SPEED)) {
                return false;
            } else {
                return Math.randomBoolean();
            }
        }

        public boolean attemptHit(Move move, Pokemon user, Pokemon target) {
            float random = MathUtils.random(1.0f);
            if (move.getAccuracy() >= random) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * Formula found here {@link http://bulbapedia.bulbagarden.net/wiki/Damage#Damage_formula}
         */
        public int calculateDamage(Move move, Pokemon user, Pokemon target) {
            message = "";

            float attack = 0f;
            if (move.getCategory() == MOVE_CATEGORY.PHYSICAL) {
                attack = user.getStat(STAT.ATTACK);
            } else {
                attack = user.getStat(STAT.SPECIAL_ATTACK);
            }

            float defence = 0f;
            if (move.getCategory() == MOVE_CATEGORY.PHYSICAL) {
                defence = target.getStat(STAT.DEFENCE);
            } else {
                defence = target.getStat(STAT.SPECIAL_DEFENCE);
            }

            boolean isCritical = criticalHit();

            int level = user.getLevel();
            float base = move.getPower();
            float modifier = Math.random(0.85f, 1.00f);
            if (isCritical) {
                modifier = modifier * 2f;
                message = "A critical hit!";
            }

            int damage = (int) ((  (2f*level+10f)/250f   *   (float)attack/defence   * base + 2   ) * modifier);

            return damage;
        }

        public boolean hasMessage() {
            return !message.isEmpty();
        }

        public String getMessage() {
            return message;
        }
    }


