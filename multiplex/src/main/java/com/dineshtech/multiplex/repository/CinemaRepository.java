package com.dineshtech.multiplex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dineshtech.multiplex.model.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

	Cinema findByMovieName(String string);

}
