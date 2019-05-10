package com.entity;

import java.io.Serializable;
/**
 * 订单详情
 * @author his
 *
 */
public class OrderDetail implements Serializable {
    private Integer eodId;

    private Integer eodEoId;

    private Integer eodEpId;

    private Integer eodCount;

    private Double eodTotalPrice;
    
    private Product product;

    private static final long serialVersionUID = 1L;

    public OrderDetail(Integer eodId, Integer eodEoId, Integer eodEpId, Integer eodCount, Double eodTotalPrice) {
        this.eodId = eodId;
        this.eodEoId = eodEoId;
        this.eodEpId = eodEpId;
        this.eodCount = eodCount;
        this.eodTotalPrice = eodTotalPrice;
    }

    public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderDetail(Integer eodId, Integer eodEoId, Integer eodEpId, Integer eodCount, Double eodTotalPrice,
			Product product) {
		super();
		this.eodId = eodId;
		this.eodEoId = eodEoId;
		this.eodEpId = eodEpId;
		this.eodCount = eodCount;
		this.eodTotalPrice = eodTotalPrice;
		this.product = product;
	}

	public OrderDetail(Integer eodEpId, Integer eodCount, Double eodTotalPrice) {
		super();
		this.eodEpId = eodEpId;
		this.eodCount = eodCount;
		this.eodTotalPrice = eodTotalPrice;
	}

	public OrderDetail() {
        super();
    }

    public Integer getEodId() {
        return eodId;
    }

    public void setEodId(Integer eodId) {
        this.eodId = eodId;
    }

    public Integer getEodEoId() {
        return eodEoId;
    }

    public void setEodEoId(Integer eodEoId) {
        this.eodEoId = eodEoId;
    }

    public Integer getEodEpId() {
        return eodEpId;
    }

    public void setEodEpId(Integer eodEpId) {
        this.eodEpId = eodEpId;
    }

    public Integer getEodCount() {
        return eodCount;
    }

    public void setEodCount(Integer eodCount) {
        this.eodCount = eodCount;
    }

    public Double getEodTotalPrice() {
        return eodTotalPrice;
    }

    public void setEodTotalPrice(Double eodTotalPrice) {
        this.eodTotalPrice = eodTotalPrice;
    }
}