package com.gmail.myyujinn.model;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "file_statistics")
public class MyFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_num")
    private long id;

    @Column(name = "total_lines")
    private long totalLines;

    @Column(name = "total_words")
    private long totalWords;

    @OneToMany(mappedBy = "myFile", cascade = CascadeType.ALL)
    private List<MyLine> list = new ArrayList<>();

    public MyFile(String pathToFile) {
        super();
        this.list = initializeListOfLines(pathToFile);
        this.totalLines = list.size();
        this.totalWords = list.stream().flatMap(a -> Arrays.stream(a.getStringOfText().split(" ")))
                .filter(b -> b.length() > 0)
                .count();
    }

    public MyFile(long totalLines, long totalWords, List<MyLine> list) {
        this.totalLines = totalLines;
        this.totalWords = totalWords;
        this.list = list;
    }

    public MyFile() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTotalLines() {
        return totalLines;
    }

    public void setTotalLines(long totalLines) {
        this.totalLines = totalLines;
    }

    public long getTotalWords() {
        return totalWords;
    }

    public void setTotalWords(long totalWords) {
        this.totalWords = totalWords;
    }

    public List<MyLine> getList() {
        return list;
    }

    public void setList(List<MyLine> list) {
        this.list = list;
    }

    protected final List<MyLine> initializeListOfLines(String path) {
        List<MyLine> listOfLines = new ArrayList<>();
        try (BufferedReader bfr = new BufferedReader(new FileReader(new File(path)))) {
            while (true) {
                String str = bfr.readLine();
                if (str == null) {
                    break;
                } else if (str.length() == 0 || !stringCheck(str)) {
                    continue;
                }
                MyLine stringOfText = new MyLine(this, str);
                listOfLines.add(stringOfText);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfLines;
    }

    private boolean stringCheck(String string) {
        char[] charArray = new char[string.length()];
        string.getChars(0, string.length(), charArray, 0);
        for (char ch : charArray) {
            if (ch != ' ') {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "id=" + id +
                ", totalLines=" + totalLines +
                ", totalWords=" + totalWords +
                ", list=" + list +
                '}';
    }
}
