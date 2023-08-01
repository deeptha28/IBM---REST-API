package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Stream;
import com.example.demo.repo.StreamRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StreamServiceImpl implements StreamService {

	private final StreamRepository streamRepository;

	@Override
	public Stream createStream(Stream stream) {
		// TODO Auto-generated method stub
		return streamRepository.save(stream);
	}

	@Override
	public Optional<Stream> findStream(String id) {
		// TODO Auto-generated method stub
		return streamRepository.findById(id);
	}

	@Override
	public List<Stream> getAllStream() {
		// TODO Auto-generated method stub
		return streamRepository.findAll();
	}

}