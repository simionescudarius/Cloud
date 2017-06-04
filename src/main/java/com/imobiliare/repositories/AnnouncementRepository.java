package com.imobiliare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.imobiliare.models.Announcement;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
	@Query("select a from Announcement a where a.realEstateId in (select r.id from RealEstate r where r.typeId = "
			+ "(select t.id from RealEstateType t where t.name = :type))")
	List<Announcement> getByRealEstateType(@Param("type") String type);
}
