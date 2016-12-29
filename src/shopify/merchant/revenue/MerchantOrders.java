/*
 * File: MerchantOrders.java
 * ===================================================================
 * This class is representative of our list of orders in our json file.
 * It also implements a getter which returns a list of order object which can 
 * be used in the context of our java code.
 * @author Vladimir Fomene
 */
package shopify.merchant.revenue;


import java.util.List;

public class MerchantOrders {
    /* list of merchant's orders */
    private List<Order> orders;
    
    /**
     * Get list of orders in the merchant's store
     * @return orders made by clients on the store.
     */
    public List<Order> getListOfOrders(){
        return orders;
    }
}
