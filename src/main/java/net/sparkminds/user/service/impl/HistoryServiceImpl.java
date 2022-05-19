package net.sparkminds.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.user.dto.BrandDTO;
import net.sparkminds.user.dto.ProfileDTO;
import net.sparkminds.user.dto.SubscriberDTO;
import net.sparkminds.user.entity.Brand;
import net.sparkminds.user.entity.History;
import net.sparkminds.user.entity.Profile;
import net.sparkminds.user.entity.Subscriber;
import net.sparkminds.user.entity.enumeration.HistoryStatus;
import net.sparkminds.user.reponsitory.HistoryRepository;
import net.sparkminds.user.service.HistoryService;

@Service
@Transactional(readOnly = true)
public class HistoryServiceImpl implements HistoryService {
	
	@Autowired
	private HistoryRepository historyRepository;

	@Override
	public List<History> getAllData() {
		return historyRepository.findAll();
	}

	@Override
	public History getDataById(Long id) {
		return historyRepository.findById(id).get();
	}

	@Override
	public void createBrandHistory(BrandDTO brandDTO, Brand brand) {
		// TODO Auto-generated method stub
		History history = new History();
		history.setBrand(brand);
		history.setStatus(HistoryStatus.Success);
		history.setMessage("Update Brand");
		historyRepository.save(history);
	}

	@Override
	public void createSubscriberHistory(SubscriberDTO subscriberDTO, Subscriber subscriber, Brand brand) {
		// TODO Auto-generated method stub
		History history = new History();
		history.setSubscriber(subscriber);
		history.setBrand(brand);
		history.setStatus(HistoryStatus.Success);
		history.setMessage("Update Subscriber");
		historyRepository.save(history);
	}

	@Override
	public void createProfileHistory(ProfileDTO profileDTO, Profile profile, Subscriber subscriber) {
		// TODO Auto-generated method stub
		History history = new History();
		history.setProfile(profile);
		history.setSubscriber(subscriber);
		history.setStatus(HistoryStatus.Success);
		history.setMessage("Update Profile");
		historyRepository.save(history);
	}


}
