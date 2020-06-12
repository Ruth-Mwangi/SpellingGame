
package com.ruth.spellinggame.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Uro {

    @SerializedName("ure")
    @Expose
    private String ure;
    @SerializedName("fl")
    @Expose
    private String fl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Uro() {
    }

    /**
     * 
     * @param fl
     * @param ure
     */
    public Uro(String ure, String fl) {
        super();
        this.ure = ure;
        this.fl = fl;
    }

    public String getUre() {
        return ure;
    }

    public void setUre(String ure) {
        this.ure = ure;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

}
