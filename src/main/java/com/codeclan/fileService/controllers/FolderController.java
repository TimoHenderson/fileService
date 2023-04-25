package com.codeclan.fileService.controllers;

import com.codeclan.fileService.models.Folder;
import com.codeclan.fileService.repositories.FolderRepository;
import com.codeclan.fileService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/folders")
    public ResponseEntity<List<Folder>> getAllFolders() {
        return new ResponseEntity(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/folders/{id}")
    public ResponseEntity<Optional<Folder>> getFolderById(@PathVariable Long id) {
        return new ResponseEntity(folderRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/folders")
    public ResponseEntity saveFolder(@RequestBody Folder folder) {
        folder.setUser(userRepository.findById(folder.getUser().getId()).get());
        folderRepository.save(folder);
        return new ResponseEntity(folder, HttpStatus.CREATED);
    }
}
