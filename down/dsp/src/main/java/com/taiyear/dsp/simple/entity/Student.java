/**
 * 
 */
package com.taiyear.dsp.simple.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.taiyear.dsp.base.AbstractEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author liul
 * 
 */
@Entity
@Table(name = "t_simple_student")
public class Student extends AbstractEntity {

	@ApiModelProperty("学生姓名")
	@Column(name = "name", length = 255)
	private String name;

	@ApiModelProperty("学生电话")
	@Column(name = "mobile", length = 255)
	private String mobile;

	@ApiModelProperty("老师")
	@OneToOne(fetch = FetchType.LAZY)
	private Teacher teacher;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
