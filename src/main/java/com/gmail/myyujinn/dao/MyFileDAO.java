package com.gmail.myyujinn.dao;

import com.gmail.myyujinn.model.MyFile;

import java.util.List;

public interface MyFileDAO {
    List<MyFile> list();

    void add(MyFile myFile);

}
