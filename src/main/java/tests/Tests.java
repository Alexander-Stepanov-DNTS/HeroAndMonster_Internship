package tests;

import model.interfaces.Creature;

public class Tests {

    // Small monster
    public boolean test_1() {
        System.out.println("Little monster");
        Creature hero;
        Creature monster;

        try {
            hero = new model.Hero(10, 10, 60, 10, 20);
            monster = new model.Monster(4, 5, 25, 0, 10);
        } catch (IllegalArgumentException ex) {
            System.out.println("wrong data in arguments");
            return false;
        }

        System.out.println("Hero's health is: " + hero.getCurrentHealth());
        System.out.println("Monster's health is: " + monster.getCurrentHealth() + "\n");

        while (!(hero.isDead() || monster.isDead())) {
            System.out.println("Hero hits monster!");
            hero.hit(monster);
            System.out.println("Monster's health is " + monster.getCurrentHealth() + "\n");
            if (monster.isDead()) {
                System.out.println("Hero wins - fatality\n");
                break;
            }
            System.out.println("Monster hits hero!");
            monster.hit(hero);
            System.out.println("Hero's health is " + hero.getCurrentHealth() + "\n");
            if (hero.isDead()) {
                System.out.println("Monster wins - fatality\n");
                break;
            }
        }

        return true;
    }

    // Equal Forces
    public boolean test_2() {
        System.out.println("Middle monster");
        Creature hero;
        Creature monster;

        try {
            hero = new model.Hero(10, 10, 60, 10, 20);
            monster = new model.Monster(12, 8, 50, 5, 25);
        } catch (IllegalArgumentException ex) {
            System.out.println("wrong data in arguments");
            return false;
        }

        System.out.println("Hero's health is: " + hero.getCurrentHealth());
        System.out.println("Monster's health is: " + monster.getCurrentHealth() + "\n");

        while (!(hero.isDead() || monster.isDead())) {
            System.out.println("Hero hits monster!");
            hero.hit(monster);
            System.out.println("Monster's health is " + monster.getCurrentHealth() + "\n");
            if (monster.isDead()) {
                System.out.println("Hero wins - fatality\n");
                break;
            }
            System.out.println("Monster hits hero!");
            monster.hit(hero);
            System.out.println("Hero's health is " + hero.getCurrentHealth() + "\n");
            if (hero.isDead()) {
                System.out.println("Monster wins - fatality\n");
                break;
            }
        }

        return true;
    }

    // Strong monster
    public boolean test_3() {
        System.out.println("Big monster");
        Creature hero;
        Creature monster;

        try {
            hero = new model.Hero(10, 10, 60, 10, 20);
            monster = new model.Monster(20, 20, 200, 20, 30);
        } catch (IllegalArgumentException ex) {
            System.out.println("wrong data in arguments");
            return false;
        }

        System.out.println("Hero's health is: " + hero.getCurrentHealth());
        System.out.println("Monster's health is: " + monster.getCurrentHealth() + "\n");

        while (!(hero.isDead() || monster.isDead())) {
            System.out.println("Hero hits monster!");
            hero.hit(monster);
            System.out.println("Monster's health is " + monster.getCurrentHealth() + "\n");
            if (monster.isDead()) {
                System.out.println("Hero wins - fatality\n");
                break;
            }
            System.out.println("Monster hits hero!");
            monster.hit(hero);
            System.out.println("Hero's health is " + hero.getCurrentHealth() + "\n");
            if (hero.isDead()) {
                System.out.println("Monster wins - fatality\n");
                break;
            }
        }

        return true;
    }
}
