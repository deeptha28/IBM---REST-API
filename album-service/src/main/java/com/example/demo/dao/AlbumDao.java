package com.example.demo.dao;

import java.util.List;

import com.example.demo.dto.AlbumDto;
import com.example.demo.model.AlbumEntity;

public interface AlbumDao {
	
	public AlbumEntity saveAlbum(AlbumDto albumDto);
	
	public List<AlbumEntity> getAllAlbum();
}
