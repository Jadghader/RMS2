package restms;
abstract public class Person {
    private String name;
    private int age;
    private String phonenumber;
    private String address;
    
public Person(String name, int age, String number, String address) {
        this.name = name;
        this.age = age;
        this.phonenumber = number;
        this.address = address;
      
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return phonenumber;
    }

    public void setNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "\nName: " + name + "\nAge: " + age + "\nPhonenumber: " + phonenumber + "\nAddress: " + address;
    }

}
