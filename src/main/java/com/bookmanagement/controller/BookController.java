package com.bookmanagement.controller;

import com.bookmanagement.entity.Book;
import com.bookmanagement.entity.MyBookList;
import com.bookmanagement.service.BookService;
import com.bookmanagement.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	@Autowired
	private MyBookService myBookService;

	// ─── Home ────────────────────────────────────────────────────────────────

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("totalBooks", service.getTotalBooks());
		model.addAttribute("totalMyBooks", myBookService.getTotalMyBooks());
		return "home";
	}

	// ─── Book Registration ────────────────────────────────────────────────────

	@GetMapping("/book_register")
	public String bookRegister(Model model) {
		model.addAttribute("book", new Book());
		return "bookRegister";
	}

	// ─── Available Books ──────────────────────────────────────────────────────

	@GetMapping("/available_books")
	public String getAllBook(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
		List<Book> list = service.searchBooks(keyword);
		model.addAttribute("book", list);
		model.addAttribute("keyword", keyword != null ? keyword : "");
		model.addAttribute("totalBooks", service.getTotalBooks());
		return "bookList";
	}

	// ─── Save (Create + Update) ───────────────────────────────────────────────

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b, RedirectAttributes redirectAttributes) {
		boolean isUpdate = b.getId() != 0;
		service.save(b);
		redirectAttributes.addFlashAttribute("successMessage",
				isUpdate ? "✅ Book updated successfully!" : "✅ Book registered successfully!");
		return "redirect:/available_books";
	}

	// ─── My Books ─────────────────────────────────────────────────────────────

	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> list = myBookService.getAllMyBooks();
		model.addAttribute("book", list);
		model.addAttribute("totalMyBooks", myBookService.getTotalMyBooks());
		return "myBooks";
	}

	// ─── Add to My List ───────────────────────────────────────────────────────

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		Book book = service.getBookById(id);
		// ✅ FIX: pass 0 as id so JPA does INSERT not UPDATE (book.getId() caused StaleObjectStateException)
		MyBookList myBookList = new MyBookList(0, book.getName(), book.getAuthor(), book.getPrice());
		myBookService.saveMyBooks(myBookList);
		redirectAttributes.addFlashAttribute("successMessage", "📚 \"" + book.getName() + "\" added to My Books!");
		return "redirect:/my_books";
	}

	// ─── Edit Book ────────────────────────────────────────────────────────────

	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {   // ✅ FIXED: missing comma was here
		Book book = service.getBookById(id);
		model.addAttribute("book", book);
		return "bookEdit";
	}

	// ─── Delete Book ──────────────────────────────────────────────────────────

	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		service.deleteById(id);
		redirectAttributes.addFlashAttribute("successMessage", "🗑️ Book deleted successfully!");
		return "redirect:/available_books";
	}
}