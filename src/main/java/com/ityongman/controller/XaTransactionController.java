package com.ityongman.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ityongman.service.impl.JtaServiceImpl;

@RestController
public class XaTransactionController {
	@Autowired
	private JtaServiceImpl jtaService ;
	
	@GetMapping("/jta")
	public Map<String,Object> jta() {
		LinkedHashMap<String,Object> resultMap=new LinkedHashMap<String,Object>();
        try {
            return jtaService.orderPay();
        }catch (Exception e){
            resultMap.put("state","fail");
            resultMap.put("message","分布式事务同步失败");
            return resultMap;
        }
	}
}
