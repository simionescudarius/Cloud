package com.imobiliare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.imobiliare.models.Meeting;
import com.imobiliare.models.User;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
	@Modifying
	@Query("update Meeting m set m.accepted = 1 where m.id = :id")
	void acceptMeeting(@Param("id") Long id);

	List<Meeting> findAllByUser1(User user1);
}
