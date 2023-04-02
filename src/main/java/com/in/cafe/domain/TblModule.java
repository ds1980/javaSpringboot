package com.in.cafe.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	@Entity
	@Table(name = "tbl_module")
	public class TblModule implements java.io.Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Integer moduleId;
		private String moduleName;
		private Integer parentModuleId;
		private int isActive;
		private String lang2;
		private String lang3;
		private String lang4;
		private String lang5;
		private String lang6;
		private String lang7;
		private String lang1;
		private Set<TblClientmodule> tblClientmodules = new HashSet<TblClientmodule>(0);
		// private Set<TblTermsandcondition> tblTermsandconditions = new HashSet<TblTermsandcondition>(0);
		private Set<TblField> tblFields = new HashSet<TblField>(0);
		// private Set<TblClienttermsandcondition> tblClienttermsandconditions = new HashSet<TblClienttermsandcondition>(0);
		// private Set<TblMarqueecontent> tblMarqueecontents = new HashSet<TblMarqueecontent>(0);

		public TblModule() {
		}
		
		

		public TblModule(Integer moduleId) {
			super();
			this.moduleId = moduleId;
		}



		public TblModule(String moduleName, int isActive) {
			this.moduleName = moduleName;
			this.isActive = isActive;
		}

		public TblModule(String moduleName, Integer parentModuleId, int isActive, String lang2, String lang3, String lang4, String lang5, String lang6, String lang7, String lang1, Set<TblClientmodule> tblClientmodules, Set<TblField> tblFields) {
			this.moduleName = moduleName;
			this.parentModuleId = parentModuleId;
			this.isActive = isActive;
			this.lang2 = lang2;
			this.lang3 = lang3;
			this.lang4 = lang4;
			this.lang5 = lang5;
			this.lang6 = lang6;
			this.lang7 = lang7;
			this.lang1 = lang1;
			this.tblClientmodules = tblClientmodules;
//			this.tblTermsandconditions = tblTermsandconditions;
			this.tblFields = tblFields;
//			this.tblClienttermsandconditions = tblClienttermsandconditions;
//			this.tblMarqueecontents = tblMarqueecontents;
		}

		@Id
		@GeneratedValue(strategy = IDENTITY)

		@Column(name = "module_id", unique = true, nullable = false)
		public Integer getModuleId() {
			return this.moduleId;
		}

		public void setModuleId(Integer moduleId) {
			this.moduleId = moduleId;
		}

		@Column(name = "module_name", nullable = false, length = 500)
		public String getModuleName() {
			return this.moduleName;
		}

		public void setModuleName(String moduleName) {
			this.moduleName = moduleName;
		}

		@Column(name = "parent_module_id")
		public Integer getParentModuleId() {
			return this.parentModuleId;
		}

		public void setParentModuleId(Integer parentModuleId) {
			this.parentModuleId = parentModuleId;
		}

		@Column(name = "is_active", nullable = false)
		public int getIsActive() {
			return this.isActive;
		}

		public void setIsActive(int isActive) {
			this.isActive = isActive;
		}

		@Column(name = "lang2", length = 100)
		public String getLang2() {
			return this.lang2;
		}

		public void setLang2(String lang2) {
			this.lang2 = lang2;
		}

		@Column(name = "lang3", length = 100)
		public String getLang3() {
			return this.lang3;
		}

		public void setLang3(String lang3) {
			this.lang3 = lang3;
		}

		@Column(name = "lang4", length = 100)
		public String getLang4() {
			return this.lang4;
		}

		public void setLang4(String lang4) {
			this.lang4 = lang4;
		}

		@Column(name = "lang5", length = 100)
		public String getLang5() {
			return this.lang5;
		}

		public void setLang5(String lang5) {
			this.lang5 = lang5;
		}

		@Column(name = "lang6", length = 100)
		public String getLang6() {
			return this.lang6;
		}

		public void setLang6(String lang6) {
			this.lang6 = lang6;
		}

		@Column(name = "lang7", length = 100)
		public String getLang7() {
			return this.lang7;
		}

		public void setLang7(String lang7) {
			this.lang7 = lang7;
		}

		@Column(name = "lang1", length = 100)
		public String getLang1() {
			return this.lang1;
		}

		public void setLang1(String lang1) {
			this.lang1 = lang1;
		}

		@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblModule")
		public Set<TblClientmodule> getTblClientmodules() {
			return this.tblClientmodules;
		}

		public void setTblClientmodules(Set<TblClientmodule> tblClientmodules) {
			this.tblClientmodules = tblClientmodules;
		}

//		@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblModule")
//		public Set<TblTermsandcondition> getTblTermsandconditions() {
//			return this.tblTermsandconditions;
//		}
//
//		public void setTblTermsandconditions(Set<TblTermsandcondition> tblTermsandconditions) {
//			this.tblTermsandconditions = tblTermsandconditions;
//		}
//
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblModule")
		public Set<TblField> getTblFields() {
			return this.tblFields;
		}

		public void setTblFields(Set<TblField> tblFields) {
			this.tblFields = tblFields;
		}
//
//		@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblModule")
//		public Set<TblClienttermsandcondition> getTblClienttermsandconditions() {
//			return this.tblClienttermsandconditions;
//		}
//
//		public void setTblClienttermsandconditions(Set<TblClienttermsandcondition> tblClienttermsandconditions) {
//			this.tblClienttermsandconditions = tblClienttermsandconditions;
//		}
//
//		@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblModule")
//		public Set<TblMarqueecontent> getTblMarqueecontents() {
//			return this.tblMarqueecontents;
//		}
//
//		public void setTblMarqueecontents(Set<TblMarqueecontent> tblMarqueecontents) {
//			this.tblMarqueecontents = tblMarqueecontents;
//		}
}
