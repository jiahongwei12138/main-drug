package com.drug.infoManagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.MainDepartment;
import com.drug.entity.MainModel;
import com.drug.entity.MainRole;
import com.drug.infoManagement.service.AdminIndexService;
import com.drug.infoManagement.service.DeptService;
import com.drug.infoManagement.service.RoleService;
import com.drug.util.ToolClass;
/**
   * 类描述：角色管理
 * @author jhw
 * @dateTime 2019年10月23日下午8:40:14
 * @version 1.0
 */
@Controller
public class RoleController {

	@Autowired
	private DeptService deptService;
	
	@Autowired
	private AdminIndexService adminIndexService;
	
	@Autowired
	private RoleService roleService;
	/**
	   *方法功能：查新部门集合
	 * @return Map<String,Object> 部门集合
	 */
	@RequestMapping("/queryDeptGiveOption")
	@ResponseBody
	public Map<String, Object> queryDeptGiveOption(){
		List<MainDepartment> depts=deptService.queryDeptGiveOption();
		Map<String, Object> map = ToolClass.responseByData(depts, 0);
		return map;
	}
	/**
	   *方法功能：添加角色
	 * @param role 角色对象
	 * @return String 添加结果
	 */
	@RequestMapping("/addRole")
	@ResponseBody
	public String addRole(MainRole role){
		String result=roleService.addRole(role);
		return result;
	}
	/**
	   *方法功能：分页查询角色
	 * @param page 页码
	 * @param limit 每页显示数
	 * @return Map<String,Object> 角色集合
	 */
	@RequestMapping("/queryAllRole")
	@ResponseBody
	public Map<String, Object> queryAllRole(Integer page,Integer limit){
		//分页查询角色
		List<MainRole> roles=roleService.queryAllRole(page,limit);
		//统计角色数量
		int count=roleService.getCountRole();
		Map<String, Object> map = ToolClass.responseByData(roles, count);
		return map;
	}
	/**
	   *方法功能：根据角色id删除角色
	 * @param roleId 角色id
	 * @return boolean 删除结果 true:删除成功  false：删除失败
	 */
	@RequestMapping("/deletRoleById")
	@ResponseBody
	public boolean deletRoleById(String roleId){
		try {
			roleService.deletRoleById(roleId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	   *方法功能：根据角色id修改角色
	 * @param mainRole 角色对象
	 * @return boolean 修改结果 true:修改成功  false：修改失败
	 */
	@RequestMapping("/updateRoleById")
	@ResponseBody
	public boolean updateRoleById(MainRole mainRole){
		try {
			roleService.updateRoleById(mainRole);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	   *方法功能：查询模块
	 * @param roleId 角色id
	 * @return List<MainModel> 模块集合
	 */
	@RequestMapping("/queryAllModel")
	@ResponseBody
	public List<MainModel> queryAllModel(Integer roleId){
		//创建空的模块集合
		List<MainModel> modelList=new ArrayList<MainModel>();
		//查询所有模块，返回模块集合
		List<MainModel> allModels=adminIndexService.queryByMenu();
		//根据角色id查询模块id，返回模块id集合
		List<Integer> modelIdList=roleService.queryModelIdByRoleId(roleId);
		//创建map集合
		Map<Integer, MainModel> map=new HashMap<Integer, MainModel>();
		//遍历返回的模块集合
		for (MainModel mainModel : allModels) {
			/*
			 * layui节点的特性：子节点被选中，那么父节点也会被选项。
			   *    如果父节点被选中那么该父节点下的所有子节点都将被选中。
			   *     所以这里判断modelIdList集合中是否包含遍历出的所有模块id，包含则设置模块的checked值都设置为true,否则为false  
			   *    注意在下面需要判断将modelIdList集合中包含的父模块（父节点）的checked值都设置为false  
			 */
			if (modelIdList.contains(mainModel.getId())) {
				//如果模块id集合中包含遍历出的模块对象中的id，则设置模块复选框状态为被选中的
				mainModel.setChecked(true);
			}else {
				//如果模块id集合中不包含遍历出的模块对象中的id，则设置模块复选框状态为不被选中的
				mainModel.setChecked(false);
			}
			//判断遍历出的模块对象的父id是否为0，为0则为根节点，设置为展开状态
			if (mainModel.getParentModelId()==0) {
				mainModel.setSpread(true);
			}
			//将遍历出的模块对象放入map集合，以模块的主键id为键，对象为值
			map.put(mainModel.getId(), mainModel);
		}
		//再次遍历返回的模块集合
		for (MainModel m : allModels) {
			//以当前遍历出的模块对象作为子节点
			MainModel childModel=m;
			//如果当前模块的父id为0则为根节点，将其添加到空的模块集合中
			if (childModel.getParentModelId()==0) {
				modelList.add(childModel);
			}else {
				//否则获取当前模块的父模块id从模块中去寻找当前模块的父模块，返回父模块对象
				MainModel parentModel=map.get(childModel.getParentModelId());
				/*
				 * layui节点的特性：子节点被选中，那么父节点也会被选项。
				   *    如果父节点被选中那么该父节点下的所有子节点都将被选中。
				   *     所以这里判断将modelIdList集合中包含的父模块（父节点）的checked值都设置为false  
				 */
				//判断模块id集合中是否包含返回的父模块id
				if (modelIdList.contains(parentModel.getId())) {
					//如果包含，则设置复选框状态为不被选中的
					parentModel.setChecked(false);
				}
				//将当前模块添加到返回的父模块对象属性的子集合属性
				parentModel.getChildren().add(childModel);
			}
		}
		return modelList;
	}
	/**
	   *方法功能：分配权限
	 * @param roleId 角色id
 	 * @param modelIds 模块id数组
	 * @return boolean 修改结果  true：修改成功  false：修改失败
	 */
	@RequestMapping("/assignAuthority")
	@ResponseBody
	public boolean assignAuthority(String roleId,Integer[] modelIds){
		try {
			roleService.assignAuthority(roleId,modelIds);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
