/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw_files;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 *
 * @author lenovo
 */
public class LibrarySystem {
    private ArrayList<Book> books;
    private int searchedIndex;
    private final String fileName = "bookFile.txt";
    private final File booksFile;

    public LibrarySystem() {
        books = new ArrayList<Book>();
        searchedIndex = -1;
        booksFile = new File(fileName);
        try{if(!booksFile.exists())booksFile.createNewFile();}catch(IOException e){JOptionPane.showMessageDialog(
                null,"failed in creating the file .","something went wrong!", JOptionPane.ERROR_MESSAGE);}
    }

    public void resetSearchedIndex() {
        this.searchedIndex = -1;
    }
    
    public void loadBooks(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(booksFile));
            String line = null;
            books.clear();
            while((line = reader.readLine()) != null){
                if(!line.trim().equals("")) books.add(Book.readBook(line));
            }
            reader.close();
        }
        catch(Exception e){JOptionPane.showMessageDialog(
                null,"system failed in loading books from the file .","Something went wrong!", JOptionPane.ERROR_MESSAGE);}
    }
    
    public void saveBooks(){
        try{
            FileWriter writer = new FileWriter(booksFile);
            for(Book book : books)
                writer.append(book.toString());
            writer.close();
        }
        catch(IOException e){JOptionPane.showMessageDialog(
                null,"Something went wrong!","system failed in saving books to the file .", JOptionPane.ERROR_MESSAGE);}
    }
    
    public void saveMethod(Book book){
        loadBooks();
        if(book != null) books.add(book);
        searchedIndex = -1;
        saveBooks();
    }
    
    public boolean deleteBook(){
        if(searchedIndex == -1) return false;
        else {loadBooks(); books.remove(searchedIndex); searchedIndex = -1; saveBooks();}
        return true;
    }
    
    public boolean updateBook(Book newBook){
        if(searchedIndex == -1) return false;
        else{
            loadBooks();
            books.remove(searchedIndex);
            books.add(searchedIndex, newBook);
            searchedIndex = -1;
            saveBooks();
        }
        return true;
    }
    
    public Book searchByName(String name){
        loadBooks();
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).getName().equalsIgnoreCase(name)) {
                searchedIndex = i;
                return books.get(i);
            }
        }
        return null;
    }
    
    public Book searchByISBN(String isbn){
        loadBooks();
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).getiSBN().equals(isbn)) {
                searchedIndex = i;
                return books.get(i);
            }
        }
        return null;
    }
    
    public Book searchByAuthor(String author){
        loadBooks();
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).getAuthor().equalsIgnoreCase(author)) {
                searchedIndex = i;
                return books.get(i);
            }
        }
        return null;
    }
    
    public Book searchByTopic(String topic){
        loadBooks();
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).getTopic().equalsIgnoreCase(topic)) {
                searchedIndex = i;
                return books.get(i);
            }
        }
        return null;
    }
    
    public Book searchByEdition(int edition){
        loadBooks();
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).getEdition() == edition) {
                searchedIndex = i;
                return books.get(i);
            }
        }
        return null;
    }
    
    public Book searchByPublishedYear(int pubYear){
        loadBooks();
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).getPublishedYear() == pubYear) {
                searchedIndex = i;
                return books.get(i);
            }
        }
        return null;
    }
}
