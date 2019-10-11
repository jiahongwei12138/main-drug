package com.drug.infoManagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.drug.entity.MainHeadquarters;
import com.drug.entity.MainModel;

public interface AdminIndexMapper {

	List<MainModel> queryByMenu();

	@Select("select * from main_headquarters where hqtId=1")
	MainHeadquarters queryHeadquarter();

}
