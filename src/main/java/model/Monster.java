package model;

import model.interfaces.Creature;

public class Monster extends Creature {

    public Monster(int attack, int protection, int health, int lowerDamageLimit, int upperDamageLimit) throws IllegalArgumentException {
        super(attack, protection, health, lowerDamageLimit, upperDamageLimit);
    }

}
