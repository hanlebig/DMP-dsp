package com.taiyear.dsp.marketing.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.taiyear.dsp.base.AbstractEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 广告model类
 * @author hanle
 * @Time：2017年4月5日 下午2:11:14
 * @version 1.0
 */


@Entity
@Table(name = "t_market")
public class Marketing extends AbstractEntity{
	//测试
	//测试
	//chhj
	@ApiModelProperty("营销类型 1：图片，2：图文，3：短信，4：彩信")
	@Column(name = "marketing_type", length = 255)
	private String marketingType;
	
	@ApiModelProperty("营销名字")
	@Column(name = "marketing_name", length = 255)
	private String marketingName;
	
	@ApiModelProperty("营销内容")
	@Column(name = "marketing_content", length = 255)
	private String marketingContent;
	
	@ApiModelProperty("状态，0:启用，1：关闭")
	@Column(name = "marketing_status", length = 255)
	private String marketingStatus;
	
	@ApiModelProperty("广告尺寸")
	@Column(name = "marketing_size", length = 255)
	private String marketingSize;
	
	@ApiModelProperty("到达地址")
	@Column(name = "send_address", length = 255)
	private String sendAddress;
	
	@ApiModelProperty("初审状态")
	@Column(name = "first_review_status", length = 255)
	private String firstReviewStatus;
	
	@ApiModelProperty("审核状态")
	@Column(name = "review_status", length = 255)
	private String reviewStatus;
	
	
	@ApiModelProperty("上传时间")
	@Column(name = "upload_time")
	private Date uploadTime;
	
	@ApiModelProperty("创建时间")
	@Column(name = "create_time")
	private Date createTime;
	
	@ApiModelProperty("修改时间")
	@Column(name = "update_time")
	private Date updateTime;
	
	@ApiModelProperty("修改时间")
	@Column(name = "file_path")
	private String filePath;

	@ApiModelProperty("计划id")
	@Column(name = "plan_id")
	private String planId;
	
	@ApiModelProperty("公司id")
	@Column(name = "compay_id")
	private String compayId;
	
	@ApiModelProperty("策略id")
	@Column(name = "strategy_id")
	private String strategyId;
	
	private String companyId;
	
	public String getMarketingType() {
		return marketingType;
	}

	public void setMarketingType(String marketingType) {
		this.marketingType = marketingType;
	}

	public String getMarketingContent() {
		return marketingContent;
	}

	public void setMarketingContent(String marketingContent) {
		this.marketingContent = marketingContent;
	}

	public String getMarketingStatus() {
		return marketingStatus;
	}

	public void setMarketingStatus(String marketingStatus) {
		this.marketingStatus = marketingStatus;
	}

	public String getMarketingSize() {
		return marketingSize;
	}

	public void setMarketingSize(String marketingSize) {
		this.marketingSize = marketingSize;
	}

	public String getSendAddress() {
		return sendAddress;
	}

	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}

	public String getFirstReviewStatus() {
		return firstReviewStatus;
	}

	public void setFirstReviewStatus(String firstReviewStatus) {
		this.firstReviewStatus = firstReviewStatus;
	}

	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
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

	public String getMarketingName() {
		return marketingName;
	}

	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getStrategyId() {
		return strategyId;
	}

	public void setStrategyId(String strategyId) {
		this.strategyId = strategyId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}
