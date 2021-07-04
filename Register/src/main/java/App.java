import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Item> _itms = new ArrayList<Item>();
    private static Display d = new Display();

    public static void main(String args[])
    {
        boolean finishedScanning = false;
        int temp = 0;
        do {
            getItem();
            if(temp == 2)
                finishedScanning = true;
            temp++;
        }while(!finishedScanning);

        d.textDisplay(_itms);

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
