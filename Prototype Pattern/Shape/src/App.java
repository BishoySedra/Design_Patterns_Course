abstract class Shape{
    private int x, y;
    private String color;

    public Shape(Shape source){
        this.x = source.x;
        this.y = source.y;
        this.color = source.color;
    }

    public abstract Shape clone();
}

class Circle extends Shape{
    private int radius;

    public Circle(){
        super(null);
        this.radius = 0;
    }

    public Circle(Circle source){
        super(source);
        this.radius = source.radius;
    }

    @Override
    public Circle clone() {
        return new Circle(this);
    }
}

class Rectangle extends Shape{
    private int width, height;

    public Rectangle(){
        super(null);
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(Rectangle source){
        super(source);
        this.width = source.width;
        this.height = source.height;
    }

    @Override
    public Rectangle clone() {
        return new Rectangle(this);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Circle circle = new Circle();
        Circle circle2 = circle.clone();
        Rectangle rectangle = new Rectangle();
        Rectangle rectangle2 = rectangle.clone();
    }
}
