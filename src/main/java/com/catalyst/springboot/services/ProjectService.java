package com.catalyst.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.dao.ProjectDao;
import com.catalyst.springboot.entities.Project;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectDao projectDao;
	
	/**
	 * @param projectDao the projectDao to set
	 */
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}



	public void add(Project project) {
		projectDao.add(project);
	}
	
	public List<Project> get(){
		return projectDao.get();
	}
	
}
