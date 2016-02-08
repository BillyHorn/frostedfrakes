package com.catalyst.springboot.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.catalyst.springboot.entities.Dev;

/**
 * Holds functions to convert lists to hashsets.
 * 
 * @author kmatthiesen
 *
 */
@Service
public class Converters {

	
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
