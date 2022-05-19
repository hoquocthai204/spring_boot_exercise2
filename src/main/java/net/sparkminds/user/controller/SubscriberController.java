package net.sparkminds.user.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sparkminds.user.dto.SubscriberDTO;
import net.sparkminds.user.entity.Subscriber;
import net.sparkminds.user.service.SubscriberService;

@RestController
@RequestMapping("/api/subscribers")
public class SubscriberController {

	private final SubscriberService subscriberService;

	public SubscriberController(SubscriberService subscriberService) {
		this.subscriberService = subscriberService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Subscriber> getListSubscriber(@PathVariable("id") Long id) {
		return ResponseEntity.ok(subscriberService.getSubscriber(id));
	}

	@GetMapping
	public ResponseEntity<List<Subscriber>> getAllSubscriber() {
		return ResponseEntity.ok(subscriberService.getAllSubscriber());
	}

	@GetMapping(headers = "created-date")
	public ResponseEntity<List<Subscriber>> getSubscriberByCreateDate(@RequestHeader("created-date") Date createdDate) {
		return ResponseEntity.ok(subscriberService.getSubscribersByCreateDate(createdDate));
	}

	@GetMapping(headers = "birthday")
	public ResponseEntity<List<Subscriber>> getSubscribersByBirthday(@RequestHeader("birthday") Date birthday) {
		return ResponseEntity.ok(subscriberService.getSubscribersByBirthday(birthday));
	}

	@GetMapping(headers = "sex")
	public ResponseEntity<List<Subscriber>> getSubscribersBySex(@RequestHeader("sex") String sex) {
		return ResponseEntity.ok(subscriberService.getSubscribersBySex(sex));
	}

	@PostMapping
	public ResponseEntity<Subscriber> postSubscriber(@Valid @RequestBody SubscriberDTO subscriberDTO) {
		return ResponseEntity.ok(subscriberService.createSubscriber(subscriberDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> putSubscriber(@PathVariable("id") Long id,
			@Valid @RequestBody SubscriberDTO subscriberDTO) {
		subscriberService.updateSubscriber(subscriberDTO, id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSubscriber(@PathVariable("id") Long id) {
		subscriberService.deleteSubscriber(id);
		return ResponseEntity.noContent().build();
	}
}
