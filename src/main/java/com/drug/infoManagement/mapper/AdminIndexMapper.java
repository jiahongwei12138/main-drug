package com.drug.infoManagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.drug.entity.MainHeadquarters;
import com.drug.entity.MainModel;

public interface AdminIndexMapper {

	List<MainModel> queryByMenu();

	@Select("select * from main_headquarters where hqtId=1")
	MainHeadquarters queryHeadquarter();

	@Update("update main_model set modelName=#{title} where modelId=#{id}")
	void updateModelNameById(MainModel mainModel);

}
