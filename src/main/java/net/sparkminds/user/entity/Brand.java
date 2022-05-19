package net.sparkminds.user.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "Brand")
@Data
@EqualsAndHashCode(callSuper=false)
public class Brand extends Base {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy="brand")
	@JsonIgnore
    private List<Subscriber> subscribers;
}
