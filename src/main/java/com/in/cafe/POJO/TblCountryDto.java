package com.in.cafe.POJO;

import java.io.Serializable;

public class TblCountryDto extends AbstractAuditingDto implements Serializable{
		private static final long serialVersionUID = 1L;
		private long countryId;
		private String sortname;
		private String countryName;
		private int phoneCode;
		private String lang1;
		private String lang2;
		private String lang3;
		private String lang4;
		private String lang5;
		private String lang6;
		private String lang7;
		public long getCountryId() {
			return countryId;
		}
		public void setCountryId(long countryId) {
			this.countryId = countryId;
		}
		public String getSortname() {
			return sortname;
		}
		public void setSortname(String sortname) {
			this.sortname = sortname;
		}
		public String getCountryName() {
			return countryName;
		}
		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}
		public int getPhoneCode() {
			return phoneCode;
		}
		public void setPhoneCode(int phoneCode) {
			this.phoneCode = phoneCode;
		}
		public String getLang1() {
			return lang1;
		}
		public void setLang1(String lang1) {
			this.lang1 = lang1;
		}
		public String getLang2() {
			return lang2;
		}
		public void setLang2(String lang2) {
			this.lang2 = lang2;
		}
		public String getLang3() {
			return lang3;
		}
		public void setLang3(String lang3) {
			this.lang3 = lang3;
		}
		public String getLang4() {
			return lang4;
		}
		public void setLang4(String lang4) {
			this.lang4 = lang4;
		}
		public String getLang5() {
			return lang5;
		}
		public void setLang5(String lang5) {
			this.lang5 = lang5;
		}
		public String getLang6() {
			return lang6;
		}
		public void setLang6(String lang6) {
			this.lang6 = lang6;
		}
		public String getLang7() {
			return lang7;
		}
		public void setLang7(String lang7) {
			this.lang7 = lang7;
		}
		
		

}
