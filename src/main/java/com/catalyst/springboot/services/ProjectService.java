package com.catalyst.springboot.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.dao.ProjectDao;
import com.catalyst.springboot.entities.Dev;
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
		List<Dev> devsToConvert = project.getDevsToConvert();
		project.setUsers(convertDevs(devsToConvert));
		projectDao.add(project);
	}
	
	public List<Project> get(){
		return projectDao.get();
	}
	
	public Set<Dev> convertDevs(List<Dev> devsToConvert){
		Set<Dev> devs = new HashSet<Dev>();
		for (Dev dev : devsToConvert){
			devs.add(dev);
		}
		return devs;
	}
	
}
