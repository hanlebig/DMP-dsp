/**
 * 
 */
package com.taiyear.dsp.simple.service;

import java.util.List;

import com.taiyear.dsp.simple.entity.PageBean;
import com.taiyear.dsp.simple.entity.Plan;
import com.taiyear.dsp.simple.entity.Student;

/**
 * @author nwang
 * 
 */
public interface SimpleService {

	public void save();

	public boolean deletePlan(String planId);

	public boolean deleteBatchPlan(String[] plans);

	public boolean updatePlan(String planId);

	public Student query();

	public void savePlan(Plan plan);

	public Plan queryPlan(String planId);

	public double queryConsume(String planId);

	public boolean updatePutStatus(String putStatus, String planId);

	public List<Plan> queryFuzzy(String keyWord);

	public List<Plan> paged(PageBean pageBean);

	public int queryPlanNum();

}
