package com.in.cafe.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.in.cafe.POJO.Bill;

public interface BillService {
	ResponseEntity<String> getGenerateReport(Map<String, Object> requestMap);
	ResponseEntity<List<Bill>> getBills();
	ResponseEntity<byte[]>getpdf(Map<String, Object> requestMap);
}
