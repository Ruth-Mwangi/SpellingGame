
package com.ruth.spellinggame.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hwi {

    @SerializedName("hw")
    @Expose
    private String hw;
    @SerializedName("prs")
    @Expose
    private List<Pr> prs = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Hwi() {
    }

    /**
     * 
     * @param prs
     * @param hw
     */
    public Hwi(String hw, List<Pr> prs) {
        super();
        this.hw = hw;
        this.prs = prs;
    }

    public String getHw() {
        return hw;
    }

    public void setHw(String hw) {
        this.hw = hw;
    }

    public List<Pr> getPrs() {
        return prs;
    }

    public void setPrs(List<Pr> prs) {
        this.prs = prs;
    }

}
