
package com.ruth.spellinggame.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Def {

    @SerializedName("sseq")
    @Expose
    private List<List<List<String>>> sseq = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Def() {
    }

    /**
     * 
     * @param sseq
     */
    public Def(List<List<List<String>>> sseq) {
        super();
        this.sseq = sseq;
    }

    public List<List<List<String>>> getSseq() {
        return sseq;
    }

    public void setSseq(List<List<List<String>>> sseq) {
        this.sseq = sseq;
    }

}
