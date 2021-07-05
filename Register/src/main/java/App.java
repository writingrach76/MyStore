import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class App {
    private static ArrayList<Item> _itms = new ArrayList<Item>();
    private static Display d = new Display();

    public static void main(String args[])
    {
        /*
        boolean finishedScanning = false;
        int temp = 0;
        do {
            getItem();
            if(temp == 2)
                finishedScanning = true;
            temp++;
        }while(!finishedScanning);

        d.textDisplay(_itms);
    */
        beginScanning();

    }

    public static void beginScanning()
    {
        System.out.println("Scanning!");
        File purchase = new File("Purchase.txt");
        Scanner in;
        try {
            in = new Scanner(purchase);
        }
        catch(IOException e)
            {
                System.out.println("Scanner Error");
                e.printStackTrace();
                in = new Scanner(System.in);
            }

        try{
            FileWriter fw = new FileWriter("Receipt.txt");
            double subTotal = 0.0, tax = 0.0, salesTax = 0.06;

            while (in.hasNextLine()) {
                System.out.println("Scanner connection successful");
                String supc = in.nextLine();
                System.out.println("upc: " + supc);
                int upc = Integer.parseInt(supc);
                Item temp = findDummy(upc);
                if (temp != null) {
                    _itms.add(temp);
                    subTotal += temp.getCost();
                    if (temp.isTaxable()) {
                        tax += (temp.getCost() * salesTax);
                    }
                    fw.write(temp.toString());

                }
            }

                fw.write(String.format("\n Subtotal %.2f", subTotal));
                fw.write(String.format("\n Sales Tax: %.2f", tax));
                fw.write(String.format("\n Total: %.2f", (tax+subTotal)));
                fw.close();
                in.close();
                System.out.println("end scanning!");

        }
        catch(IOException e)
        {
           System.out.println("FileWriter Error");
        }
    }

    public static void displayText()
    {
        Scanner in = new Scanner("Receipt.txt");
        while(in.hasNext())
        {
            System.out.println(in.nextLine());
        }
        in.close();
    }


    public static void getItem()
    {
        System.out.println("scanning!");
        Scanner in = new Scanner(System.in);
        String supc = in.nextLine();
        int upc = Integer.parseInt(supc);
        Item i = findItem(upc);
        if( i != null)
        {
            _itms.add(i);
        }
        else
        {
            System.out.println("item not found");
        }
    }

    /*
     * Will find the item in the database, currently returns dummy values
     */
    public static Item findItem(int upc)
    {
        Item i = findDummy(upc);
        return i;
    }

    public static Item findDummy(int upc)
    {
        Item toReturn;
        switch(upc)
        {
            case 1234:
                toReturn = new Item("Eggs", 1.99, upc);
                break;

            case 1235:
                toReturn = new Item("Chocolate Bar", 0.99, upc);
                break;

            case 1244:
                toReturn = new Item("Blanket", 29.99, upc);
                break;

            case 1111:
                toReturn = new Item("Test Item", 1.00, upc);
                break;

            default:
                toReturn = null;
                break;
        }
        return toReturn;
    }
}
