import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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

    public static Item fromUPC(int upc){
        final String protocol = "http://";
        final String url_base = "localhost:8000";
        final String route = "/item/";
        final String url_route = protocol + url_base + route + Integer.toString(upc);
        HttpURLConnection conn = null;
        try{
            URL url = new URL(url_route);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "text");
            conn.setUseCaches(false);

            if (conn.getResponseCode() != 200) {
                System.err.println("failed to get item");
                return null;
            }

            BufferedReader rd =
                    new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuffer response = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null){
                response.append(line);
                response.append("\n");
            }

            String body = response.toString();
            if (body.equals("")){
                System.err.println("no item returned");
            }

            JSONObject obj = new JSONObject(response.toString());

            String name = obj.getString("item_name");
            double cost = obj.getDouble("item_cost");

            return new Item(name, cost, upc);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }


}
