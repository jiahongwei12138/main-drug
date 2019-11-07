package com.drug.production.service;

import java.util.List;
import java.util.Map;

import com.drug.entity.ReturnOf;

public interface ReturnOfService {
	
	public List<ReturnOf> selectReturnOfAll(Map<String,Object> map);
	
	public int selectReturnOfCount();
	
	public void deleteReturnOfById(Integer returnOfId);
	
	public void checkReturnOfStatus(Integer returnOfId);
	
	
	
}
