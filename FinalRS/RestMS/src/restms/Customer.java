package restms;
public class Customer extends Person {
    private String email;
public Customer(String email, String name, int age, String number, String address) {
        super(name, age, number, address);
        this.email = email;
    }
    public Customer(String name, int age, String number, String address) {
        super(name, age, number, address);
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString()+"\nEmail: " + email;
    }

    

}
