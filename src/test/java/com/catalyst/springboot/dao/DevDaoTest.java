package com.catalyst.springboot.dao;


import static org.mockito.Mockito.*;
import javax.persistence.EntityManager;
import org.junit.Before;
import com.catalyst.springboot.entities.Dev;

public class DevDaoTest {

	
	private DevDao dao;
	private EntityManager mockEm;
	private Dev dev;

	@Before
	public void setup() {
		dao = new DevDao();
		mockEm = mock(EntityManager.class);
		dao.setEm(mockEm);
		dev = mock(Dev.class);
	}
	
	
	
	/*@Test
	public void getAllDevsTest(){
		TypedQuery<Dev> query = mock(TypedQuery.class);
		List<Dev> devsToConvert = new ArrayList<Dev>();
		devsToConvert = Arrays.asList(dev);
		Iterator iterator = mock(Iterator.class);
		
		
		
		when(mockEm.createQuery(anyString(), eq(Dev.class))).thenReturn(query);
		when(query.getResultList()).thenReturn(devsToConvert);
		when(iterator.hasNext()).thenReturn(true, false);
		
		dao.get();
		verify(iterator).hasNext();
	}*/
}
