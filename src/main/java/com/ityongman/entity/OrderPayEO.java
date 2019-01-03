package com.ityongman.entity;

import java.math.BigDecimal;

import javax.persistence.Table;

@Table(name="orderpay")
public class OrderPayEO {
	private Long id ; // 订单支付表主键
	
	private Long orderId ; // 订单id
	
	private String payUser ; // 支付人
	
	private BigDecimal payAmount ; // 支付金额	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getPayUser() {
		return payUser;
	}

	public void setPayUser(String payUser) {
		this.payUser = payUser;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
	
}
