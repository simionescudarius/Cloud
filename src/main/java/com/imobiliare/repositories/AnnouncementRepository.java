package com.imobiliare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imobiliare.models.Announcement;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long>{
}
