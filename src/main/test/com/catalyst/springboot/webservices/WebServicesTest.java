package com.catalyst.springboot.webservices;

import static org.mockito.Mockito.*;
import org.junit.Before;

import com.catalyst.springboot.services.DevService;
import com.catalyst.springboot.services.ProjectService;

public class WebServicesTest {
	
	private DevService devService;
	private ProjectService projectService;
	private WebServices webService;

	@Before
	public void setup(){
		devService = mock(DevService.class);
	}
}
