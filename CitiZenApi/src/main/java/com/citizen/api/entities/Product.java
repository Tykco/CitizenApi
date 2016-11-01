
package com.citizen.api.entities;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Product {

    private CreditCardProduct creditCardProduct;

    /**
     * 
     * @return
     *     The creditCardProduct
     */
    public CreditCardProduct getCreditCardProduct() {
        return creditCardProduct;
    }

    /**
     * 
     * @param creditCardProduct
     *     The creditCardProduct
     */
    public void setCreditCardProduct(CreditCardProduct creditCardProduct) {
        this.creditCardProduct = creditCardProduct;
    }

}
