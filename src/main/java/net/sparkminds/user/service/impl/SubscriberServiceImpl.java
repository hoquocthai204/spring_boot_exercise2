package net.sparkminds.user.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.user.dto.SubscriberDTO;
import net.sparkminds.user.entity.Brand;
import net.sparkminds.user.entity.Subscriber;
import net.sparkminds.user.reponsitory.BrandRepository;
import net.sparkminds.user.reponsitory.SubscriberRepository;
import net.sparkminds.user.service.HistoryService;
import net.sparkminds.user.service.SubscriberService;

@Service
@Transactional(readOnly = true)
public class SubscriberServiceImpl implements SubscriberService {

	@Autowired
	private SubscriberRepository subscriberRepository;

	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private HistoryService historyService;

	@Override
	public Subscriber getSubscriber(Long id) {
		return subscriberRepository.findById(id).get();
	}

	@Override
	@Transactional
	public Subscriber createSubscriber(@Valid SubscriberDTO subscriberDTO) {
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		Brand brand = brandRepository.findById(subscriberDTO.getBrandId())
				.orElseThrow(() -> new EntityNotFoundException("Brand Id is not exist"));
		Subscriber subscriber = new Subscriber();
		try {
			subscriber.setBirthday(formatter1.parse(subscriberDTO.getBirthday()));
			subscriber.setCreatedDate(formatter1.parse(subscriberDTO.getCreatedDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		subscriber.setSex(subscriberDTO.getSex());
		subscriber.setPhoneNumber(subscriberDTO.getPhoneNumber());
		subscriber.setBrand(brand);
		return subscriberRepository.save(subscriber);
	}

	@Override
	@Transactional
	public void updateSubscriber(@Valid SubscriberDTO subscriberDTO, Long id) {
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		Subscriber subscriber = subscriberRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Subscriber is not exist"));
		Brand brand = brandRepository.findById(subscriberDTO.getBrandId())
				.orElseThrow(() -> new EntityNotFoundException("Brand Id is not exist"));

		try {
			subscriber.setBirthday(formatter1.parse(subscriberDTO.getBirthday()));
			subscriber.setCreatedDate(formatter1.parse(subscriberDTO.getCreatedDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		subscriber.setSex(subscriberDTO.getSex());
		subscriber.setPhoneNumber(subscriberDTO.getPhoneNumber());
		subscriber.setBrand(brand);

//		historyService.createSubscriberHistory(subscriberDTO, subscriber, brand);
	}

	@Override
	@Transactional
	public void deleteSubscriber(Long id) {
		subscriberRepository.deleteById(id);
	}

	@Override
	public List<Subscriber> getAllSubscriber() {
		return subscriberRepository.findAll();
	}

	@Override
	public List<Subscriber> getSubscribersByCreateDate(Date createdDate) {
		return subscriberRepository.findByCreatedDate(createdDate);
	}

	@Override
	public List<Subscriber> getSubscribersByBirthday(Date birthday) {
		return subscriberRepository.findByBirthday(birthday);
	}

	@Override
	public List<Subscriber> getSubscribersBySex(String sex) {
		return subscriberRepository.findBySex(sex);
	}

}
