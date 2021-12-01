public class Warrior extends Enemy{


    public Warrior (String name){
        this.name=name;
        this.health = Math.random() * 80 + 20;
    }

}
