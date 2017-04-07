package com.taiyear.dsp.marketing.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.taiyear.dsp.base.AbstractEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 发送营销广告model类
 * @author hanle
 * @Time：2017年4月5日 下午3:43:17
 * @version 1.0
 */

@Entity
@Table(name = "sendMarketing")
public class SendMarketing extends AbstractEntity{

	@ApiModelProperty("发送时间")
	@Column(name = "send_time", length = 0)
	private Date sendTime;

	@ApiModelProperty("发送类型1：图片，2：图文，3：短信，4：彩信")
	@Column(name = "send_type", length = 50)
	private String sendType;

	@ApiModelProperty("广告id")
	@Column(name = "marketing_id", length = 50)
	private String marketingId;

	@ApiModelProperty("策略id")
	@Column(name = "strategy_id", length = 50)
	private String strategyId;

	@ApiModelProperty("计划id")
	@Column(name = "plan_id", length = 50)
	private String planId;

	@ApiModelProperty("手机号")
	@Column(name = "molibe", length = 50)
	private String moblie;

	@ApiModelProperty("发送数量")
	@Column(name = "send_count", length = 0)
	private int sendCount;

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public String getMarketingId() {
		return marketingId;
	}

	public void setMarketingId(String marketingId) {
		this.marketingId = marketingId;
	}

	public String getStrategyId() {
		return strategyId;
	}

	public void setStrategyId(String strategyId) {
		this.strategyId = strategyId;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getMoblie() {
		return moblie;
	}

	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}

	public int getSendCount() {
		return sendCount;
	}

	public void setSendCount(int sendCount) {
		this.sendCount = sendCount;
	}
	
	
	
}
