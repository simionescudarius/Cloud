package com.imobiliare.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.imobiliare.models.Announcement;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
	@Query("select a from Announcement a where a.realEstateId in (select r.id from RealEstate r where r.typeId = "
			+ "(select t.id from RealEstateType t where t.name = :type))")
	List<Announcement> getByRealEstateType(@Param("type") String type);
	
	@Query("select a from Announcement a where a.realEstateId in (select r.id from RealEstate r "
			+ "where r.roomNumber = :roomNumber and r.typeId = (select t.id from RealEstateType t where t.name = :type))")
	List<Announcement> getByRealEstateRoomNumberAndType(@Param("roomNumber") int roomNumber, @Param("type") String type);
	
	List<Announcement> findAllByOrderByPostDateAsc();
		
	@Query(value="select a from Announcement a")
	Page<Announcement> mostPopular(Pageable pageable);
	
	@Modifying
	@Query("update Announcement a set a.viewNumber = a.viewNumber+1 where a.id = :id")
	void incViewNumber(@Param("id") long id);
			
}
