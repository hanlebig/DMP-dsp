/**
 * 
 */
package com.taiyear.dsp.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author liul
 * 
 */
@MappedSuperclass
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public abstract class AbstractEntity extends EntitySupport {
	public static final int VERSION = 1; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id", length = 36)
	private String id;

	@Version
	@Column(name = "version")
	private int version;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
