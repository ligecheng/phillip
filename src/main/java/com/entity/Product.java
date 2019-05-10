package com.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer epId;

    private String epName;

    private Double epPrice;

    private Integer epStock;

    private Integer epcId;

    private Integer epParentId;

    private String epFilePath;

    private String epDesc;

    private static final long serialVersionUID = 1L;

    public Product(Integer epId, String epName, Double epPrice, Integer epStock, Integer epcId, Integer epParentId, String epFilePath, String epDesc) {
        this.epId = epId;
        this.epName = epName;
        this.epPrice = epPrice;
        this.epStock = epStock;
        this.epcId = epcId;
        this.epParentId = epParentId;
        this.epFilePath = epFilePath;
        this.epDesc = epDesc;
    }

    public Product() {
        super();
    }

    @Override
	public String toString() {
		return "Product [epId=" + epId + ", epName=" + epName + ", epPrice=" + epPrice + ", epStock=" + epStock
				+ ", epcId=" + epcId + ", epParentId=" + epParentId + ", epFilePath=" + epFilePath + ", epDesc="
				+ epDesc + "]";
	}

	public Integer getEpId() {
        return epId;
    }

    public void setEpId(Integer epId) {
        this.epId = epId;
    }

    public String getEpName() {
        return epName;
    }

    public void setEpName(String epName) {
        this.epName = epName == null ? null : epName.trim();
    }

    public Double getEpPrice() {
        return epPrice;
    }

    public void setEpPrice(Double epPrice) {
        this.epPrice = epPrice;
    }

    public Integer getEpStock() {
        return epStock;
    }

    public void setEpStock(Integer epStock) {
        this.epStock = epStock;
    }

    public Integer getEpcId() {
        return epcId;
    }

    public void setEpcId(Integer epcId) {
        this.epcId = epcId;
    }

    public Integer getEpParentId() {
        return epParentId;
    }

    public void setEpParentId(Integer epParentId) {
        this.epParentId = epParentId;
    }

    public String getEpFilePath() {
        return epFilePath;
    }

    public void setEpFilePath(String epFilePath) {
        this.epFilePath = epFilePath == null ? null : epFilePath.trim();
    }

    public String getEpDesc() {
        return epDesc;
    }

    public void setEpDesc(String epDesc) {
        this.epDesc = epDesc == null ? null : epDesc.trim();
    }
}