package com.store.service;

import com.store.model.MyBooksList;
import com.store.repository.BookRepository;
import com.store.repository.MyBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBooksListService {

    @Autowired
    private MyBooksRepository myBooksRepository;


    public void saveMyBooks(MyBooksList booksList){
        myBooksRepository.save(booksList);
    }

    public List<MyBooksList> getAllMyBooks(){
        return myBooksRepository.findAll();
    }

    public void deleteById(int id){
        myBooksRepository.deleteById(id);
    }
}
