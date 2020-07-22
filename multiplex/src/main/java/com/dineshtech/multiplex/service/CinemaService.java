package com.dineshtech.multiplex.service;

import com.dineshtech.multiplex.dto.CinemaDTO;
import com.dineshtech.multiplex.dto.CinemaListDTO;
import com.dineshtech.multiplex.exception.DateFormatException;
import com.dineshtech.multiplex.exception.RequiredFieldsMissingException;
import com.dineshtech.multiplex.exception.ResourceNotFoundException;

public interface CinemaService {

	CinemaDTO addCinema(CinemaDTO cinemaDTO) throws RequiredFieldsMissingException, DateFormatException;

	CinemaDTO updateCinema(CinemaDTO cinemaDTO)
			throws RequiredFieldsMissingException, DateFormatException, ResourceNotFoundException;

	CinemaDTO getCinemaById(Long cinemaId) throws ResourceNotFoundException;

	CinemaDTO getCinemaByName(String cinemaName) throws ResourceNotFoundException;

	CinemaListDTO getAllCinemas();

	void deleteCinemaById(Long cinemaId) throws ResourceNotFoundException;

	void deleteAllCinemas();

}
