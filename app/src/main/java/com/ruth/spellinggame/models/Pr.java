
package com.ruth.spellinggame.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pr {

    @SerializedName("mw")
    @Expose
    private String mw;
    @SerializedName("sound")
    @Expose
    private Sound sound;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pr() {
    }

    /**
     * 
     * @param sound
     * @param mw
     */
    public Pr(String mw, Sound sound) {
        super();
        this.mw = mw;
        this.sound = sound;
    }

    public String getMw() {
        return mw;
    }

    public void setMw(String mw) {
        this.mw = mw;
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

}
