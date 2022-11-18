package com.mobigic.ServiceImplement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.NonUniqueSessionRepositoryException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mobigic.entities.Filedata;
import com.mobigic.entities.User;
import com.mobigic.payloads.FileDataDto;
import com.mobigic.repositories.FileStorage;
import com.mobigic.repositories.UserRepo;
import com.mobigic.services.FileUploadService;
import com.mobigic.services.UserService1;
import com.mobigic.utils.FileUploadProperties;

@Service
public class FileUploadImp implements FileUploadService {
  int code=124535;
  @Autowired
  private UserService1 uservice;
  @Autowired
  private UserRepo userrepo; 
  @Autowired
  private FileStorage filestore;
	@Override
	public List<Filedata> getAllListByUser(int id) {
		System.out.println(userrepo.getReferenceById(id));
	return filestore.findByUser(userrepo.getReferenceById(id));
	
	}

	@Override
	public void deleteByFileId(int id) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void savefile(FileDataDto dto) {
//		
//		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
//		System.out.println(dto.getFile().getOriginalFilename());
//		System.out.println(dto.getUserid());
//		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");

//		Filedata file=new Filedata();
//		 InputStream is;
//		 byte[] data;
//	try{
//			is = (dto.getFile()).getInputStream();
//			data = new byte[is.available()];
//			is.read(data);
//			
//			System.out.println(dto.getFile().getOriginalFilename());
//			
//			System.out.println(uservice.findById(dto.getUserid()));
//			System.out.println(Arrays.toString(data));
			
//						
//		   } catch (IOException e) {
//		     	e.printStackTrace();
//		}			
//		
//	}
	
	
	@Override
	public void savefile(FileDataDto dto) {

		
		
		
		
		Filedata file=new Filedata();
		String filedata=this.store(dto.getFile());
		System.out.println(userrepo.getReferenceById(dto.getUserid()));
//		System.out.println(filedata);
		System.out.println("AAAAAAAAAAAAA");
		file.setFilename((dto.getFile()).getOriginalFilename());
		file.setUnicode(code++);
		file.setData(filedata);
		
		file.setUser(userrepo.getReferenceById(dto.getUserid()));
		filestore.save(file);

	
	}

@Override
public String store(MultipartFile file) {
	
	String ext=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
	System.out.println(ext);
	String fileName = UUID.randomUUID().toString().replaceAll("-", "")+ext;
	File filePath = new File(BASEPATH, fileName);
	try(FileOutputStream out = new FileOutputStream(filePath)) {
		FileCopyUtils.copy(file.getInputStream(), out);
		return fileName;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}




private String BASEPATH;

public FileUploadImp(FileUploadProperties fileUploadProperties) 
{
	this.BASEPATH=Paths.get(fileUploadProperties.getLocation())
			.toAbsolutePath()
			.normalize().toString();
}


//@Override
//public List<String> loadAll() {
//	File dirPath = new File(BASEPATH);
//	return Arrays.asList(dirPath.list());
//}



//@Override
//public Resource load(String fileName) {
//	File filePath = new File(BASEPATH, fileName);
//	if(filePath.exists())
//		return new FileSystemResource(filePath);
//	return null;
//}


//@Override
//public void delete(String fileName) {
//	File filePath = new File(BASEPATH, fileName);
//	if(filePath.exists())
//		filePath.delete();
//}






	
}
