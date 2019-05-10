package com.entity;

import java.io.Serializable;

public class ProductCategories implements Serializable {
    private Integer epcId;

    private String epcName;

    private Integer epcParentId;

    private static final long serialVersionUID = 1L;

    public ProductCategories(Integer epcId, String epcName, Integer epcParentId) {
        this.epcId = epcId;
        this.epcName = epcName;
        this.epcParentId = epcParentId;
    }

    public ProductCategories() {
        super();
    }

    public Integer getEpcId() {
        return epcId;
    }

    public void setEpcId(Integer epcId) {
        this.epcId = epcId;
    }

    public String getEpcName() {
        return epcName;
    }

    public void setEpcName(String epcName) {
        this.epcName = epcName == null ? null : epcName.trim();
    }

    public Integer getEpcParentId() {
        return epcParentId;
    }

    public void setEpcParentId(Integer epcParentId) {
        this.epcParentId = epcParentId;
    }

	@Override
	public String toString() {
		return "ProductCategories [epcId=" + epcId + ", epcName=" + epcName + ", epcParentId=" + epcParentId + "]";
	}
    
}