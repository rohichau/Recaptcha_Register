package com.imagekit.registration.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.imagekit.registration.api.AuthenticationApi;
import com.imagekit.registration.dto.UserDto;

@Controller
public class AuthenticationController implements AuthenticationApi {

	@Override
	public ModelAndView showRegistrationForm() {
		ModelAndView modelAndView = new ModelAndView();
		UserDto userDto = new UserDto();
		modelAndView.addObject(userDto);
		modelAndView.setViewName("register");
		return modelAndView;
	}

	@Override
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.addObject("errorMessage", "Errors in the input");
		}
		userDto.setIp(request.getRemoteAddr());
		modelAndView.addObject("user", new UserDto());
		modelAndView.setViewName("register");
		return null;
	}
}
