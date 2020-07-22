package com.dineshtech.multiplex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CinemaDTO {

	private Long movieId;

	private String movieName;

	private String movieGenre;

	private String producer;

	private String director;

	private String releasedDate;

}
