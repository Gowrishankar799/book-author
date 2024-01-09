package com.example.Bookauthor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Books-Authors")
public class Controller {
    @Autowired
    private Servicelayer ser;
    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestBody Book book){
         String msg = ser.addBook(book);
       // String msg = "Book is add to the Database";
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","add book to the database");
        return new ResponseEntity<>(msg,headers, HttpStatus.OK);
    }
    @PostMapping("/addAuthor")
    public ResponseEntity<String> addAuthor(@RequestBody Author author){
        String msg = ser.addAuthor(author);
        // String msg = "Book is add to the Database";
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","add author to the database");
        return new ResponseEntity<>(msg,headers, HttpStatus.OK);
    }
    @GetMapping("/listofauthors")
    public ResponseEntity<List<Author>> listofAuthors(@RequestParam("age") int age,@RequestParam("rating") float rating){
        List<Author> list = ser.listofAuthors(age,rating);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of authors");
        return new ResponseEntity<>(list,headers, HttpStatus.OK);

    }
    @PutMapping("/updateBook")
    public ResponseEntity<String> updateBook(@RequestBody Book book,@RequestParam("pages") int pages){
        String msg = ser.updateBook(book,pages);
        // String msg = "Book is add to the Database";
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","update book to the database");
        return new ResponseEntity<>(msg,headers, HttpStatus.OK);
    }
    @GetMapping("Totalbooks")
    public ResponseEntity<List<Book>> listofBooks(@RequestParam("x") int x){
        List<Book> msg = ser.listofBooks(x);
        // String msg = "Book is add to the Database";
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of books");
        return new ResponseEntity<>(msg,headers, HttpStatus.OK);
    }

}
