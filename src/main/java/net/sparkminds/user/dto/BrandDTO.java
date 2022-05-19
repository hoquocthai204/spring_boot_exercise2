package net.sparkminds.user.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class BrandDTO {
	
	@NotBlank(message = "Brand name is required")
	private String name;
	
	private String description;
}
