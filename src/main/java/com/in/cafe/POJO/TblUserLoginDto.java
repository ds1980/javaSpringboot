package com.in.cafe.POJO;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.in.cafe.constants.CafeConstants;
import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class TblUserLoginDto extends AbstractAuditingDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	@Pattern(regexp = CafeConstants.LOGIN_REGEX)
	@Size(min = 1, max = 50)
	private String login;

	@Size(max = 50)
	private String firstName;

	@Size(max = 50)
	private String lastName;

	@Email
	@Size(min = 5, max = 254)
	private String email;

	@Size(max = 256)
	private String imageUrl;

	private boolean activated;
	private boolean superAdmin = false;

	@Size(min = 2, max = 10)
	private String langKey;

	private Set<String> authorities;

	private Integer failedPassAttempts;

	private String mobileNo;

	private Integer isEmailVerify;

	private Integer isMobileNoVerify;

	private Integer isFirstLogin;

	private String password;

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

	public TblUserLoginDto() {
		super();
	}

	public TblUserLoginDto(TblUserLogin tblUserLogin) {
		this.id = tblUserLogin.getId();
		this.login = tblUserLogin.getLogin();
		this.firstName = tblUserLogin.getFirstName();
		this.lastName = tblUserLogin.getLastName();
		this.email = tblUserLogin.getEmail();
		this.activated = tblUserLogin.getActivated();
		this.imageUrl = tblUserLogin.getImageUrl();
		this.langKey = tblUserLogin.getLangKey();
		this.authorities = tblUserLogin.getAuthorities().stream().map(TblRoleEntity::getName)
				.collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public String getLangKey() {
		return langKey;
	}

	public void setLangKey(String langKey) {
		this.langKey = langKey;
	}

	/**
	 * @return the authorities
	 */
	public Set<String> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Set<String> authorities) {
		this.authorities = authorities;
	}

	/**
	 * @return the failedPassAttempts
	 */
	public Integer getFailedPassAttempts() {
		return failedPassAttempts;
	}

	/**
	 * @param failedPassAttempts the failedPassAttempts to set
	 */
	public void setFailedPassAttempts(Integer failedPassAttempts) {
		this.failedPassAttempts = failedPassAttempts;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the isEmailVerify
	 */
	public Integer getIsEmailVerify() {
		return isEmailVerify;
	}

	/**
	 * @param isEmailVerify the isEmailVerify to set
	 */
	public void setIsEmailVerify(Integer isEmailVerify) {
		this.isEmailVerify = isEmailVerify;
	}

	/**
	 * @return the isMobileNoVerify
	 */
	public Integer getIsMobileNoVerify() {
		return isMobileNoVerify;
	}

	/**
	 * @param isMobileNoVerify the isMobileNoVerify to set
	 */
	public void setIsMobileNoVerify(Integer isMobileNoVerify) {
		this.isMobileNoVerify = isMobileNoVerify;
	}

	/**
	 * @return the isFirstLogin
	 */
	public Integer getIsFirstLogin() {
		return isFirstLogin;
	}

	/**
	 * @param isFirstLogin the isFirstLogin to set
	 */
	public void setIsFirstLogin(Integer isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}

	public boolean isSuperAdmin() {
		this.setSuperAdmin(CafeConstants.SUPER_ADMIN_ID_LIST.contains(this.getId()));
		return superAdmin;
	}

	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}

	
	
}
