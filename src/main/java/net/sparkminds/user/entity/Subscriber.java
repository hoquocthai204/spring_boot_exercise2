package net.sparkminds.user.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.sparkminds.user.entity.enumeration.SubscriberSex;

@Entity
@Table(name = "Subscriber")
@Data
@EqualsAndHashCode(callSuper=false)
public class Subscriber extends Base {
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "sex")
	@Enumerated(EnumType.STRING)
	private SubscriberSex sex;
	
	@ManyToOne
    @JoinColumn(name="brand_id", nullable=false)
    private Brand brand;
	
	@OneToMany(mappedBy="subscriber")
	@JsonIgnore
    private List<Profile> Profiles;
}
