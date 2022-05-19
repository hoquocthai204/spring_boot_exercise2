package net.sparkminds.user.service;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import net.sparkminds.user.dto.SubscriberDTO;
import net.sparkminds.user.entity.Subscriber;

public interface SubscriberService {

	Subscriber getSubscriber(Long id);

	Subscriber createSubscriber(@Valid SubscriberDTO subscriberDTO);

	void updateSubscriber(@Valid SubscriberDTO subscriberDTO, Long id);

	void deleteSubscriber(Long id);

	List<Subscriber> getAllSubscriber();

	List<Subscriber> getSubscribersByCreateDate(Date createdDate);

	List<Subscriber> getSubscribersByBirthday(Date birthday);

	List<Subscriber> getSubscribersBySex(String sex);
}
