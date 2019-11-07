package com.drug.warehouse.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.entity.MainStorage;

/**
 * 业务层(仓库类型)
 * @author Administrator
 *
 */
@Repository
public interface MainStorageService {

	
	/**
	 * 查询所有仓库
	 * @return
	 */
	public List<MainStorage> AllMainStorage();
	
	/**
	 * 查询仓库的总行数
	 * @return
	 */
	public int countMainStorage();
	
	/**
	 * 根据id删除数据
	 * @param id
	 * @return
	 */
	public int delMainStorage(int id);
	
	/**
	 * 修改
	 * @param ms
	 * @return
	 */
	public int editMainStorage(MainStorage ms);
	
	/**
	 * 新增
	 * @param ms
	 * @return
	 */
	public int newStorage(MainStorage ms);
	
	/**
	 * 根据仓库类型查询数据
	 * @param storageType
	 * @return
	 */
	public List<MainStorage> vagueMainStorage(String storageType);
	
	/**
	 * 根据仓库类型查询出行数
	 * @param storageType
	 * @return
	 */
	public int countStorageType(String storageType);
	
}
