public class Item {
    public String _name;
    public double _cost;
    public int _upc;

    public Item(String name, double cost, int upc)
    {
        _name = name;
        _cost = cost;
        _upc = upc;
    }

    public String toString()
    {
        return _name + "\t \t " + _cost + "\n" + _upc;
    }

    public double getCost()
    {
        return _cost;
    }

    /*
    * will return if item can be taxed
     */
    public boolean isTaxable()
    {
        return false;
    }


}
