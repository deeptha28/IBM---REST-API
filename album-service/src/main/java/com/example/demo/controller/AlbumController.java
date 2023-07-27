package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AlbumDto;
import com.example.demo.model.AlbumEntity;
import com.example.demo.service.AlbumService;
import com.example.demo.ui.AlbumRequestModel;
import com.example.demo.ui.AlbumResponseModel;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("album")
public class AlbumController {

	private final ModelMapper modelMapper;
	private final AlbumService albumService;
	
	@PostMapping
	public ResponseEntity<AlbumResposneModel> saveAlbum(@RequestBody AlbumRequestModel albumRequestModel)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AlbumDto albumDto = modelMapper.map(albumRequestModel, AlbumDto.class);
		albumDto.setAlbumId(UUID.randomUUID().toString());
		albumDto.setUserId(UUID.randomUUID().toString());
		AlbumEntity albumEntity = albumService.saveAlbum(albumDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(albumEntity, AlbumResponseModel.class));
	}
	
	@GetMapping
	public ResponseEntity<List<AlbumResponseModel>> getAllAlbums()
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<AlbumEntity> list = albumService.getAllAlbum();
		List<AlbumResponseModel> albumResponseModels = new ArrayList<AlbumResponseModel>();
		for(AlbumEntity a : list)
		{
			albumResponseModels.add(modelMapper.map(a, AlbumResponseModel.class));
		}		
			return ResponseEntity.status(HttpStatus.OK).body(albumResponseModels);
	}
}