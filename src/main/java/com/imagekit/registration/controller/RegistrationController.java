package com.imagekit.registration.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.imagekit.registration.api.RegistrationApi;
import com.imagekit.registration.dto.User;
import com.imagekit.registration.service.RecaptchaService;
import com.imagekit.registration.service.UserService;

@Controller
public class RegistrationController implements RegistrationApi {

	@Autowired
	UserService userService;

	@Autowired
	RecaptchaService recaptchaService;

	@Override
	public ModelAndView showRegistrationForm(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		User userDto = new User();
		modelAndView.addObject(userDto);
		int IpCount = userService.getIpCount(request.getRemoteAddr());
		if (IpCount >= 3) {
			modelAndView.setViewName("register_recaptcha.html");
		} else {
			modelAndView.setViewName("register.html");
		}
		return modelAndView;
	}

	@Override
	public ResponseEntity<?> registerUserAccount(User userDto, String recaptcha, BindingResult result,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.addObject("errorMessage", "Errors in the input");
		}
		String captchaVerifyMessage = recaptchaService.verifyCaptcha(recaptcha, request.getRemoteAddr());
		if (!StringUtils.isEmpty(captchaVerifyMessage)) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", captchaVerifyMessage);
			return ResponseEntity.badRequest().body(response);
		}
//		modelAndView.addObject("user", new User());
//		modelAndView.setViewName("register.html");
		userService.saveUser(userDto, request.getRemoteAddr());
		return ResponseEntity.ok().build();
	}
}
