package com.drug.production.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.drug.entity.ReturnOf;

@Repository
public interface ReturnOfMapper {

	public List<ReturnOf> selectReturnOfAll(Map<String,Object> map);
	
	public int selectReturnOfCount();
	
	public void deleteReturnOfById(Integer returnOfId);
	
	public void checkReturnOfStatus(Integer returnOfId);
	
	
	
}
