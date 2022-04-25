
package restms;

public class Order {
    private static int DailyTotal;
    private static int[] quantities=new int[26];
    private static String[] Items = new String[26];
    private static int[] prices = new int[26];

    public Order() {
        DailyTotal = 0;
        Items[1]="Lobster Bisque";
        Items[2]="Baked Brie";
        Items[3]="Clams with Vinegar & Shallots";
        Items[4]="Calamari with Tomatoe Sauce";
        Items[5]="Crab bites with yogurt dressing";
        Items[6]="Shrimp Mango Salad";
        Items[7]="Greek Salad";
        Items[8]="Caesar Salad";
        Items[9]="Salmon and Avocado Salad";
        Items[10]="Nicoise Salad";
        Items[11]="Organic Salmon";
        Items[12]="Panfried Cod";
        Items[13]="Pan Fried Sea Bass";
        Items[14]="Grilled lobster tails";
        Items[15]="Trout Mustard Risotto";
        Items[16]="Grapefruit Mint";
        Items[17]="Carrot Limeade";
        Items[18]="Minted Lemonade";
        Items[19]="Fruit Cockatail";
        Items[20]="Coke, Diet Coke, 7up,Miranda";
        Items[21]="Mango parfait with coconut sorbet";
        Items[22]="Chilled chocolate caramel fondant";
        Items[23]="Lemon and Lavender Possets";
        Items[24]="Chocolate Mousse";
        Items[25]="Creme Brulee";
prices[1]=30;
prices[2]=20;
prices[3]=30;
prices[4]=25;
prices[5]=35;
prices[6]=25;
prices[7]=24;
prices[8]=22;
prices[9]=33;
prices[10]=23;
prices[11]=37;
prices[12]=43;
prices[13]=53;
prices[14]=70;
prices[15]=46;
prices[16]=17;
prices[17]=17;
prices[18]=21;
prices[19]=23;
prices[20]=20;
prices[21]=30;
prices[22]=40;
prices[23]=30;
prices[24]=25;
prices[25]=20;


    }

    public static void setDailyTotal(int DailyTotal) {
        Order.DailyTotal = DailyTotal;
    }

    public static void setQuantities(int i, int q) {
        Order.quantities[i] += q ;
    }

    public static void setItems(String[] Items) {
        Order.Items = Items;
    }

    public static void setPrices(int[] prices) {
        Order.prices = prices;
    }

    public static int getDailyTotal() {
        return DailyTotal;
    }

    public static int getQuantities(int i) {
        return quantities[i];
    }

    public static String getItems(int i) {
        return Items[i];
    }

    public static int getPrices(int i) {
        return prices[i];
    }
    public static void incDailyTotal(int x){
    DailyTotal += x;
    }
    
    
}
