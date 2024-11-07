public class App {
    public static void main(String[] args) throws Exception {
       // initialize product builder object
       productBuilder builder = new productBuilder();
       builder.setName("Product_1");
       builder.setPrice(200.34f);
       builder.setCategory("Laptops");
       Product product = builder.build();
       product.display();
    }
}

class Product{
    private String name;
    private float price;
    private String Category;

    Product(String name, float price, String Category){
        this.name = name;
        this.price = price;
        this.Category = Category;
    }

    void display(){
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Category: " + Category);
    }
}

interface productBuilderInterface {
    void setName(String name);
    void setPrice(float price);
    void setCategory(String category);
}

class productBuilder implements productBuilderInterface{
    private String name;
    private float price;
    private String Category;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public void setCategory(String category) {
        this.Category = category;
    }

    Product build(){
        return new Product(name, price, Category);
    }

}