import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private ArrayList<Item> _itms = new ArrayList<Item>();

    public static void main(String args[])
    {
        boolean finishedScanning = false;
        do {
            getItem();
        }while(!finishedScanning);

    }

    public static void getItem()
    {
        Scanner in = new Scanner(System.in);
        String supc = in.nextLine();
        int upc = Integer.getInteger(supc);
        

    }



}
