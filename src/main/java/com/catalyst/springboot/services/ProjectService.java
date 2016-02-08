package com.catalyst.springboot.services;

import java.util.List;
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
	
	@Autowired
	private Converters convert;
	
	/**
	 * @param projectDao the projectDao to set
	 */
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	/**
	 * @param convert the convert to set
	 */
	public void setConvert(Converters convert) {
		this.convert = convert;
	}


	/**
	 * Adds a new project to the database.
	 * 
	 * @param project The project to be added
	 */
	public void add(Project project) {
		List<Dev> devsToConvert = project.getDevsToConvert();
		project.setUsers(convert.convertDevs(devsToConvert));
		projectDao.add(project);
	}
	
	/**
	 * Retrieves all projects from the database.
	 * 
	 * @return The List of all projects
	 */
	public List<Project> getByDev(Dev dev){
		return projectDao.getByDev(dev);
	}

	public List<Project> getTechLeadProjects(Dev dev) {
		// TODO Auto-generated method stub
		return projectDao.getTechLeadProjects(dev);
	}
	
	
	
	
	
}
