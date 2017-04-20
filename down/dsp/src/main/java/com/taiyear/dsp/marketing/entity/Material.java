package com.taiyear.dsp.marketing.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.taiyear.dsp.base.AbstractEntity;

@Entity
@Table(name = "t_material")
public class Material extends AbstractEntity{
	
	public final static String AUDIT_SATAUS_SUCCESS = "2";
	
	public final static String AUDIT_SATAUS_NOT_SUCCESS = "0"; //审核未通过
	
	public final static String AUDIT_SATAUS_WAIT_SUCCESS = "1";
	
	@ApiModelProperty("图片路径")
	@Column(name = "img_path")
	private String imgPath;
	
	@ApiModelProperty("审核状态")
	@Column(name = "audit_status")
	private String auditStatus;
	
	@ApiModelProperty("创建时间")
	@Column(name = "create_time")
	private Date createTime;
	
	@ApiModelProperty("创建时间")
	@Column(name = "update_time")
	private Date updateTime;
	
	@ApiModelProperty("审核人")
	@Column(name = "audit_user_id")
	private String auditUserId; //审核人

	@ApiModelProperty("图片大小")
	@Column(name = "img_size")
	private String imgSize; //审核人
	
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
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

	public String getAuditUserId() {
		return auditUserId;
	}

	public void setAuditUserId(String auditUserId) {
		this.auditUserId = auditUserId;
	}

	public String getImgSize() {
		return imgSize;
	}

	public void setImgSize(String imgSize) {
		this.imgSize = imgSize;
	}
	
}
