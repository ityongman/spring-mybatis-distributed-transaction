package com.ityongman.service.center.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ityongman.entity.AccountEO;

@Service
public class AccountService extends BaseServiceImpl<AccountEO>{
	
	public Map<String, Object> saveOrUpdateAccount(AccountEO accountEO) {
		saveNotNull(accountEO);
		
		LinkedHashMap<String,Object> resultMap=new LinkedHashMap<String,Object>();
		resultMap.put("state", "success");
		resultMap.put("message", "保存账户信息成功");
		
		return resultMap;
	}
}
