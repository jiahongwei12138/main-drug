package com.drug.infoManagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.MainModel;
import com.drug.infoManagement.service.AdminIndexService;

@Controller
public class ModelController {
	
	@Autowired
	private AdminIndexService adminIndexService;
	
	
	@RequestMapping("/updateModelNameById")
	@ResponseBody
	public boolean updateModelNameById(MainModel mainModel){
		try {
			adminIndexService.updateModelNameById(mainModel);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping("/queryModelTree")
	@ResponseBody
	public List<MainModel> queryModelTree(){
		List<MainModel> modelList=new ArrayList<MainModel>();
		
		List<MainModel> allModels=adminIndexService.queryByMenu();
		Map<Integer, MainModel> map=new HashMap<Integer, MainModel>();
		for (MainModel mainModel : allModels) {
			mainModel.setSpread(true);
			map.put(mainModel.getId(), mainModel);
		}
		for (MainModel mainModel : allModels) {
			if (mainModel.getParentModelId()==0) {
				modelList.add(mainModel);
			}else {
				MainModel parentModel = map.get(mainModel.getParentModelId());
				parentModel.getChildren().add(mainModel);
			}
		}
		return modelList;
	}
}
