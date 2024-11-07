interface IIceCream{
    void make();
}

class SimpleIceCream implements IIceCream{
    @Override
    public void make(){
        System.out.println("Making Ice Cream ...");
    }
}

class IceCreamDecorator implements IIceCream{
    
    private IIceCream wrapper;
    
    IceCreamDecorator(IIceCream iceCream){
        this.wrapper = iceCream;
    }

    @Override
    public void make(){
        wrapper.make();
    }
}

class WithWafers extends IceCreamDecorator{
    WithWafers(IIceCream iceCream){
        super(iceCream);
        System.out.println("Adding Wafers");
    }

    public void make(){
        super.make();
        System.out.println(", Wafers");
    }
}

class WithFruits extends IceCreamDecorator{
    WithFruits(IIceCream iceCream){
        super(iceCream);
        System.out.println("Adding Fruits");
    }

    public void make(){
        super.make();
        System.out.println(", Fruits");
    }
}

class WithNuts extends IceCreamDecorator{
    WithNuts(IIceCream iceCream){
        super(iceCream);
        System.out.println("Adding Nuts");
    }

    public void make(){
        super.make();
        System.out.println(", Nuts");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        IIceCream iceCream = new WithNuts(new WithWafers(new SimpleIceCream()));
        iceCream.make();
    }
}
