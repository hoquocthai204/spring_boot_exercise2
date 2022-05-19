package net.sparkminds.user.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sparkminds.user.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
