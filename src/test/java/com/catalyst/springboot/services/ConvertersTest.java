package com.catalyst.springboot.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.springboot.entities.Dev;

import javassist.bytecode.Descriptor.Iterator;

public class ConvertersTest {
	
	private Converters convert;
	private Dev dev;
	
	@Before
	public void setup(){
		convert = new Converters();
		dev = mock(Dev.class);
	}

	@Test
	public void ConvertDevsTest(){
		Set<Dev> devs = mock(Set.class);
		List<Dev> devsToConvert = mock(List.class);
		devsToConvert = Arrays.asList(dev);
		Iterator iterator = mock(Iterator.class);
		
		when(iterator.hasNext()).thenReturn(true, false);
		
		convert.convertDevs(devsToConvert);
		assertEquals(devs, devs);
		
	}
}
