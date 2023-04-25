package com.codeclan.fileService.components;

import com.codeclan.fileService.models.File;
import com.codeclan.fileService.models.Folder;
import com.codeclan.fileService.models.User;
import com.codeclan.fileService.repositories.FileRepository;
import com.codeclan.fileService.repositories.FolderRepository;
import com.codeclan.fileService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FileRepository fileRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User eddie = new User("Eddie");
        userRepository.save(eddie);
        User steve = new User("Steve");
        userRepository.save(steve);

        Folder audioFolder = new Folder("Audio", eddie);
        folderRepository.save(audioFolder);
        Folder docsFolder = new Folder("Docs", steve);
        folderRepository.save(docsFolder);

        File audioFile = new File("drums", "wav", 100, audioFolder);
        fileRepository.save(audioFile);
        File docFile = new File("essay", "docx", 1, docsFolder);
        fileRepository.save(docFile);


    }
}
