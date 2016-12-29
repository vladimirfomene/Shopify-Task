/*
 * File: ShopifyMerchantRevenue.java
 * ===========================================================================
 * This programs calculates the revenue of a shopify merchant. This revenue 
 * includes shipping cost and taxes. The program uses the Google Gson library 
 * for parsing an order json file.
 * @author Vladimir Fomene
 */
package shopify.merchant.revenue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import java.util.List;




public class ShopifyMerchantRevenue {

    
    public static void main(String[] args) {
        //Read from json file and store it in a string
        String json = readFromFileToString("data.json", getBufferedReader("data.json"));
        
        //Initialize json library for parsing.
        Gson gson = new Gson();
        
        //Create a list of java order object from the json string.
        List<Order> orders = gson.fromJson(json, MerchantOrders.class).getListOfOrders();
        
        //Return revenue in US dollars
        double totalRevenueInUsDollars = computeTotalRevenueInUsd(orders);
        
        //Return revenue in Canadian Dollars
        double totalRevenueInCad = computeTotalRevenueInCad(orders);

        //Print US dollars and Canadian Dollars revenue on screen.
        System.out.println("The total revenue of our merchant in US Dollars is "
                + "$" + totalRevenueInUsDollars);
        System.out.println("The total revenue of our merchant in Canadian Dollars is "
                + "$" + totalRevenueInCad);
    }
    
    
    /**
     * Creates a bufferdReader for reading from a file
     * @param filename (name of file to be read)
     * @return bufferedreader of the file you want to read
     */
    private static BufferedReader getBufferedReader(String filename) {
        BufferedReader reader = null;
        
        //Create a new bufferedReader from filename
        try{
          reader = new BufferedReader(new FileReader(filename)); 
        }
        catch (IOException ex) {
          System.out.println(ex.getMessage());
        }
        
        return reader;
    }
    
    
    
    /**
     * Reads a json string from a json file
     * @param filename file to read your json text from
     * @param reader bufferedreader to read json text from file
     * @return returns the json text
     */
    private static String readFromFileToString(String filename, BufferedReader reader){
        String jsonText= "";
        String value;
        
        //reads one line at a time from the file and place it into your jsonText
        try{
            while((value = reader.readLine()) != null){
                jsonText += value;
            }
            //Closes the bufferedReader stream once you are done reading from it.
            reader.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
        return jsonText;
    }
    
    /**
     * Computes the total revenue in CAD by summing the totalPrice of each order.
     * @param orders list of orders made by clients
     * @return totalRevenueInCad total revenue of merchant in CAD.
     */
    private static double computeTotalRevenueInCad(List<Order> orders){
        int totalRevenueInCad = 0;
        for(int i = 0; i < orders.size(); i++){
            //Add order to total revenue if order has been paid 
            if(orders.get(i).getFinancialStatus().equalsIgnoreCase("paid")){
                totalRevenueInCad += Double.parseDouble(orders.get(i).getTotalPriceInCad());
            }
            
        }
        return totalRevenueInCad;
    }
    
    
    /**
     * Computes the total revenue of merchants in US dollars
     * @param orders list of orders placed by clients
     * @return totalRevenueInUsd total revenue of merchant in USD.
     */
    private static double computeTotalRevenueInUsd(List<Order> orders){
        int totalRevenueInUsd = 0;
        for(int i = 0; i < orders.size(); i++){
            /* Add order to total revenue if order has been paid */
            if(orders.get(i).getFinancialStatus().equalsIgnoreCase("paid")){
                totalRevenueInUsd += Double.parseDouble(orders.get(i).getTotalPriceInUsDollars());
            }
            
        }
        return totalRevenueInUsd;
    }
}
