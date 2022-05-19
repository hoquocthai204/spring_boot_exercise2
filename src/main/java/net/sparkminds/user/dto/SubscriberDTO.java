package net.sparkminds.user.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import net.sparkminds.user.entity.enumeration.SubscriberSex;

@Data
public class SubscriberDTO {
	
	@NotBlank(message = "Phone number is required")
	private String phoneNumber;
	
	private String birthday;
	
	private SubscriberSex sex;
	
	private Long brandId;
	
	private String createdDate;
}
