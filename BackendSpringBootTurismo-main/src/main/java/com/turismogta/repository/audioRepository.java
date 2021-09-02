package com.turismogta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.turismogta.entity.audio;

@Repository
public interface audioRepository extends JpaRepository<audio, Integer> {

	/*@Query(value = "select * from audio where id_audio =(select id_audio from atractivo where id_atractivo=?1) ", nativeQuery = true)
	boolean existsByIdAtractivo(int idAtractivo);*/
	
	@Query(value = "select * from audio where id_audio =(select id_audio from atractivo where id_atractivo=?1) ", nativeQuery = true)
	Optional<audio> findByIdAudio(int idAtractivo);
}
