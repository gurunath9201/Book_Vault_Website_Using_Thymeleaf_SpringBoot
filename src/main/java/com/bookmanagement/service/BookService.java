package com.bookmanagement.service;

import com.bookmanagement.entity.Book;
import com.bookmanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public void save(Book b) {
		bookRepository.save(b);
	}

	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}

	public Book getBookById(int id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
	}

	public void deleteById(int id) {
		bookRepository.deleteById(id);
	}

	public List<Book> searchBooks(String keyword) {
		if (keyword == null || keyword.trim().isEmpty()) {
			return bookRepository.findAll();
		}
		return bookRepository.searchBooks(keyword.trim());
	}

	public long getTotalBooks() {
		return bookRepository.count();
	}
}