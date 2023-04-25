package com.codeclan.fileService.controllers;

import com.codeclan.fileService.models.File;
import com.codeclan.fileService.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {
    @Autowired
    FileRepository fileRepository;

    @GetMapping("/files")
    public ResponseEntity<List<File>> getAllFiles() {
        return new ResponseEntity(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<Optional<File>> getFileById(@PathVariable Long id) {
        return new ResponseEntity(fileRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/files")
    public ResponseEntity saveFile(@RequestBody File file) {
        fileRepository.save(file);
        Optional<File> savedFile = fileRepository.findById(file.getId());
        return new ResponseEntity(savedFile, HttpStatus.CREATED);
    }
}
