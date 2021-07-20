package com.training.demolibrary.service;

import com.training.demolibrary.model.Book;
import com.training.demolibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

//    get all books
    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

//    get book by ID
    public Book getBookById(String id){
        if (this.bookRepository.findById(id).isPresent()) {
            Book book1 = this.bookRepository.getById(id);
            return book1;
        } else {
            return null;
        }
    }

////    get books by author
//    public List<Book> getBookByAuthor(String author){
//        List<Book> book = this.bookRepository.getById(author);
//    }

//    get books by category

//    add books
    public String addNewBook(Book book){
        this.bookRepository.save(book);
        return "book added successfully";
    }

//    remove books
    public String deleteBook(String bookID){
        this.bookRepository.deleteById(bookID);
        return "Book deleted successfully";
    }

//    update Books
    public void updateBook(String id, Book book){
        if (this.bookRepository.findById(id).isPresent()) {
            this.bookRepository.save(book);
        }
    }

}
