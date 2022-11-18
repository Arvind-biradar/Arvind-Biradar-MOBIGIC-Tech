package com.mobigic.utils;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	List<String> loadAll();
	String store(MultipartFile file);
	void delete(String fileName);
}
