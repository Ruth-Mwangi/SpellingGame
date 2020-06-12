
package com.ruth.spellinggame.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WebsterSearchResponse {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("hwi")
    @Expose
    private Hwi hwi;
    @SerializedName("fl")
    @Expose
    private String fl;
//    @SerializedName("def")
//    @Expose
//    private List<Def> def = null;
    @SerializedName("uros")
    @Expose
    private List<Uro> uros = null;
    @SerializedName("et")
    @Expose
    private List<List<String>> et = null;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("shortdef")
    @Expose
    private List<String> shortdef = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public WebsterSearchResponse() {
    }

    /**
     * 
     * @param date
     * @param def
     * @param meta
     * @param fl
     * @param uros
     * @param hwi
     * @param shortdef
     * @param et
     */
    public WebsterSearchResponse(Meta meta, Hwi hwi, String fl, List<Uro> uros, List<List<String>> et, String date, List<String> shortdef) {
        super();
        this.meta = meta;
        this.hwi = hwi;
        this.fl = fl;
        this.uros = uros;
        this.et = et;
        this.date = date;
        this.shortdef = shortdef;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Hwi getHwi() {
        return hwi;
    }

    public void setHwi(Hwi hwi) {
        this.hwi = hwi;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

//    public List<Def> getDef() {
//        return def;
//    }
//
//    public void setDef(List<Def> def) {
//        this.def = def;
//    }

    public List<Uro> getUros() {
        return uros;
    }

    public void setUros(List<Uro> uros) {
        this.uros = uros;
    }

    public List<List<String>> getEt() {
        return et;
    }

    public void setEt(List<List<String>> et) {
        this.et = et;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getShortdef() {
        return shortdef;
    }

    public void setShortdef(List<String> shortdef) {
        this.shortdef = shortdef;
    }

}
