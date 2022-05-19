package net.sparkminds.user.service;

import java.util.List;

import net.sparkminds.user.dto.BrandDTO;
import net.sparkminds.user.entity.Brand;

public interface BrandService {

	List<Brand> getAllBrand();

	Brand createBrand(BrandDTO brandDTO);

	void updateBrand(BrandDTO brandDTO, Long id);

	void deleteBrand(Long id);

}
