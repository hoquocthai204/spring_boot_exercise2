package net.sparkminds.user.reponsitory;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sparkminds.user.entity.Subscriber;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

	List<Subscriber> findByCreatedDate(Date createdDate);

	List<Subscriber> findBySex(String sex);

	List<Subscriber> findByBirthday(Date birthday);
}
