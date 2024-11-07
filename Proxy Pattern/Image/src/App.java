interface Image {
    void display();
}

class RealImage implements Image{
    
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        // loadFromDisk(fileName);
    };
    
    @Override
    public void display(){
        System.out.println("Display Image: " + fileName);
    }

    public void loadFromDisk(String fileName){
        System.out.println("Loading from disk: " + fileName);
    }

}

class ProxyImage implements Image{
    
    private String fileName;
    private RealImage realImage;
    
    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display(){
        if(realImage == null){
            realImage = new RealImage(fileName);
            System.out.println("wasn't loaded from disk!");
            realImage.display();
            return;
        }
        System.out.println("Already loaded from disk!");
        realImage.display();
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        Image image = new ProxyImage("Bishoy.jpg");

        // load from disk
        image.display();

        System.out.println();

        // not loaded from disk
        image.display();
    }
}
