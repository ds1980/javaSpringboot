package com.in.cafe.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.in.cafe.service.FileService;
import java.nio.file.Files;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
			
		// File Name
		String name = file.getOriginalFilename();
		//abc.png
		
		// random name generate file
		String randomID = UUID.randomUUID().toString();
		String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));
		
		//Full Path
		String filepath = path+File.separator+fileName1;
		
		// create folder If not created 
		File f = new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		
		// file copy
		Files.copy(file.getInputStream(), Paths.get(filepath));
		// TODO Auto-generated method stub
		return fileName1;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath = path + File.separator + fileName;
		// TODO Auto-generated method stub
		InputStream is = new FileInputStream(fullPath);
		return is;
	}

}
