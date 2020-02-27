package com.imagekit.registration.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDto {

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private String password;
	// private String matchingPassword;

	@NotNull
	@NotEmpty
	private String email;

	private String ip;

	public UserDto() {

	}

	public UserDto(@NotNull @NotEmpty String name, @NotNull @NotEmpty String password, String matchingPassword,
			@NotNull @NotEmpty String email) {
		super();
		this.name = name;
		this.password = password;
		// this.matchingPassword = matchingPassword;
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

//	/**
//	 * @return the matchingPassword
//	 */
//	public String getMatchingPassword() {
//		return matchingPassword;
//	}
//
//	/**
//	 * @param matchingPassword the matchingPassword to set
//	 */
//	public void setMatchingPassword(String matchingPassword) {
//		this.matchingPassword = matchingPassword;
//	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

}
