package com.gmail.myyujinn.services;

import com.gmail.myyujinn.dao.MyLineDAO;
import com.gmail.myyujinn.model.MyFile;
import com.gmail.myyujinn.model.MyLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gmail.myyujinn.dao.MyFileDAO;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private MyFileDAO myFileDAO;

    @Autowired
    private MyLineDAO myLineDAO;

    @Transactional
    public void addFile(MyFile myFile) {
        myFileDAO.add(myFile);
    }

    @Transactional(readOnly = true)
    public List<MyFile> listFiles() {
        return myFileDAO.list();
    }

    @Transactional(readOnly = true)
    public List<MyLine> listOfFilteredFiles() {
        return myLineDAO.listOfFilteredFiles();
    }

    @Transactional(readOnly = true)
    public List<MyLine> listLines() {
        return myLineDAO.list();
    }

    @Transactional(readOnly = true)
    public List<MyLine> listLinesFromFile(long num) {
        return myLineDAO.listLinesFromFile(num);
    }
}
