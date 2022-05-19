package net.sparkminds.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sparkminds.user.dto.BrandDTO;
import net.sparkminds.user.entity.Brand;
import net.sparkminds.user.service.BrandService;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

	private final BrandService brandService;

	public BrandController(BrandService brandService) {
		this.brandService = brandService;
	}
	
	@GetMapping
	public ResponseEntity<List<Brand>> getAllBrand(){
		return ResponseEntity.ok(brandService.getAllBrand());
	}
	
	@PostMapping
	public ResponseEntity<Brand> postBrand(@RequestBody BrandDTO brandDTO){
		return ResponseEntity.ok(brandService.createBrand(brandDTO));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> putBrand(@PathVariable("id") Long id, @RequestBody BrandDTO brandDTO){
		brandService.updateBrand(brandDTO, id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBrand(@PathVariable("id") Long id){
		brandService.deleteBrand(id);
		return ResponseEntity.noContent().build();
	}
}
