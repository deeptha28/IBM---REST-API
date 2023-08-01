package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Stream;
import com.example.demo.service.StreamService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/streams")
@AllArgsConstructor
public class StreamController {

	private final StreamService streamService;
	@GetMapping("/status")
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.status(HttpStatus.OK).body("status ok");
	}
	@PostMapping
	public ResponseEntity<Stream> createStream(@RequestBody Stream stream)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(streamService.createStream(stream));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id)
	{
		return ResponseEntity.ok(streamService.findStream(id));
	}
	@GetMapping
	public ResponseEntity<?> getAllStreams()
	{
		return ResponseEntity.ok(streamService.getAllStream());
	}
}