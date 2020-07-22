package com.dineshtech.multiplex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dineshtech.multiplex.dto.CinemaDTO;
import com.dineshtech.multiplex.dto.CinemaListDTO;
import com.dineshtech.multiplex.exception.DateFormatException;
import com.dineshtech.multiplex.exception.RequiredFieldsMissingException;
import com.dineshtech.multiplex.exception.ResourceNotFoundException;
import com.dineshtech.multiplex.model.Cinema;
import com.dineshtech.multiplex.repository.CinemaRepository;
import com.dineshtech.multiplex.simplevalidation.SimpleValidator;

@Service
public class CinemaServiceImpl implements CinemaService {

	@Autowired
	private CinemaRepository cinemaRepository;

	@Autowired
	private SimpleValidator simpleValidator;

	@Override
	public CinemaDTO addCinema(CinemaDTO cinemaDTO) throws RequiredFieldsMissingException, DateFormatException {

		simpleValidator.validateDTO(cinemaDTO);

		Cinema cinema = new Cinema();
		CinemaDTO cinemaResDTO = new CinemaDTO();
		BeanUtils.copyProperties(cinemaDTO, cinema);
		cinema = cinemaRepository.save(cinema);
		BeanUtils.copyProperties(cinema, cinemaResDTO);
		return cinemaResDTO;
	}

	@Override
	public CinemaDTO updateCinema(CinemaDTO cinemaDTO)
			throws RequiredFieldsMissingException, DateFormatException, ResourceNotFoundException {

		simpleValidator.validateDTOForUpdate(cinemaDTO);

		Cinema cinemaRes = new Cinema();

		try {
			cinemaRes = cinemaRepository.findById(cinemaDTO.getMovieId()).get();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Movie not found with the Id: " + cinemaDTO.getMovieId());
		}

		CinemaDTO cinemaResDTO = new CinemaDTO();
		BeanUtils.copyProperties(cinemaDTO, cinemaRes);
		cinemaRes = cinemaRepository.save(cinemaRes);
		BeanUtils.copyProperties(cinemaRes, cinemaResDTO);
		return cinemaResDTO;
	}

	@Override
	public CinemaDTO getCinemaById(Long cinemaId) throws ResourceNotFoundException {

		Cinema cinemaRes = new Cinema();

		try {
			cinemaRes = cinemaRepository.findById(cinemaId).get();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Movie not found with the Id: " + cinemaId);
		}

		CinemaDTO cinemaResDTO = new CinemaDTO();
		BeanUtils.copyProperties(cinemaRes, cinemaResDTO);
		return cinemaResDTO;
	}

	@Override
	public CinemaDTO getCinemaByName(String cinemaName) throws ResourceNotFoundException {

		Cinema cinemaRes = new Cinema();

		try {
			cinemaRes = cinemaRepository.findByMovieName(cinemaName);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Movie not found with the name: " + cinemaName);
		}

		CinemaDTO cinemaResDTO = new CinemaDTO();
		BeanUtils.copyProperties(cinemaRes, cinemaResDTO);
		return cinemaResDTO;
	}

	@Override
	public CinemaListDTO getAllCinemas() {

		List<Cinema> cinemaListRes = cinemaRepository.findAll();
		CinemaListDTO cinemaListDTO = new CinemaListDTO();
		List<CinemaDTO> cinemaDTOs = new ArrayList<>();

		cinemaListRes.forEach(cinema -> {

			CinemaDTO cinemaDTOTemp = new CinemaDTO();
			BeanUtils.copyProperties(cinema, cinemaDTOTemp);
			cinemaDTOs.add(cinemaDTOTemp);

		});
		cinemaListDTO.setCinemaListDTO(cinemaDTOs);
		return cinemaListDTO;
	}

	@Override
	public void deleteCinemaById(Long cinemaId) throws ResourceNotFoundException {

		try {
			cinemaRepository.deleteById(cinemaId);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Movie not found with the Id: " + cinemaId);
		}

	}

	@Override
	public void deleteAllCinemas() {
		cinemaRepository.deleteAll();
	}

}
