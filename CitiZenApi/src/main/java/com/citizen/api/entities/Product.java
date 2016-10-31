
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Product {

    private ReadyCreditProduct readyCreditProduct;
    private UnsecuredLoanProduct unsecuredLoanProduct;
    private CreditCardProduct creditCardProduct;

    /**
     * 
     * @return
     *     The readyCreditProduct
     */
    public ReadyCreditProduct getReadyCreditProduct() {
        return readyCreditProduct;
    }

    /**
     * 
     * @param readyCreditProduct
     *     The readyCreditProduct
     */
    public void setReadyCreditProduct(ReadyCreditProduct readyCreditProduct) {
        this.readyCreditProduct = readyCreditProduct;
    }

    /**
     * 
     * @return
     *     The unsecuredLoanProduct
     */
    public UnsecuredLoanProduct getUnsecuredLoanProduct() {
        return unsecuredLoanProduct;
    }

    /**
     * 
     * @param unsecuredLoanProduct
     *     The unsecuredLoanProduct
     */
    public void setUnsecuredLoanProduct(UnsecuredLoanProduct unsecuredLoanProduct) {
        this.unsecuredLoanProduct = unsecuredLoanProduct;
    }

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
