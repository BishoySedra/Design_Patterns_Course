final class Counter{

    public int count = 0;

    private static Counter instance = null;

    private Counter(){}

    public static Counter getInstance(){
        if(instance == null){
            instance = new Counter();
        }
        return instance;
    }

    public void increment(){
        count++;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        // Counter counter = new Counter();
        // counter.increment();
        // System.out.println(counter.count);
        // Counter counter2 = new Counter();
        // counter2.increment();
        // System.out.println(counter2.count);

        Counter counter = Counter.getInstance();
        counter.increment();
        System.out.println("Counter 1: " + counter.count);
        Counter counter2 = Counter.getInstance();
        counter2.increment();
        counter2.increment();   
        System.out.println("Counter 2: " + counter2.count);
    }
}
