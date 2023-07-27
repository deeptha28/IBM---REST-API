package com.example.demo.dao;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.dto.AlbumDto;
import com.example.demo.model.AlbumEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository

public class AlbumDaoImpl implements AlbumDao {
	
	
	private final EntityManager entityManager;
	private final ModelMapper modelMapper;

	public AlbumDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
		this.modelMapper = new ModelMapper();
	}

	@Override
	@Transactional
	public AlbumEntity saveAlbum(AlbumDto albumDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AlbumEntity albumEntity = modelMapper.map(albumDto, AlbumEntity.class);
		entityManager.persist(albumEntity);
		return albumEntity;
	}

	@Override
	@Transactional
	public List<AlbumEntity> getAllAlbum() {
		TypedQuery<AlbumEntity> query = entityManager.createQuery("FROM AlbumEntity A",AlbumEntity.class);
		return query.getResultList();
	}

}
