package com.drug.infoManagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainHeadquarters;
import com.drug.entity.MainModel;
/**
 * 类描述：后台首页
 * @author jhw
 * @dateTime 2019年10月23日下午7:48:05
 * @version 1.0
 */
public interface AdminIndexMapper {
	/**
	   *方法功能：查询模块
	 * @return List<MainModel> 模块集合
	 */
	List<MainModel> queryByMenu();

	/**
	   *方法功能：查询总店信息
	 * @return MainHeadquarters 总店对象
	 */
	@Select("select * from main_headquarters where hqtId=1")
	MainHeadquarters queryHeadquarter();

	/**
	   *方法功能：根据模块id修改模块名称
	 * @param mainModel 模块对象
	 */
	@Update("update main_model set modelName=#{title} where modelId=#{id}")
	void updateModelNameById(MainModel mainModel);
	
	/**
	   *方法功能：修改总店人数
	 * @param countEmp 员工总人数
	 */
	@Update("update main_headquarters set empNumber=#{countEmp} where hqtId=1")
	void updateHeadquarterPersonNum(int countEmp);
	
	/**
	   *方法功能：登录
	 * @param mainEmployee 员工对象中的账号和密码
	 * @return MainEmployee 员工对象
	 */
	MainEmployee login(MainEmployee mainEmployee);

	/**
	   *方法功能：根据角色id查询角色所拥有的模块
	 * @param roleId 角色id
	 * @return List<MainModel> 模块集合
	 */
	List<MainModel> queryByMenuByRoleId(Integer roleId);

}
