package com.ityongman.service.impl;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ityongman.entity.AccountEO;
import com.ityongman.entity.OrderPayEO;
import com.ityongman.service.IJtaService;
import com.ityongman.service.center.impl.AccountService;
import com.ityongman.service.center.impl.OrderPayService;

@Service("jtaService")
public class JtaServiceImpl implements IJtaService {
	
	@Autowired
	private AccountService accountService ;
	
	@Autowired
	private OrderPayService orderPayService ;
	
	@SuppressWarnings("unused")
	@Override
	@Transactional(transactionManager="xaTransactionManager", propagation=Propagation.REQUIRED, rollbackFor={RuntimeException.class})
	public Map<String, Object> orderPay() {
		//1. 处理账户信息
		AccountEO accountEO = new AccountEO();
		
		accountEO.setId(1L);
		accountEO.setBalance(BigDecimal.valueOf(500));
		accountEO.setFrezee(BigDecimal.valueOf(100));
		accountEO.setName("Jhon");
		
		Map<String, Object> saveOrUpdateAccount = accountService.saveOrUpdateAccount(accountEO);
		System.out.println(saveOrUpdateAccount);
		//2. 处理订单信息
		OrderPayEO orderPayEO = new OrderPayEO() ; 
		
		orderPayEO.setId(1L);
		orderPayEO.setOrderId(1234567890L);
		orderPayEO.setPayAmount(BigDecimal.valueOf(100));
		orderPayEO.setPayUser("Jhon");
		
		Map<String, Object> saveOrUpdateOrderPay = orderPayService.saveOrUpdateOrderPay(orderPayEO);
		System.out.println(saveOrUpdateOrderPay);
		
	   int i  = 1 / 0 ;
		
		LinkedHashMap<String,Object> resultMap=new LinkedHashMap<String,Object>();
		resultMap.put("state","success");
        resultMap.put("message","分布式事务同步成功");
        
		return resultMap;
	}

}
