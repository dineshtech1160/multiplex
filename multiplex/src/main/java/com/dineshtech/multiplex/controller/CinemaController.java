package com.dineshtech.multiplex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dineshtech.multiplex.dto.CinemaDTO;
import com.dineshtech.multiplex.dto.CinemaListDTO;
import com.dineshtech.multiplex.exception.DateFormatException;
import com.dineshtech.multiplex.exception.RequiredFieldsMissingException;
import com.dineshtech.multiplex.exception.ResourceNotFoundException;
import com.dineshtech.multiplex.service.CinemaService;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

	@Autowired
	private CinemaService cinemaService;

	@GetMapping("/")
	public String defCinemaService() {
		return "Welcome SpringBoot : Multiplex Service";
	}

	@PostMapping("/addCinema")
	public ResponseEntity<CinemaDTO> addCinema(@RequestBody CinemaDTO cinemaDTO)
			throws RequiredFieldsMissingException, DateFormatException {
		return new ResponseEntity<CinemaDTO>(cinemaService.addCinema(cinemaDTO), HttpStatus.CREATED);
	}

	@PutMapping("/updateCinema")
	public ResponseEntity<CinemaDTO> updateCinema(@RequestBody CinemaDTO cinemaDTO)
			throws RequiredFieldsMissingException, DateFormatException, ResourceNotFoundException {
		return new ResponseEntity<CinemaDTO>(cinemaService.updateCinema(cinemaDTO), HttpStatus.OK);
	}

	@GetMapping("/getCinemaById/{cinemaId}")
	public ResponseEntity<CinemaDTO> getCinemaById(@PathVariable("cinemaId") Long cinemaId)
			throws ResourceNotFoundException {
		return new ResponseEntity<CinemaDTO>(cinemaService.getCinemaById(cinemaId), HttpStatus.OK);
	}

	@GetMapping("/getCinemaByName/{cinemaName}")
	public ResponseEntity<CinemaDTO> getCinemaByName(@PathVariable("cinemaName") String cinemaName)
			throws ResourceNotFoundException {
		return new ResponseEntity<CinemaDTO>(cinemaService.getCinemaByName(cinemaName), HttpStatus.OK);
	}

	@GetMapping("/getAllCinemas")
	public ResponseEntity<CinemaListDTO> getAllCinemas() {
		return new ResponseEntity<CinemaListDTO>(cinemaService.getAllCinemas(), HttpStatus.OK);
	}

	@DeleteMapping("/deleteCinemaById/{cinemaId}")
	public ResponseEntity<Void> deleteCinemaById(@PathVariable("cinemaId") Long cinemaId)
			throws ResourceNotFoundException {
		cinemaService.deleteCinemaById(cinemaId);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/deleteAllCinemas")
	public ResponseEntity<Void> deleteAllCinemas() {
		cinemaService.deleteAllCinemas();
		return ResponseEntity.noContent().build();
	}

}
