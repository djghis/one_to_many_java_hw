package com.codeclan.example.oneToMAny.components;
import com.codeclan.example.oneToMAny.models.Folder;
import com.codeclan.example.oneToMAny.models.User;

import com.codeclan.example.oneToMAny.repositories.FolderRepository;
import com.codeclan.example.oneToMAny.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User jean = new User("Jean");
        userRepository.save(jean);

        User gg = new User("GG");
        userRepository.save(gg);

        Folder folder1 = new Folder("accounts", gg);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("shipments", jean);
        folderRepository.save(folder2);

        Folder folder3 = new Folder("Paid", gg);
        folderRepository.save(folder3);


    }
}
