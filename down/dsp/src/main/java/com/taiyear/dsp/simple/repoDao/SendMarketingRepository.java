//package com.taiyear.dsp.simple.repoDao;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface SendMarketingRepository extends
//		JpaRepository<SendMarketingTest, Long> {
//	/**
//	 * 消费金额
//	 * 
//	 * @param planId
//	 * @return
//	 */
//	@Query(value = "select send_count from t_simple_send_marketing where plan_id = ?1", nativeQuery = true)
//	double queryConsume(String planId);
//}
