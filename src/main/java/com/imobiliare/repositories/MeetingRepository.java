package com.imobiliare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imobiliare.models.Meeting;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long>{
}
