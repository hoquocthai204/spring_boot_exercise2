package net.sparkminds.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.sparkminds.user.entity.enumeration.HistoryStatus;

@Entity
@Table(name = "History")
@Data
@EqualsAndHashCode(callSuper = false)
public class History extends Base {

	@OneToOne
	@JoinColumn(name = "brand_id", referencedColumnName = "id")
	private Brand brand;

	@OneToOne
	@JoinColumn(name = "subscriber_id", referencedColumnName = "id")
	private Subscriber subscriber;

	@OneToOne
	@JoinColumn(name = "profile_id", referencedColumnName = "id")
	private Profile profile;

	@Column(name = "status")
	private HistoryStatus status;
	
	@Column(name = "message")
	private String message;
}
