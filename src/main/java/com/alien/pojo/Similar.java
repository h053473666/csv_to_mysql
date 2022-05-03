package com.alien.pojo;

import com.alien.utils.CsvRow;

public class Similar implements CsvRow {
    private String itemId;
    private String similar;

    public Similar() {
    }

    public Similar(String itemId, String similar) {
        this.itemId = itemId;
        this.similar = similar;
    }

    @Override
    public void setFromRow(String[] row) {
        this.itemId = row[0];
        this.similar = row[1];
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getSimilar() {
        return similar;
    }

    public void setSimilar(String similar) {
        this.similar = similar;
    }
}
