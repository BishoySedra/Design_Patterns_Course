interface prototype {
    prototype getClone();
}

class Address {
    String city;
    Address(String city) {
        this.city = city;
    }
}

class EmployeeRecord implements prototype{
    private int id;
    private String name;
    private double salary;
    private Address address;

    EmployeeRecord(){
        System.out.println("   Employee Records of Oracle Corporation ");    }

    EmployeeRecord(int id, String name, double salary, Address address){
        this();
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    void setAddress(Address address) {
        this.address = address;
    }

    public void showRecord(){
        System.out.println(id + " " + name + " " + salary + " " + address.city);
    }

    public prototype getClone(){
        return new EmployeeRecord(id, name, salary, address);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int id = 1;
        String name = "John";
        double salary = 10000;
        Address address = new Address("Cairo");

        EmployeeRecord e1 = new EmployeeRecord(id, name, salary, address);
        e1.showRecord();
        System.out.println("\n");
        EmployeeRecord e2 = (EmployeeRecord) e1.getClone();
        e2.showRecord();
        e2.setAddress(new Address("Alex"));
        e2.showRecord();
        e1.showRecord();
    }
}
