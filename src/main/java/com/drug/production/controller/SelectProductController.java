package com.drug.production.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.entity.AddPlan;
import com.drug.entity.AddPlans;
import com.drug.entity.MProductionPlan;
import com.drug.entity.MainEmployee;
import com.drug.entity.MainProduct;
import com.drug.production.service.SelectProductService;
import com.drug.util.ToolClass;

@RestController
public class SelectProductController {

	@Autowired
	private SelectProductService selectProductService;
	
	@Autowired
	private AddPlan addPlan;

	/**
	 * 	功能描述:查询成品信息
	 * @return
	 */
	@RequestMapping("selectProduct")
	public Map<String,Object> selectProduct(){ 
		List<MainProduct> list=selectProductService.selectProduct();
		Map<String,Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}

	/**
	 * 	功能描述: 添加月计划详情订单(成品信息)
	 * @param proId
	 * @param proName
	 * @param number
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("addProductYzz")
	public Map<String,Object> addProduct(String proId,String proName,String number) throws IOException{
		selectProductService.addMPlan(proId,proName,number);
		List<AddPlan> list= selectProductService.selectMplanDetails();
		Map<String,Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}
	
	/**
	 * 	功能描述:删除月计划详情订单的单个成品
	 * @return
	 */
	@RequestMapping("deleteProduct")
	public int deleteProduct(Integer mpdId) {
		int row=selectProductService.deleteProduct(mpdId);
		return row;
	}
	
	/**
	 * 	功能描述:查询员工信息
	 * @return
	 */
	@RequestMapping("selectEmployee")
	public Map<String,Object> selectEmployee(){
		List<MainEmployee> list=selectProductService.selectEmployee();
		Map<String,Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData; 
	}

	/**
	 * 	功能描述:添加生产月计划表
	 * @return
	 */
	@RequestMapping("addMplans") 
	public int addMplans(AddPlans addPlans) {
		int quantity=selectProductService.selectQuantity();
		addPlans.setMPlanNumber(quantity);
		int mPlanId=selectProductService.addMplans(addPlans);
		selectProductService.updateMplanDetails(mPlanId);
		return mPlanId; 
	}
	
	/**
	 * 	功能描述:点击第一个取消删除刚刚添加的数据
	 * @return
	 */
	@RequestMapping("deleteCancel")
	public int deleteCancel() {
		int row=selectProductService.deleteCancel();
		return row;
	}
	
	/**
	 * 功能描述:制定日计划
	 *
	 */
	@RequestMapping("deleteCancelD")
	public void deleteCancelD() {
		//月计划详情表预留的日计划生产数量清零
		selectProductService.updateDquantityReset();
		//取消制定日计划后删除表中的新增
		selectProductService.deleteCancelMplanDetails();
	}
	
	/**
	 * 	功能描述:查询月计划详情表
	 * @return
	 */
	@RequestMapping("selectCancel")
	public Map<String,Object> selectCancel() {
		List<AddPlan> list=selectProductService.selectMplanDetails();
		if(list.size()>0) {
			Map<String,Object> tableData=ToolClass.responseByData(list,list.size());
			return tableData; 
		}else {
			return null;
		}
	}
	
	/**
	 * 	功能描述:根据id查看月计划详情
	 *
	 */
	@RequestMapping("queryMplanDetails")
	public Map<String,Object> queryMplanDetails(Integer mplanId) {
		List<AddPlan> list=selectProductService.queryMplanDetails(mplanId);
		Map<String,Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}
	
	/**
	 * 	功能描述:删除月计划表(修改显示状态)
	 * @return
	 */
	@RequestMapping("deleteMplan")
	public int deleteMplan(Integer mplanId) {
		int row=selectProductService.deleteMplan(mplanId);
		return row;
	}
	
