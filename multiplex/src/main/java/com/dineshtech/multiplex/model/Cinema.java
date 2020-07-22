package com.dineshtech.multiplex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "multplx_cinema")
public class Cinema {

	@Id
	@GeneratedValue
	@Column(name = "movie_id")
	private Long movieId;

	@Column(name = "movie_name")
	private String movieName;

	@Column(name = "movie_genre")
	private String movieGenre;

	@Column(name = "producer")
	private String producer;

	@Column(name = "director")
	private String director;

	@Column(name = "released_date")
	private String releasedDate;

}
