package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AlbumDto;
import com.example.demo.model.AlbumEntity;

@Service
public interface AlbumService {
	
	public AlbumEntity saveAlbum(AlbumDto albumDto);
	
	public List<AlbumEntity> getAllAlbum();
	
}