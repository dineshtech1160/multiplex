package com.dineshtech.multiplex.simplevalidation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.dineshtech.multiplex.dto.CinemaDTO;
import com.dineshtech.multiplex.exception.DateFormatException;
import com.dineshtech.multiplex.exception.RequiredFieldsMissingException;

@Component
public class SimpleValidator {

	public void validateDTO(CinemaDTO cinemaDTO) throws RequiredFieldsMissingException, DateFormatException {

		if (cinemaDTO.getMovieName().isEmpty() || cinemaDTO.getMovieGenre().isEmpty()
				|| cinemaDTO.getDirector().isEmpty() || cinemaDTO.getProducer().isEmpty()
				|| cinemaDTO.getReleasedDate().isEmpty()) {

			throw new RequiredFieldsMissingException("Please fill all the fields");

		} else {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			try {
				 formatter.parse(cinemaDTO.getReleasedDate());
			} 
			catch (ParseException e) {
				throw new DateFormatException("Please provide released date in this format: dd-MM-yyyy, example: 25-12-2020");
			}
		}

	}

	
	public void validateDTOForUpdate(CinemaDTO cinemaDTO) throws RequiredFieldsMissingException, DateFormatException {

		if (cinemaDTO.getMovieId() != null) {
			validateDTO(cinemaDTO);
		} else {
			throw new RequiredFieldsMissingException("Movie Id is mandatory");
		}

	}

}
