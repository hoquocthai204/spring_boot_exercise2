package net.sparkminds.user.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ProfileDTO {
	
	@NotBlank(message = "Profile name is required")
	private String name;
	
	private String description;
	
	private Long subscriberId;
}
