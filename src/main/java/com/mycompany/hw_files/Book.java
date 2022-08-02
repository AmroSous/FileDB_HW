/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw_files;

/**
 *
 * @author lenovo
 */
public class Book {
    private String name;
    private String iSBN;
    private int edition;
    private String author;
    private String topic;
    private int publishedYear;

    public Book(String name, String iSBN, int edition, String author, String topic, int publishedYear) {
        this.name = name;
        this.iSBN = iSBN;
        this.edition = edition;
        this.author = author;
        this.topic = topic;
        this.publishedYear = publishedYear;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public String getiSBN() {
        return iSBN;
    }

    public int getEdition() {
        return edition;
    }

    public String getAuthor() {
        return author;
    }

    public String getTopic() {
        return topic;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
    
    @Override
    public String toString() {
        return name + "," + iSBN + "," + edition + "," + author + "," + topic + "," + publishedYear + "\n";
    }
    
    public static Book readBook(String line){
        Book book = new Book();
        String[] attributes = new String[6];
        attributes = line.split(",");
        if(attributes[5] == null) return null;
        book.setName(attributes[0]);
        book.setiSBN(attributes[1]);
        try{book.setEdition(Integer.parseInt(attributes[2]));}
        catch(NumberFormatException nfe){return null;}
        book.setAuthor(attributes[3]);
        book.setTopic(attributes[4]);
        try{book.setPublishedYear(Integer.parseInt(attributes[5]));}
        catch(NumberFormatException nfe){return null;}
        return book;
    }
}
