package net.sparkminds.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sparkminds.user.dto.ProfileDTO;
import net.sparkminds.user.entity.Profile;
import net.sparkminds.user.service.ProfileService;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

	private final ProfileService profileService;

	public ProfileController(ProfileService profileService) {
		this.profileService = profileService;
	}
	
	@GetMapping
	public ResponseEntity<List<Profile>> getProfile(){
		return ResponseEntity.ok(profileService.getAllProfile());
	}
	
	@PostMapping
	public ResponseEntity<Profile> postProfile(@Valid @RequestBody ProfileDTO profileDTO){
		return ResponseEntity.ok(profileService.createProfile(profileDTO));
	}
	
	@PutMapping("/{is}")
	public ResponseEntity<?> putProfile(@PathVariable("id") Long id,@Valid @RequestBody ProfileDTO profileDTO){
		profileService.updateProfile(profileDTO,id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProfile(@PathVariable("id") Long id){
		profileService.deleteProfile(id);
		return ResponseEntity.noContent().build();
	}
}
