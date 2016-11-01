package com.citizen.api.entities;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Catalogue {

    private List<ProductCat> products = new ArrayList<ProductCat>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The products
     */
    public List<ProductCat> getProducts() {
        return products;
    }

    /**
     * 
     * @param products
     *     The products
     */
    public void setProducts(List<ProductCat> products) {
        this.products = products;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
