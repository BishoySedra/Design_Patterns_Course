abstract class Beverage{
    protected String description = "Unknown Beverage";
    public String getDescription(){
        return this.description;
    }
    public abstract double cost();
}

class Espresso extends Beverage{
    public Espresso(){
        super.description = "Espresso";
    }

    @Override
    public double cost(){
        return 5.00;
    }
}

class CondimentDecorator extends Beverage{
    
    private Beverage wrapper;
    
    CondimentDecorator(Beverage beverage){
        this.wrapper = beverage;
    }

    public String getDescription(){
        return wrapper.getDescription();
    }

    @Override
    public double cost(){
        return wrapper.cost();
    }
}

class Mocha extends CondimentDecorator{
    Mocha(Beverage beverage){
        super(beverage);
        System.out.println("Adding Mocha!!");
    }

    public String getDescription(){
        return super.getDescription() + ", Mocha";
    }

    @Override
    public double cost(){
        return super.cost() + 5.0;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Beverage beverage = new Mocha(new Mocha((new Espresso())));
        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());
    }
}
