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
/**
 * 类描述：模块（菜单）管理
 * @author jhw
 * @dateTime 2019年10月23日下午8:29:55
 * @version 1.0
 */
@Controller
public class ModelController {
	
	@Autowired
	private AdminIndexService adminIndexService;
	
	/**
	   *方法功能：根据模块id修改模块名称
	 * @param mainModel 模块对象
	 * @return boolean 修改结果 true：修改成功  false：修改失败
	 */
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
	/**
	   *方法功能：查询模块树
	 * @return List<MainModel> 模块集合
	 */
	@RequestMapping("/queryModelTree")
	@ResponseBody
	public List<MainModel> queryModelTree(){
		//创建空的模块集合
		List<MainModel> modelList=new ArrayList<MainModel>();
		//查询所有模块，返回模块集合
		List<MainModel> allModels=adminIndexService.queryByMenu();
		//创建map集合
		Map<Integer, MainModel> map=new HashMap<Integer, MainModel>();
		//遍历查询出的模块集合
		for (MainModel mainModel : allModels) {
			//设置模块树为展开状态
			mainModel.setSpread(true);
			//将遍历出的模块对象放入map集合，以主键为键，模块对象为值
			map.put(mainModel.getId(), mainModel);
		}
		//再次遍历查询出的模块集合，以当前遍历出的模块对象作为子节点来判断
		for (MainModel mainModel : allModels) {
			//判断当前遍历出的模块对象的父id是否为0
			if (mainModel.getParentModelId()==0) {
				//为0则是根节点，将其添加到空的模块集合
				modelList.add(mainModel);
			}else {
				//获取当前遍历出的模块对象的父id，从map集合中寻找当前模块的父模块，返回父模块对象
				MainModel parentModel = map.get(mainModel.getParentModelId());
				//获取返回的父模块对象中的子模块集合属性，将当前遍历出的模块对象添加到返回的父模块对象中的子模块集合中
				parentModel.getChildren().add(mainModel);
			}
		}
		return modelList;
	}
}
