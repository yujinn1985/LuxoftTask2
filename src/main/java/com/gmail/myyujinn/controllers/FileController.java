package com.gmail.myyujinn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gmail.myyujinn.services.FileService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/")
    public String listFiles(Model model) {
        model.addAttribute("files", fileService.listFiles());
        return "index";
    }

    @RequestMapping("/select")
    public String listLines(Model model,
                            @RequestParam(required = false, defaultValue = "all") String file,
                            @RequestParam(required = false, defaultValue = "false") String filter) {
        switch (filter) {
            case "false": {
                if (file.equals("all")) {
                    model.addAttribute("lines", fileService.listLines());
                } else {
                    long num = Long.parseLong(file);
                    model.addAttribute("lines", fileService.listLinesFromFile(num));
                }
                break;
            }
            case "true": {
                model.addAttribute("lines", fileService.listOfFilteredFiles());
                return "filter";
            }
        }

        return "select";
    }
}
