package model;

import model.interfaces.Creature;

public class Hero extends Creature {

    private int healthPortionsCounter;

    public Hero(int attack, int protection, int health, int lowerDamageLimit, int upperDamageLimit) throws IllegalArgumentException {
        super(attack, protection, health, lowerDamageLimit, upperDamageLimit);
        healthPortionsCounter = 4;
    }

    @Override
    public void takeDamage(int damage) {
        setCurrentHealth(getCurrentHealth() - damage);
        if (getCurrentHealth() <= 0) {
            this.useHealthPortion();
        }
    }

    public void useHealthPortion() {
        if (healthPortionsCounter > 0) {
            System.out.println("Hero uses health portion.");
            this.setCurrentHealth((int) (getCurrentHealth() + (getHealth() * 0.3)));
            healthPortionsCounter--;
        }
    }
}
