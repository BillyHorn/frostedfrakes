package com.catalyst.springboot.services;

import org.springframework.stereotype.Service;

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



	@Override
	public void add(Project project) {

		
		projectDao.add(project);
	}
	
}
