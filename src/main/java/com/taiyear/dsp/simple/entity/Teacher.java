/**
 * 
 */
package com.taiyear.dsp.simple.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.taiyear.dsp.base.AbstractEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author liul
 * 
 */
@Entity
@Table(name = "t_simple_teacher")
public class Teacher extends AbstractEntity {

	@Column(name = "name")
	@ApiModelProperty("老师名称")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
