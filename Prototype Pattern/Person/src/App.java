class Address implements Cloneable {
    String city;
    Address(String city) {
        this.city = city;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class PersonRecord implements Cloneable{
    private int id;
    private String name;
    private double salary;
    private Address address;

    PersonRecord(){}

    PersonRecord(int id, String name, double salary, Address address){
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object deepCopy() throws CloneNotSupportedException {
        PersonRecord record = (PersonRecord) super.clone();
        record.address = (Address) address.clone();
        return record;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Address address = new Address("Bangalore");
        PersonRecord record1 = new PersonRecord(1, "John", 1000, address);
        record1.showRecord();

        PersonRecord record2 = (PersonRecord) record1.deepCopy();
        // PersonRecord record2 = (PersonRecord) record1.shallowCopy();
        record2.showRecord();

        address.city = "Mysore";
        record1.showRecord();
        record2.showRecord();
    }
}
