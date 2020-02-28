package com.imagekit.registration.service;

public interface RecaptchaService {

	public String verifyCaptcha(String response, String ip);

}
