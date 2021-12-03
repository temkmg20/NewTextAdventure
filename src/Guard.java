public class Guard extends Enemy{
    public String toString() {
        return "Guard";
    }


        public Guard (String name){
            this.name=name;
            this.health = Math.random() * 80 + 20;
        }

    }

