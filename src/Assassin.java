public class Assassin extends Enemy {

    @Override
    public String toString() {
        return "Assassin";
    }

    public Assassin(String name){
        this.name=name;
        this.health = Math.random() * 80 + 20;

    }

}
