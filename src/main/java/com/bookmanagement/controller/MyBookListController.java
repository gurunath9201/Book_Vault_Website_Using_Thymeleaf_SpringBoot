package com.bookmanagement.controller;

import com.bookmanagement.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyBookListController {

	@Autowired
	private MyBookService service;

	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		service.deleteById(id);   // ✅ FIXED: this line was completely missing before
		redirectAttributes.addFlashAttribute("successMessage", "🗑️ Book removed from My List!");
		return "redirect:/my_books";
	}
}