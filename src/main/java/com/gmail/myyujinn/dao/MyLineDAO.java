package com.gmail.myyujinn.dao;

import com.gmail.myyujinn.model.MyLine;

import java.util.List;

public interface MyLineDAO {
    List<MyLine> list();

    List<MyLine> listLinesFromFile(long num);

    List<MyLine> listOfFilteredFiles();
}
