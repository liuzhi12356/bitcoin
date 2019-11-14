package com.lz.bitcoinexplorer1113.vo;

import java.io.Serializable;

public class SerObject implements Serializable {
    private String besthash;
    private String lasthash;

    public String getBesthash() {
        return besthash;
    }

    public void setBesthash(String besthash) {
        this.besthash = besthash;
    }

    public String getLasthash() {
        return lasthash;
    }

    public void setLasthash(String lasthash) {
        this.lasthash = lasthash;
    }
}
