package com.taiyear.dsp.marketing.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.taiyear.dsp.base.AbstractEntity;

@Entity
@Table(name = "t_strategy")
public class Strategy extends AbstractEntity {

	@Column(name = "strategy_name",length=100)
	@ApiModelProperty("策略名称")
	private String strategyName;
	
	@Column(name = "strategy_status",length=2)
	@ApiModelProperty("策略状态0：启用，1：禁用")
	private String strategyStatus;

	@Column(name = "strategy_type",length=2)
	@ApiModelProperty("策略类型，1：广告，2：短彩信")
	private String strategyType;
	
	@Column(name="put_status",length=2)	
	@ApiModelProperty("投放状态0：已投放，1：未投放")
	private String putStatus;
	
	@Column(name="budget_total")	
	@ApiModelProperty("总预算")
	private Double budgetTotal;
	
	@Column(name="budget_date")	
	@ApiModelProperty("每日预算")
	private Double budgetDate;
	
	@Column(name="ad_channel_id",length=255)	
	@ApiModelProperty("广告渠道id")
	private String adChannelId;
	
	@Column(name="ad_channel_value",length=255)	
	@ApiModelProperty("广告渠道value")
	private String adChannelValue;
	
	@Column(name="platform_type_id",length=100)	
	@ApiModelProperty("平台类型id")
	private String platformTypeId;
	
	@Column(name="platform_type_value",length=100)	
	@ApiModelProperty("平台类型value")
	private String platformTypeValue;
	
	@Column(name="ad_type_id",length=100)	
	@ApiModelProperty("广告形式id")
	private String adTypeId;
	
	@Column(name="ad_type_value",length=100)	
	@ApiModelProperty("广告形式value")
	private String adTypeValue;
	
	@Column(name="put_period_start",length=100)	
	@ApiModelProperty("投放周期开始")
	private String putPeriodStart;
	
	@Column(name="put_period_end",length=100)	
	@ApiModelProperty("投放周期结束")
	private String putPeriodEnd;
	
	@Column(name="send_type_id",length=100)	
	@ApiModelProperty("发送方式ID")
	private String sendTypeId;
	
	@Column(name="send_type_value",length=100)	
	@ApiModelProperty("发送方式value")
	private String sendTypeValue;
	
	@Column(name="send_time",length=50)	
	@ApiModelProperty("定时发送设置")
	private String sendTime;
	
	@Column(name="send_rade_type",length=50)	
	@ApiModelProperty("发送频次类型")
	private String sendRadeType;
	
	@Column(name="send_rede")	
	@ApiModelProperty("发送频次")
	private int sendRede;
	
	@Column(name="send_count")	
	@ApiModelProperty("发送量")
	private int sendCount;
	
	@Column(name="reach_count")	
	@ApiModelProperty("到达量")
	private int reachCount;
	
	@Column(name="msg_put_count_id",length=50)	
	@ApiModelProperty("消息已推送次数")
	private String msgPutCountId;
	
	@Column(name="msg_put_count_value",length=50)	
	@ApiModelProperty("消息已推送次数值")
	private String msgPutCountValue;
	
	@Column(name="msg_open_count_id",length=50)	
	@ApiModelProperty("消息已打开次数id")
	private String msgOpenCountId;
	
	@Column(name="msg_open_count_value",length=50)	
	@ApiModelProperty("消息已打开次数值")
	private String msgOpenCountValue;

	@Column(name="bid_max")	
	@ApiModelProperty("最大出价")
	private Double bidMax;
	
	@Column(name="single_click_rade_type",length=100)	
	@ApiModelProperty("单人点击频率类型")
	private String singleClickRadeType;
	
	@Column(name="single_click_rade")	
	@ApiModelProperty("单人点击频次")
	private int singleClickRade;
	
	@Column(name="single_exposure_rade_type",length=100)	
	@ApiModelProperty("单人曝光频次类型")
	private String singleExposureRadeType;
	
	@Column(name="single_exposure_rede")	
	@ApiModelProperty("单人曝光频次类型")
	private int singleExposureRede;
	@Column(name="exposureDate")	
	@ApiModelProperty("每日曝光上限")
	private Double exposureDate;
	
	@Column(name="click_date")	
	@ApiModelProperty("每日点击上限")
	private Double clickDate;
	
	@Column(name="exposure_total")	
	@ApiModelProperty("每日点击上限")
	private Double exposureTotal;
	
	@Column(name="create_time")	
	@ApiModelProperty("创建时间")
	private Date createTime;
	
	@Column(name="update_time")	
	@ApiModelProperty("更新时间")
	private Date updateTime;
	
	@Column(name = "plan_id", nullable = false)
	@ApiModelProperty("计划id")
	private String planId;

