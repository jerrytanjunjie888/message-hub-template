package com.decathlon.module.message.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Refrence: GeneratorType.AUTO: Generate Id GenerationType.IDENTITY
 * @Author: jerry.Tan
 * @Date: 2019/4/11 20:49
 * @Modify:
 **/
@MappedSuperclass
public abstract class IdEntity implements LongId, Serializable {

	private static final long serialVersionUID = 1L;

	protected Long id;

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String properties_string;

	@Column(length = 4000)
	public String getProperties_string() {
		return properties_string;
	}

	public void setProperties_string(String properties_string) {
		this.properties_string = properties_string;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(getId()).build();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IdEntity))
			return false;
		IdEntity castObj = (IdEntity) obj;
		if (this.getId() == null || castObj.getId() == null)
			return false;

		return new EqualsBuilder().append(this.getId(), castObj.getId())
				.isEquals();
	}

}
