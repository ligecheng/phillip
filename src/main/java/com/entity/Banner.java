package com.entity;

import java.io.Serializable;

public class Banner implements Serializable {
    private Integer ebId;

    private Integer ebEpId;

    private String ebFilePath;

    private static final long serialVersionUID = 1L;

    public Banner(Integer ebId, Integer ebEpId, String ebFilePath) {
        this.ebId = ebId;
        this.ebEpId = ebEpId;
        this.ebFilePath = ebFilePath;
    }

    public Banner() {
        super();
    }

    public Integer getEbId() {
        return ebId;
    }

    public void setEbId(Integer ebId) {
        this.ebId = ebId;
    }

    public Integer getEbEpId() {
        return ebEpId;
    }

    public void setEbEpId(Integer ebEpId) {
        this.ebEpId = ebEpId;
    }

    public String getEbFilePath() {
        return ebFilePath;
    }

    public void setEbFilePath(String ebFilePath) {
        this.ebFilePath = ebFilePath == null ? null : ebFilePath.trim();
    }
}