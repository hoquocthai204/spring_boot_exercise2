package net.sparkminds.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "last_modified_by")
	private String lastModifiedBy;

	@Column(name = "last_modified_date")
	private Date lastModifiedDate;


	@PrePersist
	public void onSave() {
		Date currentDate = new Date();

		this.createdDate = currentDate;
		this.lastModifiedDate = currentDate;
	}
	
	@PostPersist
	public void onUpdate() {
		Date currentDate = new Date();
		this.lastModifiedDate = currentDate;
	}

}
