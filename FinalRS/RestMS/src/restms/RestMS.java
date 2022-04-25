package restms;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class RestMS {
    Scanner input = new Scanner(System.in);
    public static List<Table> tables = new ArrayList<>();
    public static List<FTE> Full = new ArrayList<>();
    public static List<PTE> Part = new ArrayList<>();
    public static List<Customer> Cust = new ArrayList<>();
    public static int[] prices = new int[26];
    public static int i = 0;
public static void main(String[] args) {
    Order Day = new Order();
    createTable(3);
    createTable(2);
    createTable(6);
    createTable(5);
    createTable(10);
    createTable(3);
    createTable(4);
    mainPage();



}
public static void printMenu(){
try{
        File menu = new File("C:\\Users\\hamza\\Desktop\\RMS\\Menu.txt");
        Scanner mymenu = new Scanner(menu);

        while(mymenu.hasNextLine())
        {
        String data = mymenu.nextLine();
        System.out.println(data);
         }
        mymenu.close();
    } catch(FileNotFoundException e)
    {
        System.out.println("An error occured.");
        e.printStackTrace();
    }
}
public static void createTable(int size){

    tables.add(new Table(size, ++i));        
}
public static void removeTable(int num){
tables.remove(num-1);
for(Table t: tables){
if(t.getNum()>=num){
t.setNum(t.getNum()-1);
}
}
}
public static void mainPage(){
    Scanner input = new Scanner(System.in);
    System.out.println("1) Order From Menu\n2) Table Reservations\n3) Total Sales\n4) Customer/Employee Managment\n5) Edit Tables\n6) End of Day");
    int choice = input.nextInt();
            if (choice == 1){
        Order();
    }
    if (choice == 2){
        Tablereservation();
    }
    if (choice == 3){
        Sales();
    }
    if (choice == 4){
           Person();
    }
    if (choice == 5){
        Edittables();
    }
    if(choice == 6){
        Endofday();       
    }
    }
public static void PrintSeats(){      
    for (int i = 0 ; i < tables.size() ; ++i){
    System.out.println("Tables number : " + (i+1) + " Size of :  " + tables.get(i).getSize() + " : " + (tables.get(i).isFree()? "Free" : "Reserved") );   

    } 
}
public static void Tablereservation(){
     Scanner input = new Scanner(System.in);
     System.out.println("Enter 1 for reserving or 2 for unresrving 3 view reserved");
     int ntable;
     int rsv = input.nextInt();
     switch(rsv){
         case 1:
             System.out.println("\nTABLE RESERVATION\n");
             System.out.println("-------------------\n"); 
             PrintSeats();
             int free = 0;
             int i = 0;
             for (int j = 0; j < tables.size(); j++) {
                 if(tables.get(j).isFree()){
                 free++;
                 }    
             }
            System.out.println("Number of available tables: "+free);
             System.out.println("Enter the number of table you wish to reserve: ");
            ntable = input.nextInt();
            if(ntable <= tables.size()){
            while(ntable != -1){
            
            if (tables.get(ntable-1).isFree())
            {
                System.out.println("Create new customer(1) or Search (2)");
                int c = input.nextInt();
                switch(c){
                    case 1:
                        addCust();
                        tables.get(ntable-1).setC(Cust.get(Cust.size()-1));
                        break;
                    case 2:
                        Customer temp = new Customer("","",0,"","");
                        temp = searchC();
                        tables.get(ntable-1).setC(temp);
                        PrintSeats();
                        System.out.println(temp.toString());
                        Tablereservation();
                        break;
                }
                tables.get(ntable-1).setFree(false);
                        System.out.println("\nYour table has been reserved!");
                        PrintSeats();
                        Tablereservation();
                    }
            else{
                    System.out.println("Table is reserved , Enter another table:");
                    ntable = input.nextInt();
                }
            }
            }
            else{
                 System.out.println("Number of table,is not found");
                Tablereservation();
                    }
           
     
           break; 
     case 2:
         System.out.println("\nTABLE UNRESERVATION\n");
             System.out.println("-------------------\n"); 
              free = 0;
              i = 0;
             for (int j = 0; j < tables.size(); j++) {
                 if(tables.get(j).isFree() == false ){
                 free++;
                 }    
             }
            System.out.println("Number of reserved tables: " +free);
             System.out.println("Enter the number of table you wish to unreserve: ");
            ntable = input.nextInt();
            if(ntable <= tables.size()){
            while(ntable != -1){
            
            if (tables.get(ntable-1).isFree() == false )
            {
                tables.get(ntable-1).setFree(true);
                        System.out.println("\nYour table has been unreserved!");
                        PrintSeats();
                        Tablereservation();
                    }
            else{
                    System.out.println("Table is unreserved , Enter another table:");
                    ntable = input.nextInt();
                }}

            }
     else{
                System.out.println("Number of table,is not found , Please enter another table:");
                Tablereservation();
             }
            break;
     case 3: 
         for (int j = 0; j < tables.size()-1; j++) {
                 if(!tables.get(j).isFree()){
                     System.out.println(tables.get(j).toString());
                 }}
         System.out.println("Enter any number: ");
            int batata = input.nextInt();
         
         break;
         
     default:
         mainPage();
     }
     mainPage();
 }
public static void Order(){
printMenu();
    Scanner input = new Scanner(System.in);
    int itemnb;
    int quantity;
    int Total=0;
    String s="";
    System.out.println("Enter the number of item you wish to order: ");
    itemnb = input.nextInt();
    while(true){
    if (itemnb<=25 && itemnb>=1){
        System.out.println("Enter quantity: ");
        quantity= input.nextInt();
        Order.setQuantities(itemnb,quantity);
        Total += quantity*Order.getPrices(itemnb);
        Order.incDailyTotal(quantity*Order.getPrices(itemnb));
        s = s+String.format("%d %-40s\t$%5d\n",quantity,Order.getItems(itemnb),quantity*Order.getPrices(itemnb) );
        System.out.println(s+"Total="+Total+"$");
        System.out.println("Enter the number of item you wish to order: ");
        itemnb = input.nextInt();
        
    }
    else{
        mainPage();
    }
    }
}
public static void Sales(){
    Scanner input = new Scanner(System.in);
    for (int j = 1; j < 26; j++) {
        System.out.println(String.format("%-40s\t%5d%5d$", Order.getItems(j),Order.getQuantities(j),(Order.getQuantities(j)*Order.getPrices(j))));
    }
    System.out.println("Total Sales = $"+Order.getDailyTotal());
    System.out.println("Enter any number to exit");
    int batata = input.nextInt();
    mainPage();
}
public static void Endofday(){
Scanner input = new Scanner(System.in);
    System.out.println(sales+"Total= "+Order.getDailyTotal());
    System.out.println("Enter any number to exit");
    int batata = input.nextInt();
    System.exit(batata);
}
public static void Edittables(){
Scanner input = new Scanner(System.in);
     System.out.println("Enter 1 for adding and 2 for removing");
     int size;
     int nb;
     int choice = input.nextInt();
     switch(choice){
         case 1:
             PrintSeats();
             System.out.println("Enter size of the table: ");
             size= input.nextInt();
             createTable(size);
             PrintSeats();
             Edittables();
             break;
         case 2:
             PrintSeats();
             System.out.println("Enter table number: ");
             nb = input.nextInt();
             removeTable(nb);
             PrintSeats();
             Edittables();
         default:
             mainPage();
     }
}
public static void Person(){
    Scanner input = new Scanner(System.in);
    System.out.println("1)Employees\n2)Add Customer\n3)Search Customer");
    int choice1 = input.nextInt();
    switch (choice1){
            case 1:
                printEmp();
                System.out.println("\n1)Adding FTE\n2)Adding PTE\n2)Removing Employee");
                int choice2 = input.nextInt();
                switch(choice2){
                    case 1: 
                        addFTE();
                        break;
                    case 2:
                        addPTE(); 
                        break;
                    case 3: 
                        removeE();
                        break;
                }
            case 2:
                addCust(1);
                mainPage();
                break;
            case 3:
                searchC(1);
                mainPage();
                break;
            default: 
                mainPage();
    }
}
public static void printCust(){
    for (int j = 0; j <Cust.size() ; j++) {
        System.out.println(Cust.get(j).toString());
        System.out.println("-------------------------------------------");
    }
}
public static void printEmp(){
for (int j = 0; j <Full.size() ; j++) {
        System.out.println(Full.get(j).toString());
        System.out.println("-------------------------------------------");
    }
    System.out.println("///////////////////////////////////////");
    for (int j = 0; j <Part.size() ; j++) {
        System.out.println(Part.get(j).toString());
        System.out.println("-------------------------------------------");
    }
}
public static void addPTE(){
Scanner input = new Scanner(System.in);
int ID; 
int sph; 
String JobTitle; 
String name; 
int age; 
String number; 
String address;
System.out.println("\nEnter ID: ");
ID = input.nextInt();
System.out.println("Enter sph: ");
sph = input.nextInt();
System.out.println("Enter Job Title: ");
JobTitle = input.next();
System.out.println("Enter Name: ");
name = input.next();
System.out.println("Enter Age: ");
age = input.nextInt();
System.out.println("Enter Phone Number: ");
number = input.next();
System.out.println("Enter Address: ");
address = input.next();
Part.add(new PTE(ID,sph,JobTitle,name,age,number,address));
printEmp();
System.out.println("Enter any number: ");
int batata = input.nextInt();
mainPage();
    
}
public static void addFTE(){
Scanner input = new Scanner(System.in);
int ID; 
int salary; 
String JobTitle; 
String name; 
int age; 
String number; 
String address;
System.out.println("\nEnter ID: ");
ID = input.nextInt();
System.out.println("Enter Salary: ");
salary = input.nextInt();
System.out.println("Enter Job Title: ");
JobTitle = input.next();
System.out.println("Enter Name: ");
name = input.next();
System.out.println("Enter Age: ");
age = input.nextInt();
System.out.println("Enter Phone Number: ");
number = input.next();
System.out.println("Enter Address: ");
address = input.next();
Full.add(new FTE(ID,JobTitle,salary,name,age,number,address));
printEmp();
System.out.println("Enter any number: ");
int batata = input.nextInt();
mainPage();
}
public static void addCust(int i){
Scanner input = new Scanner(System.in);
String name; 
int age; 
String number; 
String address;
String email;
System.out.println("Enter Name: ");
name = input.next();
System.out.println("Enter Age: ");
age = input.nextInt();
System.out.println("Enter Phone Number: ");
number = input.next();
System.out.println("Enter Address: ");
address = input.next();
System.out.println("Enter Email: ");
email = input.next();
Cust.add(new Customer(email,name,age,number,address));
printCust();
System.out.println("Enter any number: ");
int batata = input.nextInt();
}
public static void removeE(){
Scanner input = new Scanner(System.in);
int ID = 0;
    System.out.println("Enter ID to remove: ");
    ID = input.nextInt();
    for (int j = 0; j < Part.size(); j++) {
        if(ID == Part.get(j).getID()){
            Part.remove(j);
            printEmp();
            System.out.println("Enter any number: ");
            int batata = input.nextInt();
            mainPage();
        }
    }
    for (int j = 0; j < Full.size(); j++) {
        if(ID == Full.get(j).getID())
            Full.remove(j);
            printEmp();
            System.out.println("Enter any number: ");
            int batata = input.nextInt();
            mainPage();
    }
    
}
public static void searchC(int i){
Scanner input = new Scanner(System.in);
    System.out.println("\nEnter Customer Phone Number: ");
    String pn = input.next();
    for (int j = 0; j < Cust.size(); j++) {
        if(Cust.get(j).getNumber().equals(pn)){
            System.out.println(Cust.get(j).toString());
            System.out.println("Enter any number: ");
            int batata = input.nextInt();
            Person();
        }
    }
    System.out.println("Customer not found:");
     System.out.println("Enter any number: ");
            int batata = input.nextInt();
            Person();
}
public static Customer searchC(){
Scanner input = new Scanner(System.in);
    System.out.println("\nEnter Customer Phone Number: ");
    String pn = input.next();
    for (int j = 0; j < Cust.size(); j++) {
        if(Cust.get(j).getNumber().equals(pn)){
            System.out.println(Cust.get(j).toString());
            System.out.println("Enter any number: ");
            int batata = input.nextInt();
            return Cust.get(j);
        }
    }
    
            System.out.println("Not Found, Try Again (1) or Create New(2)");
        int choice = input.nextInt();
        switch(choice){
            case 1:
                return searchC();
            case 2:
                return addCust();
        }
        return null;
}
public static Customer addCust(){
Scanner input = new Scanner(System.in);
String name; 
int age; 
String number; 
String address;
String email;
System.out.println("Enter Name: ");
name = input.next();
System.out.println("Enter Age: ");
age = input.nextInt();
System.out.println("Enter Phone Number: ");
number = input.next();
System.out.println("Enter Address: ");
address = input.next();
System.out.println("Enter Email: ");
email = input.next();
Cust.add(new Customer(email,name,age,number,address));
return Cust.get(Cust.size()-1);
}}


