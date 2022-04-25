package restms;


public class FTE extends Person{
    private int ID;
    private String JobTitle;
    private int Salary;
    public FTE(int ID, String JobTitle, int Salary, String name, int age, String number, String address) {
        super(name, age, number, address);
        this.ID = ID;
        this.JobTitle = JobTitle;
        this.Salary = Salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }



    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public int getSalary() {
        return Salary;
    }

    public void setJobTitle(String JobTitle) {
        this.JobTitle = JobTitle;
    }

    public String getJobTitle() {
        return JobTitle;
    }
     
     public void printEmp()
    {
        System.out.println("Employee Profile "+"\n-----------------"+"Employee Name: " + getName() + "Job Title: " + getJobTitle() + "\n"
                + "\n"+ "ID: "+ getID()+ "\n" +"Age: " + getAge() + "\n" + "Phone Number: " 
                + getNumber()+ "\n" + "Address: " + getAddress()+ "\n" + "Salary: " + getSalary() );
    }

    @Override
    public String toString() {
        return super.toString()+"\nID: " + ID + "\nJobTitle: " + JobTitle + "Salary: " + Salary;
    }
    
}