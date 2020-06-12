
package com.ruth.spellinggame.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sound {

    @SerializedName("audio")
    @Expose
    private String audio;
    @SerializedName("ref")
    @Expose
    private String ref;
    @SerializedName("stat")
    @Expose
    private String stat;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Sound() {
    }

    /**
     * 
     * @param ref
     * @param stat
     * @param audio
     */
    public Sound(String audio, String ref, String stat) {
        super();
        this.audio = audio;
        this.ref = ref;
        this.stat = stat;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

}
