package com.gmail.myyujinn.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "statistics")
public class MyLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stat_num")
    private long id;

    @Column(name = "line_length")
    private long lineLength;

    @Column(name = "longest_word")
    private String longestWord;

    @Column(name = "shortest_word")
    private String shortestWord;

    @Column(name = "averaging_length")
    private Double averagingLength;

    @ManyToOne
    @JoinColumn(name = "file")
    private MyFile myFile;

    @Transient
    private String stringOfText;

    public MyLine(MyFile myFile, String stringOfText) {
        this.stringOfText = stringOfText;
        this.lineLength = initializeLineLength();
        this.longestWord = initializeLongestWord();
        this.shortestWord = initializeShortestWord();
        this.averagingLength = initializeAveragingLength();
        this.myFile = myFile;
    }

    public MyLine() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLineLength() {
        return lineLength;
    }

    public void setLineLength(long lineLength) {
        this.lineLength = lineLength;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public void setLongestWord(String longestWord) {
        this.longestWord = longestWord;
    }

    public String getShortestWord() {
        return shortestWord;
    }

    public void setShortestWord(String shortestWord) {
        this.shortestWord = shortestWord;
    }

    public Double getAveragingLength() {
        return averagingLength;
    }

    public void setAveragingLength(Double averagingLength) {
        this.averagingLength = averagingLength;
    }

    public MyFile getMyFile() {
        return myFile;
    }

    public void setMyFile(MyFile myFile) {
        this.myFile = myFile;
    }

    public String getStringOfText() {
        return stringOfText;
    }

    public void setStringOfText(String stringOfText) {
        this.stringOfText = stringOfText;
    }

    protected final String initializeLongestWord() {
        List<String> list = Arrays.stream(this.stringOfText.split(" "))
                .filter(a -> a.length() > 0)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toCollection(ArrayList::new));
        return list.get(list.size() - 1);
    }

    protected final String initializeShortestWord() {
        return Arrays.stream(this.stringOfText.split(" "))
                .filter(a -> a.length() > 0)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toCollection(ArrayList::new))
                .get(0);
    }

    protected final double initializeAveragingLength() {
        return Arrays.stream(this.stringOfText.split(" "))
                .collect(Collectors.averagingInt(String::length));
    }

    protected final int initializeLineLength() {
        return this.stringOfText.length();
    }

    @Override
    public String toString() {
        return "MyLine{" +
                "id=" + id +
                ", lineLength=" + lineLength +
                ", longestWord=" + longestWord +
                ", shortestWord=" + shortestWord +
                ", averagingLength=" + averagingLength +
                ", myFile=" + myFile +
                '}';
    }
}
