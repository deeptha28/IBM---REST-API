package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Subtask;


public interface SubtaskDAO 
{

	public void updateProgress(Long subtaskId, Long progressPercentage, String comment);

}