package com.drug.warehouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainStorage;
import com.drug.warehouse.mapper.MainStorageMapper;
import com.drug.warehouse.service.MainStorageService;

/**
 * 业务层(仓库类型实现类)
 * @author Administrator
 *
 */
@Service
public class MainStorageServiceImpl implements MainStorageService {
	
	@Autowired
	private MainStorageMapper dao;

	@Override
	public List<MainStorage> AllMainStorage() {
		return dao.AllMainStorage();
	}

	@Override
	public int countMainStorage() {
		return dao.countMainStorage();
	}

	@Override
	public int delMainStorage(int id) {
		return dao.delMainStorage(id);
	}

	@Override
	public int editMainStorage(MainStorage ms) {
		return dao.editMainStorage(ms);
	}

	@Override
	public int newStorage(MainStorage ms) {
		return dao.newStorage(ms);
	}

	@Override
	public List<MainStorage> vagueMainStorage(String storageType) {
		return dao.vagueMainStorage(storageType);
	}

	@Override
	public int countStorageType(String storageType) {
		return dao.countStorageType(storageType);
	}

}
