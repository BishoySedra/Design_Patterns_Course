public class App {
    public static void main(String[] args) throws Exception {
        // initialize factory obj
        GUIFactory guiApp = null;
        boolean isWindows = false;

        if(isWindows){
            guiApp = new WinFactory();
        }else{
            guiApp = new MacFactory();
        }

        Application app = new Application(guiApp);
        app.run();

        // // creating button and rendering it
        // Button btn = guiApp.createButton();
        // btn.render();

        // // creating checkbox and rendering it
        // Checkbox checkbox = guiApp.createCheckbox();
        // checkbox.render();
    }
}

// interface button
interface Button {
    void render();
}

// interface checkbox
interface Checkbox{
    void render();
}

class WinButton implements Button{
    @Override
    public void render(){
        System.err.println("Windows button!!");
    }
}

class WinCheckbox implements Checkbox{
    @Override
    public void render(){
        System.err.println("Windows Checkbox!!");
    }
}

class MacButton implements Button{
    @Override
    public void render(){
        System.err.println("Mac button!!");
    }
}

class MacCheckbox implements Checkbox{
    @Override
    public void render(){
        System.err.println("Mac Checkbox!!");
    }
}

// interface factory
interface GUIFactory{
    Button createButton();
    Checkbox createCheckbox();
}

class WinFactory implements GUIFactory{
    public Button createButton(){
        return new WinButton();
    }
    public Checkbox createCheckbox(){
        return new WinCheckbox();
    }
}

class MacFactory implements GUIFactory{
    public Button createButton(){
        return new MacButton();
    }
    public Checkbox createCheckbox(){
        return new MacCheckbox();
    }
}

class Application {
    private Button button;
    private Checkbox checkbox;
    private GUIFactory factory;

    Application(GUIFactory factory){
        this.factory = factory;
    }

    public void createApp(){
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void run(){
        createApp();
        button.render();
        checkbox.render();
    }
}