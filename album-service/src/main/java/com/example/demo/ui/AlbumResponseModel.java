package com.example.demo.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlbumResponseModel {
	
	private String albumId;
	private String userId;
	private String name;
	private String description;
}