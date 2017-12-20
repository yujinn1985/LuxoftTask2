package com.gmail.myyujinn.config;

import com.gmail.myyujinn.model.MyFile;
import com.gmail.myyujinn.services.FileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(FileService fileService) {
        return (String[] a) -> process("src/main/resources/New Folder", fileService);
    }

    private void process(String path, FileService fileService) {
        List<String> list = new ArrayList<>();
        List<String> pathsList = getListOfPaths(path, list);
        if (pathsList.size() != 0) {
            int threadNumber = (pathsList.size() < 10) ? pathsList.size() : 10;
            ExecutorService es = Executors.newFixedThreadPool(threadNumber);
            for (String filePath : pathsList) {
                es.submit(() -> fileService.addFile(new MyFile(filePath)));
            }
            es.shutdown();
        }
    }

    private List<String> getListOfPaths(String path, List<String> pathsList) {
        File file = new File(path);
        if (file.isFile()) {
            pathsList.add(file.getPath());
        } else {
            File[] files = file.listFiles();
            if (files != null) {
                for (File fileVar : files) {
                    this.getListOfPaths(fileVar.getPath(), pathsList);
                }
            }
        }
        return pathsList;
    }
}


