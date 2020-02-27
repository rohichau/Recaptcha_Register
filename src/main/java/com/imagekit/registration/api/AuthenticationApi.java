package com.imagekit.registration.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imagekit.registration.dto.UserDto;

@RequestMapping
public interface AuthenticationApi {

	@GetMapping(value = "/register")
	public ModelAndView showRegistrationForm();

	@PostMapping(value = "/register")
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto accountDto, BindingResult result,
			HttpServletRequest request);

}
