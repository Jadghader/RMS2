package restms;
import java.util.*;

public class Table {
        private Customer C;
        private int size;
        private int num;
        private boolean Free = true; 

    public Table() {
    }

    public Table(Customer C1, int size, int num, boolean Free) {
        this.C = C1;
        this.size = size;
        this.num = num;
        this.Free = Free;
    }

    public Table(int size, int num) {
        this.size = size;
        this.num = num;
    }

    public void setC(Customer C) {
        this.C = C;
    }

    public Customer getC() {
        return C;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isFree() {
        return Free;
    }

    public void setFree(boolean Free) {
        this.Free = Free;
    }
    public static void ReserveT(int GuestsNum, Customer C1){
    for(Table t : RestMS.tables){ 
    if(t.isFree() && GuestsNum<= t.getSize()){
    t.Free=false;
    break;
    }
    }
    }
public static void UnreserveT(int num){
for(Table t : RestMS.tables){
if(t.num == num){
t.Free= true;
break;
}
}
}

    @Override
    public String toString() {
        return "Customer info:" + C.toString() + "\nSize: " + size + "\nTable Number: " + num;
    }

}
