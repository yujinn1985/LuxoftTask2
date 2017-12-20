package com.gmail.myyujinn.services;

import com.gmail.myyujinn.model.MyFile;
import com.gmail.myyujinn.model.MyLine;

import java.util.List;

public interface FileService {

    void addFile(MyFile myFile);

    List<MyFile> listFiles();

    List<MyLine> listLines();

    List<MyLine> listLinesFromFile(long num);

    List<MyLine> listOfFilteredFiles();

}
