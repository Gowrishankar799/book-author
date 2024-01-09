package com.example.Bookauthor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Servicelayer {
    @Autowired
    private Repo repo;
    public String addBook(Book book){
        return repo.addBook(book);
    }
    public String addAuthor(Author author){
        return repo.addAuthor(author);
    }
    public List<Author> listofAuthors(int age, float rating){
        return repo.listofAuthors(age,rating);
    }
    public String updateBook(Book book, int pages){
        return repo.updateBook(book,pages);
    }
    public List<Book> listofBooks(int x){
        return repo.listofBooks(x);
    }

}
