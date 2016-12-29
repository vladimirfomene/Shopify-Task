/*
 * Order.java
 * ==========================================
 * The states (instance variables) of this class represents the attributes
 * of our json file.
 * @author Vladimir Fomene
 */ 
package shopify.merchant.revenue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/* Get financial status and total price and ignore the other attributes */
public class Order {
    
    
    @SerializedName("total_price")
    @Expose(deserialize = true)
    private String totalPrice;
    
    
    @SerializedName("financial_status")
    @Expose(deserialize = true)
    private String financialStatus;
    
    
    @SerializedName("total_price_usd")
    @Expose(deserialize = true)
    private String totalPriceUsd;
    
    
    /**
     * Gets the total price of an order in Canadian dollar(CAD).
     * @return totalPrice of an order in CAD
     */
    public String getTotalPriceInCad(){
        return totalPrice;
    }
    
    
    /**
     * Gets the financial status of a particular order ('paid' or 'unpaid')
     * @return financialStatus of an order
     */
    public String getFinancialStatus(){
        return financialStatus;
    }
    
    
    /**
     * Gets the total price of an order in US dollars
     * @return total price of order in us dollars.
     */
    public String getTotalPriceInUsDollars(){
        return totalPriceUsd;
    }
}
