package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private Integer eoId;

    private Integer eoUserId;

    private Date eoCreatrTime;

    private Integer eoStatus;

    private Double eoTotal;
    
    private List<OrderDetail> orderDetailList; 

    private static final long serialVersionUID = 1L;
    
    


	public Order(Integer eoId, Integer eoUserId, Date eoCreatrTime, Integer eoStatus, Double eoTotal,
			List<OrderDetail> orderDetailList) {
		super();
		this.eoId = eoId;
		this.eoUserId = eoUserId;
		this.eoCreatrTime = eoCreatrTime;
		this.eoStatus = eoStatus;
		this.eoTotal = eoTotal;
		this.orderDetailList = orderDetailList;
	}



	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}



	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}



	public Order(Integer eoId, Integer eoUserId, Date eoCreatrTime, Integer eoStatus, Double eoTotal) {
		super();
		this.eoId = eoId;
		this.eoUserId = eoUserId;
		this.eoCreatrTime = eoCreatrTime;
		this.eoStatus = eoStatus;
		this.eoTotal = eoTotal;
	}
    


	public Order(Integer eoUserId, Date eoCreatrTime, Integer eoStatus, Double eoTotal) {
		super();
		this.eoUserId = eoUserId;
		this.eoCreatrTime = eoCreatrTime;
		this.eoStatus = eoStatus;
		this.eoTotal = eoTotal;
	}

	

    public Order(Integer eoId, Integer eoStatus) {
		super();
		this.eoId = eoId;
		this.eoStatus = eoStatus;
	}



	public Order() {
        super();
    }

    public Integer getEoId() {
        return eoId;
    }

    public void setEoId(Integer eoId) {
        this.eoId = eoId;
    }

    public Integer getEoUserId() {
        return eoUserId;
    }

    public void setEoUserId(Integer eoUserId) {
        this.eoUserId = eoUserId;
    }

    public Date getEoCreatrTime() {
        return eoCreatrTime;
    }

    public void setEoCreatrTime(Date eoCreatrTime) {
        this.eoCreatrTime = eoCreatrTime;
    }

 

    public Integer getEoStatus() {
        return eoStatus;
    }

    public void setEoStatus(Integer eoStatus) {
        this.eoStatus = eoStatus;
    }

    public Double getEoTotal() {
        return eoTotal;
    }

    public void setEoTotal(Double eoTotal) {
        this.eoTotal = eoTotal;
    }



	@Override
	public String toString() {
		return "Order [eoId=" + eoId + ", eoUserId=" + eoUserId + ", eoCreatrTime=" + eoCreatrTime + ", eoStatus="
				+ eoStatus + ", eoTotal=" + eoTotal + "]";
	}
                                          

	
    
}