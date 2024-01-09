package com.example.Bookauthor;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class Repo {
    HashMap<String,Book> bookHashMap = new HashMap<>();
    HashMap<String,Author> authorHashMap = new HashMap<>();
    public String addBook(Book book){
        if(bookHashMap.containsKey(book.getBookName())){
            return "already present in the bookhashmap";
        }
        bookHashMap.put(book.getBookName(),book);
        return "Book is added to HashMap";
    }
    public String addAuthor(Author author){
        if(authorHashMap.containsKey(author.getName())){
            return "already present in the Authorhashmap";
        }
        authorHashMap.put(author.getName(),author);
        return "Author is added to HashMap";
    }
    public List<Author> listofAuthors(int age, float rating){
        List<Author> list = new ArrayList<>();
        for(Author au : authorHashMap.values()){
            if(age<au.getAge()&&rating>au.getRating()){
                list.add(au);
            }
        }
        return list;
    }
    public String updateBook(Book book, int pages){
        String s = book.getBookName();
        Book b = bookHashMap.get(s);
        b.setPages(pages);
        bookHashMap.remove(s);
        bookHashMap.put(s,b);
        return "Book is updated sucussefully ";
    }
    public List<Book> listofBooks(int x){
        List<Book> list = new ArrayList<>();
        for(Book b : bookHashMap.values()){
            String s = b.getAuthorName();
            Author a = authorHashMap.get(s);
            if(a.getRating()>x){
                list.add(b);
            }
        }
        return list;
    }

}
