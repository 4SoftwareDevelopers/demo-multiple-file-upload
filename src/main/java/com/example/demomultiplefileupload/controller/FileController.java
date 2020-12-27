package com.example.demomultiplefileupload.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demomultiplefileupload.service.FileServiceAPI;

@RestController
@RequestMapping("/files")
public class FileController {
	
	@Autowired
	private FileServiceAPI fileServiceAPI;
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFiles(@RequestParam("files") List<MultipartFile> files) {
		try {
			fileServiceAPI.save(files);
			return ResponseEntity.status(HttpStatus.OK).body("Los archivos fueron cargados correctamente al servidor");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrio un error al subir el archivo");
		}
	}

}
