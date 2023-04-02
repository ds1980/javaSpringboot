package com.in.cafe.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface DashboardService {
	ResponseEntity<Map<String, Object>> getCount();
}
