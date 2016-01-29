package com.catalyst.springboot.services;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.springboot.dao.Dao;
import com.catalyst.springboot.entities.Dev;
import com.catalyst.springboot.entities.LineItem;
import com.catalyst.springboot.entities.Report;


@Service
public class ReportService {
	
	@Autowired
	private Dao reportDao;
	
	
	public void add(Report report) {
		//report.setUsers(convertDevs(report.getLineItemsToConvert()));
		report.setLineItems(convertLineItems(report.getLineItemsToConvert()));
		reportDao.addReport(report);
	}
	
	public Set<LineItem> convertLineItems(List<LineItem> LineItemToConvert){
		Set<LineItem> lineItems = new HashSet<LineItem>();
		for (LineItem lineItem : LineItemToConvert){
			lineItems.add(lineItem);
		}
		return lineItems;
	}
	


}
