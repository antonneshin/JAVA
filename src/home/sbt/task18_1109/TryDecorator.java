package src.home.sbt.task18_1109;

/**
 * Created by Пентагон on 11.09.2016.
 */
interface Warrior{
    public int getHP();
    public String getAmmunition();
}

class Civilian implements Warrior{
    @Override
    public int getHP() {
        return 50;
    }

    @Override
    public String getAmmunition() {
        return "legs hands and head";
    }
}

abstract class WarriorDecorator implements Warrior{
    protected final Warrior warrior;

    public WarriorDecorator(Warrior warrior) {
        this.warrior = warrior;
    }

    @Override
    public int getHP() {
        return warrior.getHP();
    }

    @Override
    public String getAmmunition() {
        return warrior.getAmmunition();
    }
}

class Helm extends WarriorDecorator{
    public Helm(Warrior warrior) {
        super(warrior);
    }

    @Override
    public int getHP() {
        return super.getHP()+200;
    }

    @Override
    public String getAmmunition() {
        return super.getAmmunition()+" Titanium helm ";
    }
}

class Sword extends WarriorDecorator{
    public Sword(Warrior warrior) {
        super(warrior);
    }

    @Override
    public int getHP() {
        return super.getHP()+1000;
    }

    @Override
    public String getAmmunition() {
        return super.getAmmunition()+" Eckskalibur ";
    }
}


public class TryDecorator {
    public static void main(String[] args) {
        Civilian civilian = new Civilian();
        System.out.println("civilian's HP = "+civilian.getHP());
        System.out.println("civilian's ammunition: "+civilian.getAmmunition());

        Warrior magneto = new Helm(civilian);
        System.out.println("magneto's HP = "+magneto.getHP());
        System.out.println("magneto's ammunition: "+magneto.getAmmunition());

        Warrior superWarrior = new Sword(new Helm(civilian));
        System.out.println("superWarrior's HP = "+superWarrior.getHP());
        System.out.println("superWarrior's ammunition: "+superWarrior.getAmmunition());
    }
}
