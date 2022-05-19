package net.sparkminds.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "Profile")
@Data
@EqualsAndHashCode(callSuper=false)
public class Profile extends Base {

	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
    @JoinColumn(name="subscriber_id", nullable=false)
    private Subscriber subscriber;
}
