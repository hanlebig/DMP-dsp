package com.taiyear.dsp.marketing.service;

import com.taiyear.dsp.marketing.entity.Marketing;
import com.taiyear.dsp.marketing.entity.thread.ResultJson;

public interface MarketingService {
	
	/**
	 * 保存短信内容等相关信息
	 *saveSMS:(). 
	 * @author hanle 
	 * @param marketing
	 * @return
	 */
	public ResultJson saveSMS(Marketing marketing);

	/**
	 * 保存彩信内容
	 *saveSMMS:(). 
	 * @author hanle 
	 * @param marketing
	 * @return
	 */
	public ResultJson saveSMMS(Marketing marketing,String[] ids);
	
	/**
	 * 分页查询信息
	 *findAll:(). 
	 * @author hanle 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public ResultJson findAll(int pageNo,int pageSize);

	
	/**
	 * 批量更新广告状态
	 *updateMarketingStatus:(). 
	 * @author hanle 
	 * @param ids
	 * @param status
	 */
	public ResultJson updateMarketingStatus(String[] ids, String status);

	/**
	 * 批量删除广告
	 *delete:(). 
	 * @author hanle 
	 * @param ids
	 * @return
	 */
	public ResultJson delete(String[] ids);
	

}
