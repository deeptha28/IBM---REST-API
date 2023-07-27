package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.AlbumDao;
import com.example.demo.dto.AlbumDto;
import com.example.demo.model.AlbumEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService{

	private final AlbumDao albumDao;
	

	@Override
	public AlbumEntity saveAlbum(AlbumDto albumDto) {
		return albumDao.saveAlbum(albumDto);
	}

	@Override
	public List<AlbumEntity> getAllAlbum() {
		// TODO Auto-generated method stub
		return albumDao.getAllAlbum();
	}

}