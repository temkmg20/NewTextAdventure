public class Ninja extends Enemy {
    public String toString() {
        return "Ninja";
    }


    public Ninja (String name){
        this.name = name;
        this.health = Math.random() * 80 + 20;
    }



}
