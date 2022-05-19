package net.sparkminds.user.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.user.dto.ProfileDTO;
import net.sparkminds.user.entity.Profile;
import net.sparkminds.user.entity.Subscriber;
import net.sparkminds.user.reponsitory.ProfileRepository;
import net.sparkminds.user.reponsitory.SubscriberRepository;
import net.sparkminds.user.service.HistoryService;
import net.sparkminds.user.service.ProfileService;

@Service
@Transactional(readOnly = true)
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private SubscriberRepository subscriberRepository;

	@Autowired
	private HistoryService historyService;

	@Override
	public List<Profile> getAllProfile() {
		return profileRepository.findAll();
	}

	@Override
	@Transactional
	public Profile createProfile(ProfileDTO profileDTO) {
		Subscriber subscriber = subscriberRepository.findById(profileDTO.getSubscriberId())
				.orElseThrow(() -> new EntityNotFoundException("Subscriber Id is not exist"));
		Profile profile = new Profile();
		profile.setName(profileDTO.getName());
		profile.setDescription(profileDTO.getDescription());
		profile.setSubscriber(subscriber);
		return profileRepository.save(profile);
	}

	@Override
	@Transactional
	public void deleteProfile(Long id) {
		profileRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void updateProfile(ProfileDTO profileDTO, Long id) {
		Profile profile = profileRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Profile is not exist"));

		Subscriber subscriber = subscriberRepository.findById(profileDTO.getSubscriberId())
				.orElseThrow(() -> new EntityNotFoundException("Subscriber Id is not exist"));

		profile.setName(profileDTO.getName());
		profile.setDescription(profileDTO.getDescription());
		profile.setSubscriber(subscriber);

//		historyService.createProfileHistory(profileDTO, profile, subscriber);
	}

}
