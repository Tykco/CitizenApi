
package com.citizen.api.entities;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Name {

    private String salutation;
    private String givenName;
    private String surname;

    /**
     * 
     * @return
     *     The salutation
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * 
     * @param salutation
     *     The salutation
     */
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    /**
     * 
     * @return
     *     The givenName
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * 
     * @param givenName
     *     The givenName
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    /**
     * 
     * @return
     *     The surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * 
     * @param surname
     *     The surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

}
