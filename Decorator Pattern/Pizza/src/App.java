interface Pizza {
    String getDescription();
    double getCost();
}

class PlainPizza implements Pizza{

    @Override
    public String getDescription() {
        return "Thin Dough";
    }

    @Override
    public double getCost() {
        return 4.00;
    }

}

class ToppingDecorator extends PlainPizza{
    
     protected Pizza tempPizza;   

     public ToppingDecorator(Pizza temPizza){
        this.tempPizza = temPizza;
     }

     
    public String getDescription() {
        return tempPizza.getDescription();
    }

    
    public double getCost() {
        return tempPizza.getCost();
    }
    
}

class Mozzarella extends ToppingDecorator{
    public Mozzarella(Pizza newPizza){
        super(newPizza);
        System.out.println("Adding Mozzarella!!");
    }

    public String getDescription(){
        return tempPizza.getDescription() + ", Mozzaralla.";
    }

    public double getCost(){
        System.out.println("Mozzarella cost is = " + 0.5);
        return tempPizza.getCost() + 0.5;
    }
}

class TomatoSauce extends ToppingDecorator{
    public TomatoSauce(Pizza newPizza){
        super(newPizza);
        System.out.println("Adding Tomato Sauce!!");
    }

    public String getDescription(){
        return tempPizza.getDescription() + ", Tomato Sauce.";
    }

    public double getCost(){
        System.out.println("Tomato Sauce cost is = " + 0.35);
        return tempPizza.getCost() + 0.35;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));
        System.out.println("Ingredients: " + basicPizza.getDescription());
        System.out.println("Cost: " + basicPizza.getCost());
    }
}
