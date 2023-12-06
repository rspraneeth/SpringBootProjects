package com.store.service;

import com.store.model.Book;
import com.store.repository.BookRepository;
import com.store.repository.MyBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService{
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MyBooksRepository myBooksRepository;
    public void save(Book b){
        bookRepository.save(b);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(int id){
        return bookRepository.findById(id).get();
    }

    public void deleteById(int id){
        bookRepository.deleteById(id);
        myBooksRepository.deleteById(id);
    }
}
