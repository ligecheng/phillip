package com.entity;

import java.io.Serializable;

public class ShoppingCart implements Serializable {
    private Integer esId;

    private String esEpFilePath;

    private Integer esEpCount;

    private Integer esEpId;

    private Integer esEuUserId;
    
    private Product product;

    private static final long serialVersionUID = 1L;

    public ShoppingCart(Integer esId, String esEpFilePath, Integer esEpCount, Integer esEpId, Integer esEuUserId) {
        this.esId = esId;
        this.esEpFilePath = esEpFilePath;
        this.esEpCount = esEpCount;
        this.esEpId = esEpId;
        this.esEuUserId = esEuUserId;
    }
    
    

    public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public ShoppingCart() {
        super();
    }

    public Integer getEsId() {
        return esId;
    }

    public void setEsId(Integer esId) {
        this.esId = esId;
    }

    public String getesEpFilePath() {
        return esEpFilePath;
    }

    public void setesEpFilePath(String esEpFilePath) {
        this.esEpFilePath = esEpFilePath == null ? null : esEpFilePath.trim();
    }

    public Integer getEsEpCount() {
        return esEpCount;
    }

    public void setEsEpCount(Integer esEpCount) {
        this.esEpCount = esEpCount;
    }

    public Integer getEsEpId() {
        return esEpId;
    }

    public void setEsEpId(Integer esEpId) {
        this.esEpId = esEpId;
    }

    public Integer getEsEuUserId() {
        return esEuUserId;
    }

    public void setEsEuUserId(Integer esEuUserId) {
        this.esEuUserId = esEuUserId;
    }
}