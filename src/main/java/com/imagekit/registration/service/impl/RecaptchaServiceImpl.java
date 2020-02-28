package com.imagekit.registration.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.imagekit.registration.service.RecaptchaService;

@Service
public class RecaptchaServiceImpl implements RecaptchaService {

	@Value("${google.recaptcha.secret}")
	String recaptchaSecret;

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	private static final String GOOGLE_RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

	@Override
	public String verifyCaptcha(String response, String ip) {
		Map<String, String> body = new HashMap<>();
		body.put("secret", recaptchaSecret);
		body.put("response", response);
		body.put("remoteip", ip);
		Map<String, Object> responseBody = new HashMap<String, Object>();
		try {
			ResponseEntity<Map> recaptchaResponseEntity = restTemplateBuilder.build().postForEntity(
					GOOGLE_RECAPTCHA_VERIFY_URL + "?secret={secret}&response={response}&remoteip={remoteip}", body,
					Map.class, body);
			responseBody = recaptchaResponseEntity.getBody();
		} catch (Exception e) {
			return "";
		}

		boolean recaptchaSucess = (Boolean) responseBody.get("success");
		if (!recaptchaSucess) {
			List<String> errorCodes = (List) responseBody.get("error-codes");

			String errorMessage = errorCodes.stream().collect(Collectors.joining(", "));

			return errorMessage;
		} else {
			return "";
		}
	}
}
