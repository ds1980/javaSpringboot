package com.in.cafe.POJO;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.in.cafe.constants.CafeConstants;
import com.in.cafe.domain.AbstractAuditingEntity;


/**
 * A user.
 */
@Entity
@Table(name = "Tbl_Userlogin")
public class TblUserLogin extends AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@NotNull
	@Pattern(regexp = CafeConstants.LOGIN_REGEX)
	@Size(min = 1, max = 50)
	@Column(length = 50, unique = true, nullable = false, name = "login")
	private String login;

	@JsonIgnore
	@NotNull
	@Size(min = 60, max = 60)
	@Column(name = "password_hash", length = 60, nullable = false)
	private String password;

	@Size(max = 50)
	@Column(name = "first_name", length = 50)
	private String firstName;

	@Size(max = 50)
	@Column(name = "last_name", length = 50)
	private String lastName;

	@Email
	@Size(min = 5, max = 254)
	@Column(length = 254, unique = true)
	private String email;

	@NotNull
	@Column(nullable = false)
	private boolean activated;

	@Size(min = 2, max = 10)
	@Column(name = "lang_key", length = 10)
	private String langKey;

	@Size(max = 256)
	@Column(name = "image_url", length = 256)
	private String imageUrl;

	@Size(max = 20)
	@Column(name = "activation_key", length = 20)
	@JsonIgnore
	private String activationKey;

	@Size(max = 20)
	@Column(name = "reset_key", length = 20)
	@JsonIgnore
	private String resetKey;

	@Column(name = "reset_date")
	private Instant resetDate = null;

	/* added by me */
	@Column(name = "failed_pass_attempts")
	private Integer failedPassAttempts;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "is_email_verify")
	private Integer isEmailVerify;

	@Column(name = "is_mobileno_verify")
	private Integer isMobileNoVerify;

	@Column(name = "is_first_login")
	private Integer isFirstLogin;

	/**
	 * @param id
	 */
	public TblUserLogin(Long id) {
		super();
		this.id = id;
	}

	/**
	 * 
	 */
	public TblUserLogin() {
		super();
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

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "Tbl_UserRoles", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "authority_name", referencedColumnName = "name") })
	@BatchSize(size = 20)
	private Set<TblRoleEntity> authorities = new HashSet<>();

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
		this.login = StringUtils.lowerCase(login, Locale.ENGLISH);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean getActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	public String getResetKey() {
		return resetKey;
	}

	public void setResetKey(String resetKey) {
		this.resetKey = resetKey;
	}

	public Instant getResetDate() {
		return resetDate;
	}

	public void setResetDate(Instant resetDate) {
		this.resetDate = resetDate;
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
	public Set<TblRoleEntity> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Set<TblRoleEntity> authorities) {
		this.authorities = authorities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (activated ? 1231 : 1237);
		result = prime * result + ((activationKey == null) ? 0 : activationKey.hashCode());
		result = prime * result + ((authorities == null) ? 0 : authorities.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((failedPassAttempts == null) ? 0 : failedPassAttempts.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((isEmailVerify == null) ? 0 : isEmailVerify.hashCode());
		result = prime * result + ((isFirstLogin == null) ? 0 : isFirstLogin.hashCode());
		result = prime * result + ((isMobileNoVerify == null) ? 0 : isMobileNoVerify.hashCode());
		result = prime * result + ((langKey == null) ? 0 : langKey.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((resetDate == null) ? 0 : resetDate.hashCode());
		result = prime * result + ((resetKey == null) ? 0 : resetKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TblUserLogin other = (TblUserLogin) obj;
		if (activated != other.activated)
			return false;
		if (activationKey == null) {
			if (other.activationKey != null)
				return false;
		} else if (!activationKey.equals(other.activationKey))
			return false;
		if (authorities == null) {
			if (other.authorities != null)
				return false;
		} else if (!authorities.equals(other.authorities))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (failedPassAttempts == null) {
			if (other.failedPassAttempts != null)
				return false;
		} else if (!failedPassAttempts.equals(other.failedPassAttempts))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (isEmailVerify == null) {
			if (other.isEmailVerify != null)
				return false;
		} else if (!isEmailVerify.equals(other.isEmailVerify))
			return false;
		if (isFirstLogin == null) {
			if (other.isFirstLogin != null)
				return false;
		} else if (!isFirstLogin.equals(other.isFirstLogin))
			return false;
		if (isMobileNoVerify == null) {
			if (other.isMobileNoVerify != null)
				return false;
		} else if (!isMobileNoVerify.equals(other.isMobileNoVerify))
			return false;
		if (langKey == null) {
			if (other.langKey != null)
				return false;
		} else if (!langKey.equals(other.langKey))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (resetDate == null) {
			if (other.resetDate != null)
				return false;
		} else if (!resetDate.equals(other.resetDate))
			return false;
		if (resetKey == null) {
			if (other.resetKey != null)
				return false;
		} else if (!resetKey.equals(other.resetKey))
			return false;
		return true;
	}
}
