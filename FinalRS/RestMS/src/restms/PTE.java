package restms;

public class PTE extends Person {
    private int ID;
    private int sph;
    private String JobTitle;

    public PTE(int ID, int sph, String JobTitle, String name, int age, String number, String address) {
        super(name, age, number, address);
        this.ID = ID;
        this.sph = sph;
        this.JobTitle = JobTitle;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSph() {
        return sph;
    }

    public void setSph(int sph) {
        this.sph = sph;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String JobTitle) {
        this.JobTitle = JobTitle;
    }

   
    public int CalcSalary(int hour)
    {
        return hour * sph;
    }

    public void printEmp()
    {
        System.out.println("Employee Profile "+"\n-----------------"+"Employee Name: " + getName() + "Job Title: " + getJobTitle() + "\n"
                + "\n"+ "ID: "+ getID()+ "\n" +"Age: " + getAge() + "\n" + "Phone Number: " 
                + getNumber()+ "\n" + "Address: " + getAddress()+ "\n" + "Salary: " + CalcSalary(sph) );
    }

    @Override
    public String toString() {
        return "ID: " + ID + "Sph: " + sph + "JobTitle: " + JobTitle;
    }
    
}