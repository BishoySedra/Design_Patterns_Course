interface prototype{
    prototype clone();
}

class Device implements prototype{
    protected String manufacturer_name;
    protected int screen_size;
    protected int RAM;
    protected String Operating_system;
    protected int capacity;
    protected int price;
    protected int Quantity;

    Device(String manufacturer_name, int screen_size, int RAM, String Operating_system, int capacity, int price, int Quantity){
        this.manufacturer_name = manufacturer_name;
        this.screen_size = screen_size;
        this.RAM = RAM;
        this.Operating_system = Operating_system;
        this.capacity = capacity;
        this.price = price;
        this.Quantity = Quantity;
    }

    public void displayCharacteristics(){
        System.out.println("Manufacturer Name: "+manufacturer_name);
        System.out.println("Screen Size: "+screen_size);
        System.out.println("RAM: "+RAM);
        System.out.println("Operating System: "+Operating_system);
        System.out.println("Capacity: "+capacity);
        System.out.println("Price: "+price);
        System.out.println("Quantity: "+Quantity);
    }

    public void showTotalPrice(){
        System.out.println("Total Price: "+(price*Quantity));
    }

    @Override
    public prototype clone(){
        return new Device(manufacturer_name, screen_size, RAM, Operating_system, capacity, price, Quantity);
    }
}

class Laptop extends Device{
    protected String keyboard_type;

   Laptop(String manufacturer_name, int screen_size, int RAM, String Operating_system, int capacity, int price, int Quantity, String keyboard_type){
       super(manufacturer_name, screen_size, RAM, Operating_system, capacity, price, Quantity);
       this.keyboard_type = keyboard_type;
   }

    public void displayCharacteristics(){
         super.displayCharacteristics();
         System.out.println("Keyboard Type: "+keyboard_type);
    }

    @Override
    public prototype clone(){
        return new Laptop(manufacturer_name, screen_size, RAM, Operating_system, capacity, price, Quantity, keyboard_type);
    }
}

class Tablet extends Device{
    Tablet(String manufacturer_name, int screen_size, int RAM, String Operating_system, int capacity, int price, int Quantity){
        super(manufacturer_name, screen_size, RAM, Operating_system, capacity, price, Quantity);
    }

    @Override
    public prototype clone(){
        return new Tablet(manufacturer_name, screen_size, RAM, Operating_system, capacity, price, Quantity);
    }
};

public class App {
    public static void main(String[] args) throws Exception {
        // Set laptop manufacturer to Lenovo.
        // Set the tablet’s quantity to 2.
        // Show the characteristics and total price of the laptop and the tablet.
        Laptop lap1 = new Laptop("Lenovo", 15, 8, "Windows", 512, 500, 1, "Mechanical");
        Laptop lap2 = (Laptop) lap1.clone();
        lap2.Quantity = 2;

        lap1.displayCharacteristics();
        lap1.showTotalPrice();

        lap2.displayCharacteristics();
        lap2.showTotalPrice();
    }
}