	/**
	 * 	功能描述:编辑月计划表(编辑详情)
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("updateMPlan")
	public void updateMPlan(String proId,String proName,String number,Integer mplanId) throws IOException {
		if(mplanId==null) {
			selectProductService.addMPlan(proId,proName,number);
		}else {
			//确认后修改(月计划修改中新增的数据)
			selectProductService.updateEditAffirm(mplanId);
			//确认后修改(月计划修改中删除的数据)
			selectProductService.updateDelAffirm();
			//查询修改后的月计划成品总数量
			AddPlan addPlan=selectProductService.selectEditAffirmNum(mplanId);
			addPlan.setMplanId(mplanId);
			//修改日计划单中的计划总数
			selectProductService.updateMplanNumber(addPlan);
		}
	}
	
	/**
	 * 功能描述:修改取消后恢复原来的数据
	 *
	 */
	@RequestMapping("delectRestoreMPlan")
	public void delectRestoreMPlan(Integer mplanId) {
		selectProductService.delectRestoreMPlan();
		//恢复修改前删除的数据
		selectProductService.updateEditProduct(mplanId);
	}
	
	/**
	 * 功能描述:修改月计划中的删除(修改月计划详情表中的外键id为2)
	 * @param mpdId
	 */
	@RequestMapping("deleteEditProduct")
	public void deleteEditProduct(Integer mpdId) {
		selectProductService.deleteEditProduct(mpdId);
	}
	
	/**
	 * 	功能描述:生产月计划审核
	 * @return
	 */
	@RequestMapping("updateAudit")
	public int updateAudit(MProductionPlan mProductionPlan,Integer mplanId,String proName) {
		mProductionPlan.setMAuditorName(proName);
		mProductionPlan.setMPlanId(mplanId);
		int row=selectProductService.updateAudit(mProductionPlan);
		return row;
	}
	
	/**
	 * 	功能描述:判断设定的日计划完成个数和月计划完成数之间的合理性
	 * @return
	 */
	@RequestMapping("selectJudgeDayProNum")
	public void selectJudgeDayProNum(Integer mplanId,Integer proId,Integer mpdId,Integer ed,Integer number,Integer mdetailsSurplus) {
		addPlan.setProId(proId);
		addPlan.setMpdId(mpdId);
		addPlan.setDPlanQuantity(ed);
		addPlan.setNumber(ed);
		//修改月计划详情表里面为日计划预留的计划生产数
		selectProductService.updatedQuantity(addPlan);
		//新增之前查询一次如果商品之前添加过则只修改数量
		List<AddPlan> list=selectProductService.selectdPlanDetailsProId();
		if(list.size()<1) {
			selectProductService.addDplanDetails(addPlan);
		}else {
			boolean found = false;
			for(AddPlan a:list) {
				if(a.getProId()==proId) {
					found = true;
					break;
				}
			}
			if (found) {
				//修改日生产详情表计划数量
				System.err.println(addPlan.getNumber());
				selectProductService.updatedPlanQuantity(addPlan);
				
			} else {
				//新增日计划详情(日计划表id暂时设为1,确定后再修改)
				selectProductService.addDplanDetails(addPlan);
			}
		}
	}
	
	/**
	 * 功能描述:查询制定日计划界面参数
	 *
	 */
	@RequestMapping("selectAddDplanDetails")
	public Map<String,Object> selectAddDplanDetails(Integer mplanId) {
		List<AddPlan> list=selectProductService.selectDplanDetails(mplanId);
		Map<String,Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}
	
	/**
	 * 功能描述:插入日计划表
	 * @param addPlans
	 */
	@RequestMapping("adddPlan")
	public void adddPlan(AddPlans addPlans,Integer mplanId) {
		//查询月计划详情表中的剩余数量
		List<AddPlan> list=selectProductService.selectmDetailsSurplus(mplanId);
		for(AddPlan a :list) {
			int num=a.getMDetailsSurplus()-a.getNumber();
			addPlan.setMpdId(a.getMpdId());
			addPlan.setNumber(num);
			//修改月计划详情表中的剩余数量
			selectProductService.updatemDetailsSurplus(addPlan);
		}
		addPlans.setMPlanId(mplanId);
		int dPlanId=selectProductService.addDplan(addPlans);
		selectProductService.updateDetDPlanId(dPlanId);
		//月计划详情表预留的日计划生产数量清零
		selectProductService.updateDquantityReset();
		
	}
}
