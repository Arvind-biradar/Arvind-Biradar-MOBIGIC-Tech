package com.mobigic.services;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.mobigic.entities.Filedata;
import com.mobigic.payloads.FileDataDto;

public interface FileUploadService {

	
	List<Filedata> getAllListByUser(int id);
	void deleteByFileId(int id);
	
	
	void savefile(FileDataDto dto);
	String store(MultipartFile file);

	
}
