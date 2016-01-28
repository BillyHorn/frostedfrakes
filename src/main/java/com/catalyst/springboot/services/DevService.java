package com.catalyst.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.dao.DevDao;
import com.catalyst.springboot.entities.Dev;

@Service
public class DevService {
	
	@Autowired 
	DevDao devdao;

	/**
	 * @param devdao the devdao to set
	 */
	public void setDevdao(DevDao devdao) {
		this.devdao = devdao;
	}
	
	public List<Dev> get(){
		return devdao.get();
	}
	
	
}