	public String getStrategyName() {
		return strategyName;
	}

	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}

	public String getStrategyStatus() {
		return strategyStatus;
	}

	public void setStrategyStatus(String strategyStatus) {
		this.strategyStatus = strategyStatus;
	}

	public String getStrategyType() {
		return strategyType;
	}

	public void setStrategyType(String strategyType) {
		this.strategyType = strategyType;
	}

	public String getPutStatus() {
		return putStatus;
	}

	public void setPutStatus(String putStatus) {
		this.putStatus = putStatus;
	}

	public Double getBudgetTotal() {
		return budgetTotal;
	}

	public void setBudgetTotal(Double budgetTotal) {
		this.budgetTotal = budgetTotal;
	}

	public Double getBudgetDate() {
		return budgetDate;
	}

	public void setBudgetDate(Double budgetDate) {
		this.budgetDate = budgetDate;
	}

	public String getAdChannelId() {
		return adChannelId;
	}

	public void setAdChannelId(String adChannelId) {
		this.adChannelId = adChannelId;
	}

	public String getAdChannelValue() {
		return adChannelValue;
	}

	public void setAdChannelValue(String adChannelValue) {
		this.adChannelValue = adChannelValue;
	}

	public String getPlatformTypeId() {
		return platformTypeId;
	}

	public void setPlatformTypeId(String platformTypeId) {
		this.platformTypeId = platformTypeId;
	}

	public String getPlatformTypeValue() {
		return platformTypeValue;
	}

	public void setPlatformTypeValue(String platformTypeValue) {
		this.platformTypeValue = platformTypeValue;
	}

	public String getAdTypeId() {
		return adTypeId;
	}

	public void setAdTypeId(String adTypeId) {
		this.adTypeId = adTypeId;
	}

	public String getAdTypeValue() {
		return adTypeValue;
	}

	public void setAdTypeValue(String adTypeValue) {
		this.adTypeValue = adTypeValue;
	}

	public String getPutPeriodStart() {
		return putPeriodStart;
	}

	public void setPutPeriodStart(String putPeriodStart) {
		this.putPeriodStart = putPeriodStart;
	}

	public String getPutPeriodEnd() {
		return putPeriodEnd;
	}

	public void setPutPeriodEnd(String putPeriodEnd) {
		this.putPeriodEnd = putPeriodEnd;
	}

	public String getSendTypeId() {
		return sendTypeId;
	}

	public void setSendTypeId(String sendTypeId) {
		this.sendTypeId = sendTypeId;
	}

	public String getSendTypeValue() {
		return sendTypeValue;
	}

	public void setSendTypeValue(String sendTypeValue) {
		this.sendTypeValue = sendTypeValue;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendRadeType() {
		return sendRadeType;
	}

	public void setSendRadeType(String sendRadeType) {
		this.sendRadeType = sendRadeType;
	}

	public int getSendRede() {
		return sendRede;
	}

	public void setSendRede(int sendRede) {
		this.sendRede = sendRede;
	}

	public int getSendCount() {
		return sendCount;
	}

	public void setSendCount(int sendCount) {
		this.sendCount = sendCount;
	}

	public int getReachCount() {
		return reachCount;
	}

	public void setReachCount(int reachCount) {
		this.reachCount = reachCount;
	}

	public String getMsgPutCountId() {
		return msgPutCountId;
	}

	public void setMsgPutCountId(String msgPutCountId) {
		this.msgPutCountId = msgPutCountId;
	}

	public String getMsgPutCountValue() {
		return msgPutCountValue;
	}

	public void setMsgPutCountValue(String msgPutCountValue) {
		this.msgPutCountValue = msgPutCountValue;
	}

	public String getMsgOpenCountId() {
		return msgOpenCountId;
	}

	public void setMsgOpenCountId(String msgOpenCountId) {
		this.msgOpenCountId = msgOpenCountId;
	}

	public String getMsgOpenCountValue() {
		return msgOpenCountValue;
	}

	public void setMsgOpenCountValue(String msgOpenCountValue) {
		this.msgOpenCountValue = msgOpenCountValue;
	}

	public Double getBidMax() {
		return bidMax;
	}

	public void setBidMax(Double bidMax) {
		this.bidMax = bidMax;
	}

	public String getSingleClickRadeType() {
		return singleClickRadeType;
	}

	public void setSingleClickRadeType(String singleClickRadeType) {
		this.singleClickRadeType = singleClickRadeType;
	}

	public int getSingleClickRade() {
		return singleClickRade;
	}

	public void setSingleClickRade(int singleClickRade) {
		this.singleClickRade = singleClickRade;
	}

	public String getSingleExposureRadeType() {
		return singleExposureRadeType;
	}

	public void setSingleExposureRadeType(String singleExposureRadeType) {
		this.singleExposureRadeType = singleExposureRadeType;
	}

	public int getSingleExposureRede() {
		return singleExposureRede;
	}

	public void setSingleExposureRede(int singleExposureRede) {
		this.singleExposureRede = singleExposureRede;
	}

	public Double getExposureDate() {
		return exposureDate;
	}

	public void setExposureDate(Double exposureDate) {
		this.exposureDate = exposureDate;
	}

	public Double getClickDate() {
		return clickDate;
	}

	public void setClickDate(Double clickDate) {
		this.clickDate = clickDate;
	}

	public Double getExposureTotal() {
		return exposureTotal;
	}

	public void setExposureTotal(Double exposureTotal) {
		this.exposureTotal = exposureTotal;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

}
