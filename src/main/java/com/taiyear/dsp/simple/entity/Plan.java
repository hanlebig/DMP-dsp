package com.taiyear.dsp.simple.entity;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.taiyear.dsp.base.AbstractEntity;

@Entity
@Table(name = "t_simple_plan")
public class Plan extends AbstractEntity {

	public String getId() {
		return super.getId();
	}

	@ApiModelProperty("计划名")
	@Column(name = "plan_name", length = 200)
	private String planName;

	@ApiModelProperty("状态 0启用，1禁用")
	@Column(name = "plan_status", length = 2)
	private String planStatus;

	@ApiModelProperty("计划类型，1：广告计划，2：短彩信计划")
	@Column(name = "plan_type", length = 2)
	private String planType;

	@ApiModelProperty("投放状态0：投放，1：未投放")
	@Column(name = "put_status", length = 2)
	private String putStatus;

	@ApiModelProperty("投放周期开始")
	@Column(name = "put_period_start", length = 100)
	private String putPeriodStart;

	@ApiModelProperty("投放周期结束")
	@Column(name = "put_period_end", length = 100)
	private String putPeriodEnd;

	@ApiModelProperty("总预算")
	@Column(name = "budget_total", length = 0)
	private double budgetTotal;

	@ApiModelProperty("媒体类型")
	@Column(name = "media_type", length = 100)
	private String mediaType;

	@ApiModelProperty("结算方式id")
	@Column(name = "settlement_type_id", length = 100)
	private String settlementTypeId;

	@ApiModelProperty("结算方式值")
	@Column(name = "settlement_type_value", length = 200)
	private String settlementTypeValue;

	@ApiModelProperty("每日预算")
	@Column(name = "budget_date", length = 0)
	private double budgetDate;

	@ApiModelProperty("曝光总上限")
	@Column(name = "exposure_total", length = 0)
	private int exposureTotal;

	@ApiModelProperty("点击总上限")
	@Column(name = "click_total", length = 0)
	private int clickTotal;

	@ApiModelProperty("每日曝光上限")
	@Column(name = "exposure_date", length = 0)
	private int exposureDate;

	@ApiModelProperty("每日点击上限")
	@Column(name = "click_date", length = 0)
	private int clickDate;

	@ApiModelProperty("曝光频次类型")
	@Column(name = "exposure_rate_type", length = 100)
	private String exposureRateType;

	@ApiModelProperty("曝光频次")
	@Column(name = "exposure_rate", length = 0)
	private int exposureRate;

	@ApiModelProperty("点击频次类型")
	@Column(name = "click_rate_type", length = 100)
	private String clickRateType;

	@ApiModelProperty("点击频次")
	@Column(name = "click_rate", length = 0)
	private int clickRate;

	@ApiModelProperty("审核状态0：通过，1：不通过")
	@Column(name = "review_status", length = 2)
	private String reviewStatus;

	@ApiModelProperty("创建时间")
	@Column(name = "create_time", length = 0)
	private Timestamp createTime;

	@ApiModelProperty("更新时间")
	@Column(name = "update_time", length = 0)
	private Timestamp updateTime;

	private double balance; // 余额

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getPutStatus() {
		return putStatus;
	}

	public void setPutStatus(String putStatus) {
		this.putStatus = putStatus;
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

	public double getBudgetTotal() {
		return budgetTotal;
	}

	public void setBudgetTotal(double budgetTotal) {
		this.budgetTotal = budgetTotal;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getSettlementTypeId() {
		return settlementTypeId;
	}

	public void setSettlementTypeId(String settlementTypeId) {
		this.settlementTypeId = settlementTypeId;
	}

	public String getSettlementTypeValue() {
		return settlementTypeValue;
	}

	public void setSettlementTypeValue(String settlementTypeValue) {
		this.settlementTypeValue = settlementTypeValue;
	}

	public double getBudgetDate() {
		return budgetDate;
	}

	public void setBudgetDate(double budgetDate) {
		this.budgetDate = budgetDate;
	}

	public int getExposureTotal() {
		return exposureTotal;
	}

	public void setExposureTotal(int exposureTotal) {
		this.exposureTotal = exposureTotal;
	}

	public int getClickTotal() {
		return clickTotal;
	}

	public void setClickTotal(int clickTotal) {
		this.clickTotal = clickTotal;
	}

	public int getExposureDate() {
		return exposureDate;
	}

	public void setExposureDate(int exposureDate) {
		this.exposureDate = exposureDate;
	}

	public int getClickDate() {
		return clickDate;
	}

	public void setClickDate(int clickDate) {
		this.clickDate = clickDate;
	}

	public String getExposureRateType() {
		return exposureRateType;
	}

	public void setExposureRateType(String exposureRateType) {
		this.exposureRateType = exposureRateType;
	}

	public int getExposureRate() {
		return exposureRate;
	}

	public void setExposureRate(int exposureRate) {
		this.exposureRate = exposureRate;
	}

	public String getClickRateType() {
		return clickRateType;
	}

	public void setClickRateType(String clickRateType) {
		this.clickRateType = clickRateType;
	}

	public int getClickRate() {
		return clickRate;
	}

	public void setClickRate(int clickRate) {
		this.clickRate = clickRate;
	}

	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Plan() {
		super();
	}

}
