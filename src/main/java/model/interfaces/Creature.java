package model.interfaces;

import utils.UtilRandNum;

public abstract class Creature {
    protected int attack;
    protected int protection;
    protected int health;
    protected int currentHealth;
    protected int lowerDamageLimit;
    protected int upperDamageLimit;
    protected final int minimalRollOfDiceToHit = 4;

    public Creature(int attack, int protection, int health, int lowerDamageLimit, int upperDamageLimit) throws IllegalArgumentException {
        if (attack < 1 || attack > 30) {
            throw new IllegalArgumentException("\"Attack\" must be between 1 and 30");
        }
        if (protection < 1 || protection > 30) {
            throw new IllegalArgumentException("\"Protection\" must be between 1 and 30");
        }
        if (health < 0) {
            throw new IllegalArgumentException("\"Health\" must be between more then 0");
        }
        if (lowerDamageLimit >= upperDamageLimit || lowerDamageLimit < 0) {
            throw new IllegalArgumentException("\"Lower damage limit\" must be less then \"Upper damage limit\" and natural number");
        }
        this.attack = attack;
        this.protection = protection;
        this.health = health;
        this.lowerDamageLimit = lowerDamageLimit;
        this.upperDamageLimit = upperDamageLimit;
        this.currentHealth = health;
    }

    public void hit(Creature creature) {
        if (isHitSuccess(creature)) {
            System.out.println("Hit is successful!");
            int theResultOfDamagePoints = UtilRandNum.getRand(lowerDamageLimit, upperDamageLimit);
            System.out.println("Damage is: " + theResultOfDamagePoints);
            creature.takeDamage(theResultOfDamagePoints);
        } else {
            System.out.println("Hit is not successful!");
        }
    }

    public boolean isHitSuccess(Creature creature) {
        int attackModifier = Math.max(this.getAttack() - creature.getProtection() + 1, 1);

        for (int i = 0; i <= attackModifier; i++) {
            if (UtilRandNum.getResultOfDice() > minimalRollOfDiceToHit) {
                return true;
            }
        }
        return false;
    }

    public void takeDamage(int damage) {
        setCurrentHealth(currentHealth - damage);
    }

    public boolean isDead() {
        if (currentHealth == 0) {
            return true;
        }
        return false;
    }

    protected int getAttack() {
        return attack;
    }

    protected void setAttack(int attack) throws IllegalArgumentException {
        if (attack < 1 || attack > 30) {
            throw new IllegalArgumentException("\"Attack\" must be between 1 and 30");
        }
        this.attack = attack;
    }

    protected int getProtection() {
        return protection;
    }

    protected void setProtection(int protection) throws IllegalArgumentException {
        if (protection < 1 || protection > 30) {
            throw new IllegalArgumentException("\"Protection\" must be between 1 and 30");
        }
        this.protection = protection;
    }

    protected int getHealth() {
        return health;
    }

    protected void setHealth(int health) throws IllegalArgumentException {
        if (health < 0) {
            throw new IllegalArgumentException("\"Health\" must be between more then 0");
        }
        this.health = health;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    protected void setCurrentHealth(int currentHealth) {
        if (currentHealth < 0) {
            this.currentHealth = 0;
        } else {
            this.currentHealth = currentHealth;
        }
    }

    protected int getLowerDamageLimit() {
        return lowerDamageLimit;
    }

    protected void setLowerDamageLimit(int lowerDamageLimit) {
        if (lowerDamageLimit >= this.upperDamageLimit) {
            throw new IllegalArgumentException("\"Lower damage limit\" must be less then \"Upper damage limit\"");
        }
        this.lowerDamageLimit = lowerDamageLimit;
    }

    protected int getUpperDamageLimit() {
        return upperDamageLimit;
    }

    protected void setUpperDamageLimit(int upperDamageLimit) {
        if (this.lowerDamageLimit >= upperDamageLimit) {
            throw new IllegalArgumentException("\"Lower damage limit\" must be less then \"Upper damage limit\"");
        }
        this.upperDamageLimit = upperDamageLimit;
    }

}
