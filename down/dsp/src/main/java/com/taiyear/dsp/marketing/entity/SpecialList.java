package com.taiyear.dsp.marketing.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.taiyear.dsp.base.AbstractEntity;
@Entity
@Table(name="t_special_list")
public class SpecialList extends AbstractEntity{

	public static String WHITE_MOBILE = "1";
	public static String BLACK_MOBILE = "2";
	
	@Column(name = "special_type", length = 2)
	@ApiModelProperty("特殊名单类型1：白名单，2黑名单")
	private String specialType;
	
	@Column(name="mobile",length = 20)
	@ApiModelProperty("电话号码")
	private String mobile;
	
	@Column(name="strategy_id",length = 36)
	@ApiModelProperty("策略id")
	private String strategyId;

	public String getSpecialType() {
		return specialType;
	}
	public void setSpecialType(String specialType) {
		this.specialType = specialType;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStrategyId() {
		return strategyId;
	}
	public void setStrategyId(String strategyId) {
		this.strategyId = strategyId;
	}
}
