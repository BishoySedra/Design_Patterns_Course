interface Shape{
    void draw(int x1, int y1, int x2, int y2);
}

class LegacyRectangle{
    public void draw(int x1, int y1, int w, int h){
        System.out.println("Drawing Legacy Rectangle!");
    }
}

class RecAdapter implements Shape{
    private LegacyRectangle legacyRectangle;

    RecAdapter(LegacyRectangle legacyRectangle){
        this.legacyRectangle = legacyRectangle;
    }

    @Override
    public void draw(int x1, int y1, int x2, int y2){
        int x = Math.min(x1,x2);
        int y = Math.min(y1,y2);
        int width = Math.abs(x1-x2);
        int height = Math.abs(y1-y2);
        legacyRectangle.draw(x, y, width, height);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
