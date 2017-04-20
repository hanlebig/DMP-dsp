package com.taiyear.dsp.marketing.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.taiyear.dsp.base.AbstractEntity;
@Entity
@Table(name="rs_market_material")
public class MarketingAndMaterial extends AbstractEntity{
	
	@ApiModelProperty("marketing id ")
	@Column(name = "marketing_id", length = 36)
	private String marketingId;
	
	@ApiModelProperty("素材库id")
	@Column(name = "material_id", length = 36)
	private String materialId;

	public String getMarketingId() {
		return marketingId;
	}

	public void setMarketingId(String marketingId) {
		this.marketingId = marketingId;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	
}
