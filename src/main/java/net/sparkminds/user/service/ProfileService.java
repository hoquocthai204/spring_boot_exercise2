package net.sparkminds.user.service;

import java.util.List;

import net.sparkminds.user.dto.ProfileDTO;
import net.sparkminds.user.entity.Profile;

public interface ProfileService {

	List<Profile> getAllProfile();

	Profile createProfile(ProfileDTO profileDTO);

	void updateProfile(ProfileDTO profileDTO, Long id);

	void deleteProfile(Long id);
}
