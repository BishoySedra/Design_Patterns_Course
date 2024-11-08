interface Duck{
    public void quack();
    public void fly();
}

class MallardDuck implements Duck{
    public void quack(){
        System.out.println("Quack");
    }
    public void fly(){
        System.out.println("I am flying");
    }
}

interface Turkey{
    public void gobble();
    public void fly();
}

class WildTurkey implements Turkey{
    public void gobble(){
        System.out.println("Gobble gobble");
    }
    public void fly(){
        System.out.println("I am flying a short distance");
    }
}

class TurkeyAdapter implements Duck{
    private Turkey turkey;

    TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }

    public void quack(){
        turkey.gobble();
    }

    public void fly(){
        turkey.fly();
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();

        System.out.println("The Duck says...");
        duck.quack();

        System.out.println("The TurkeyAdapter says...");
        turkeyAdapter.quack();
    }
}
