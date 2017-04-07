package com.taiyear.dsp.simple.repoDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.taiyear.dsp.simple.entity.PageBean;
import com.taiyear.dsp.simple.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {
	/**
	 * 查询计划
	 * 
	 * @param planId
	 * @return
	 */
	@Query(value = "select * from t_simple_plan where id = ?1", nativeQuery = true)
	Plan queryPlan(String planId);

	/**
	 * 删除计划
	 * 
	 * @param planId
	 */
	@Modifying
	@Query(value = "delete from t_simple_plan where id = ?1", nativeQuery = true)
	void deletePlan(String planId);

	/**
	 * 更改投放状态
	 * 
	 * @param putStatus
	 * @param planId
	 * @return
	 */
	@Modifying
	@Query("update Plan as p set p.putStatus = ?1 where p.id =?2")
	boolean updatePutStatus(String putStatus, String planId);

	/**
	 * 更改审核状态
	 * 
	 * @param reviewStatus
	 * @param planId
	 * @return
	 */
	@Modifying
	@Query("update Plan as p set p.reviewStatus = ?1 where p.id =?2")
	boolean updatereviewStatus(String reviewStatus, String planId);

	/**
	 * 模糊查询
	 * 
	 * @param keyWord
	 * @return
	 */
	@Query(value = "select * from t_simple_plan where plan_name like %?1%", nativeQuery = true)
	List<Plan> queryFuzzy(String keyWord);

	/**
	 * 计划总数
	 * @return
	 */
	@Query(value = "select count(*) from t_simple_plan", nativeQuery = true)
	int queryPlanNum();

	/**
	 * 分页查询
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@Query(value = "select * from t_simple_plan limit ?1,?2", nativeQuery = true)
	List<Plan> PagedByPlan(int currentPage, int pageSize);

}
