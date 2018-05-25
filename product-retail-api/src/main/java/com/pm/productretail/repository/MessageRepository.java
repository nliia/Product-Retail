package com.pm.productretail.repository;

import com.pm.productretail.entity.AppUser;
import com.pm.productretail.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	List<Message> findAllByRecipientAndSender(AppUser recipient, AppUser sender);

	List<Message> findAllBySenderAndRecipient(AppUser sender, AppUser recipient);
}
