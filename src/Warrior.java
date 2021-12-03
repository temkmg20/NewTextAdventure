public class Warrior extends Enemy{

    public String toString() {
        return "Warrior";
    }

    public Warrior (String name){
        this.name=name;
        this.health = Math.random() * 80 + 20;
    }

}




