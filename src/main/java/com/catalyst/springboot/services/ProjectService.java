package com.catalyst.springboot.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.dao.ProjectDao;
import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.entities.Project;

/**
 * Holds services relevant to projects.
 * @author kmatthiesen
 *
 */
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


	/**
	 * Adds a new project to the database.
	 * 
	 * @param project The project to be added
	 */
	public void add(Project project) {
		List<Dev> devsToConvert = project.getDevsToConvert();
		project.setUsers(convertDevs(devsToConvert));
		projectDao.add(project);
	}
	
	/**
	 * Retrieves all projects from the database.
	 * 
	 * @return The List of all projects
	 */
	public List<Project> get(){
		return projectDao.get();
	}
	
	/**
	 * Converts the list of devs assigned to a project to a hashset.
	 * 
	 * @param devsToConvert The list of devs to convert
	 * @return The hashset of devs
	 */
	public Set<Dev> convertDevs(List<Dev> devsToConvert){
		Set<Dev> devs = new HashSet<Dev>();
		for (Dev dev : devsToConvert){
			devs.add(dev);
		}
		return devs;
	}
	
}
