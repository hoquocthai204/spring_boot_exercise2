package net.sparkminds.user.reponsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sparkminds.user.entity.Brand;
import net.sparkminds.user.entity.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

	List<History> findBySubscriber(Long subscriberId);

	Optional<History> findByProfile(Long profileId);

	List<History> findByBrand(Brand brand);

}
