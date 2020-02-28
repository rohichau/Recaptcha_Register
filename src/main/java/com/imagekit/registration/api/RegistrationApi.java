package com.imagekit.registration.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.imagekit.registration.dto.User;

@RequestMapping("registration")
public interface RegistrationApi {

	@GetMapping
	public ModelAndView showRegistrationForm(HttpServletRequest request);

	@PostMapping
	public ResponseEntity<?> registerUserAccount(@ModelAttribute("user") @Valid User accountDto,
			@RequestParam(name = "g-recaptcha-response", defaultValue = "NA", required = false) String recaptcha,
			BindingResult result, HttpServletRequest request);
}
