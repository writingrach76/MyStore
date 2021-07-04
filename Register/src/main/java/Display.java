import java.util.ArrayList;

public class Display {
double _salesTax = 0.06;


    public void textDisplay(ArrayList<Item> items)
    {
        double total = 0;
        double tax = 0;

        // test text display within the console
        for( Item i: items)
        {
            total += i.getCost();
            if(i.isTaxable())
            {
                tax += (i.getCost() * _salesTax);
            }
            System.out.println(i.toString());
        }
        System.out.printf("\n Subtotal %.2f", total);
        System.out.printf("\n Sales Tax: %.2f", tax);
        System.out.printf("\n Total: %.2f", (tax+total));
    }

    public void goDisplay()
    {
        //will display via GUI
    }
}
