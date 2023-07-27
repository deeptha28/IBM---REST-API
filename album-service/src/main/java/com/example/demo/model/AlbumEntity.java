package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="album")
public class AlbumEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String albumId;
	private String userId;
	private String name;
	private String description;
}