package com.pm.productretail.repository;

import com.pm.productretail.entity.AppUser;
import com.pm.productretail.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	List<Message> findAllByRecipient(AppUser recipient);

	List<Message> findAllBySender(AppUser sender);
}
