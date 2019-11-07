package com.drug.production.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.ReturnOf;
import com.drug.production.mapper.ReturnOfMapper;
import com.drug.production.service.ReturnOfService;
@Service
public class ReturnOfServiceImpl implements ReturnOfService{

	@Autowired
	private ReturnOfMapper returnOfMapper;
	
	@Override
	public List<ReturnOf> selectReturnOfAll(Map<String,Object> map) {
		List<ReturnOf> list=returnOfMapper.selectReturnOfAll(map);
		return list;
	}

	@Override
	public void deleteReturnOfById(Integer returnOfId) {
		returnOfMapper.deleteReturnOfById(returnOfId);
	}

	@Override
	public void checkReturnOfStatus(Integer returnOfId) {
		returnOfMapper.checkReturnOfStatus(returnOfId);
	}

	@Override
	public int selectReturnOfCount() {
		int count =returnOfMapper.selectReturnOfCount();
		return count;
	}

	
	
}
