public class Assassin extends Enemy {

    public Assassin(String name){
        this.name=name;
        this.health = Math.random() * 80 + 20;
    }

}
