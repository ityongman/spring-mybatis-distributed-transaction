package com.ityongman.service.center.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ityongman.entity.OrderPayEO;

@Service
public class OrderPayService extends BaseServiceImpl<OrderPayEO>{
	
	public Map<String, Object> saveOrUpdateOrderPay(OrderPayEO orderPay) {
		saveNotNull(orderPay);
		
		LinkedHashMap<String,Object> resultMap=new LinkedHashMap<String,Object>();
		resultMap.put("state", "success");
		resultMap.put("message", "保存订单信息成功");
		
		return resultMap;
	}
}
