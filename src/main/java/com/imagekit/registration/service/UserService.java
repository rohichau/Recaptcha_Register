package com.imagekit.registration.service;

import javax.validation.Valid;

import com.imagekit.registration.dto.User;

public interface UserService {

	public void saveUser(@Valid User userDto, String ip);

	public int getIpCount(String Ip);
}
