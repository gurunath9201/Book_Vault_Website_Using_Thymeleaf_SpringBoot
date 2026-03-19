package com.bookmanagement.service;

import com.bookmanagement.entity.MyBookList;
import com.bookmanagement.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {

	@Autowired
	private MyBookRepository myBookRepository;

	public void saveMyBooks(MyBookList book) {
		myBookRepository.save(book);
	}

	public List<MyBookList> getAllMyBooks() {
		return myBookRepository.findAll();
	}

	public void deleteById(int id) {
		myBookRepository.deleteById(id);
	}

	public long getTotalMyBooks() {
		return myBookRepository.count();
	}
}