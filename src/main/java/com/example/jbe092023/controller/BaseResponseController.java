package com.example.jbe092023.controller;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseResponseController {
	public static ResponseEntity<Object> success(Object data) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", "success");
		map.put("message", "success");
		map.put("data", data);
		map.put("time", OffsetDateTime.now());
		
		if (data instanceof Collection) {
			map.put("size", ((Collection<?>) data).size());
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	public static ResponseEntity<Object> fail(String code, String message) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", code);
		map.put("message", message);
		map.put("time", OffsetDateTime.now());

		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
