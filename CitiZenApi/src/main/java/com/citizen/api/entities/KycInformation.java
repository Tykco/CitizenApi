
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class KycInformation {

    private String usTaxStatus;
    private String usTaxId;

    /**
     * 
     * @return
     *     The usTaxStatus
     */
    public String getUsTaxStatus() {
        return usTaxStatus;
    }

    /**
     * 
     * @param usTaxStatus
     *     The usTaxStatus
     */
    public void setUsTaxStatus(String usTaxStatus) {
        this.usTaxStatus = usTaxStatus;
    }

    /**
     * 
     * @return
     *     The usTaxId
     */
    public String getUsTaxId() {
        return usTaxId;
    }

    /**
     * 
     * @param usTaxId
     *     The usTaxId
     */
    public void setUsTaxId(String usTaxId) {
        this.usTaxId = usTaxId;
    }

}
