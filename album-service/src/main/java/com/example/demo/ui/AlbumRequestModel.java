package com.example.demo.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AlbumRequestModel {
	private String userId;
	private String name;
	private String description;
}