package net.sparkminds.user.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.user.dto.BrandDTO;
import net.sparkminds.user.entity.Brand;
import net.sparkminds.user.reponsitory.BrandRepository;
import net.sparkminds.user.service.BrandService;
import net.sparkminds.user.service.HistoryService;

@Service
@Transactional(readOnly = true)
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private HistoryService historyService;

	@Override
	public List<Brand> getAllBrand() {
		return brandRepository.findAll();
	}

	@Override
	@Transactional
	public Brand createBrand(BrandDTO brandDTO) {
		Brand brand = new Brand();
		brand.setName(brandDTO.getName());
		brand.setDescription(brandDTO.getDescription());
		return brandRepository.save(brand);
	}

	@Override
	@Transactional
	public void updateBrand(BrandDTO brandDTO, Long id) {
		Brand brand = brandRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Brand is not exist"));
		brand.setName(brandDTO.getName());
		brand.setDescription(brandDTO.getDescription());
		
//		historyService.createBrandHistory(brandDTO, brand);
	}

	@Override
	@Transactional
	public void deleteBrand(Long id) {
		brandRepository.deleteById(id);
	}

}
