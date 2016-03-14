package com.dynamicsearch.Business;

import java.util.List;

import com.dynamicsearch.Bean.DynamicSearchBean;
import com.dynamicsearch.Dao.DynamicSearchDao;

public class DynamicSearchBusiness {

	public List<List<String>> getSearchCriteriResult(DynamicSearchBean dynamicSearchBeanObj){
		
		return new DynamicSearchDao().getSearchResult(dynamicSearchBeanObj);
		
		
		
		
	}
}
