package net.sparkminds.user.service;

import java.util.List;

import net.sparkminds.user.dto.BrandDTO;
import net.sparkminds.user.dto.ProfileDTO;
import net.sparkminds.user.dto.SubscriberDTO;
import net.sparkminds.user.entity.Brand;
import net.sparkminds.user.entity.History;
import net.sparkminds.user.entity.Profile;
import net.sparkminds.user.entity.Subscriber;

public interface HistoryService {
	List<History> getAllData();

	History getDataById(Long id);
	
	void createBrandHistory(BrandDTO brandDTO, Brand brand);
	void createSubscriberHistory(SubscriberDTO subscriberDTO, Subscriber subscriber, Brand brand);
	void createProfileHistory(ProfileDTO profileDTO, Profile profile, Subscriber subscriber);

}
