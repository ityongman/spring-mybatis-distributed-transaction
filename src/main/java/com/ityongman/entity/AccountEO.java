package com.ityongman.entity;

import java.math.BigDecimal;

import javax.persistence.Table;

@Table(name="account")
public class AccountEO {
	private Long id ; // 账户表id主键
	
	private String name ;  // 账户名
	
	private BigDecimal balance ; // 账户余额
	
	private BigDecimal frezee ; // 冻结余额

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getFrezee() {
		return frezee;
	}

	public void setFrezee(BigDecimal frezee) {
		this.frezee = frezee;
	}
	
}
