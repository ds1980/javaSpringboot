package com.in.cafe.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_userdetail")
public class TblUserdetail extends AbstractAuditingEntity implements Serializable {
	private Integer userdetailId;
	private long userId;
	private String username;
	private String companyname;
	private String departmentname;
	private String designationname;


	public TblUserdetail()
	{
	    super();
	}
	public TblUserdetail(Integer userdetailId)
    {
        super();
        this.userdetailId = userdetailId;
    }


	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "userdetail_id", unique = true, nullable = false)
	public Integer getUserdetailId()
	{
		return this.userdetailId;
	}

	public void setUserdetailId(Integer userdetailId)
	{
		this.userdetailId = userdetailId;
	}

	@Column(name = "user_id", nullable = false)
	public long getUserId()
	{
		return this.userId;
	}

	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	@Column(name = "user_name", nullable = false, length = 1000)
	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	@Column(name = "company_name", length = 1000)
	public String getCompanyname()
	{
		return this.companyname;
	}

	public void setCompanyname(String companyname)
	{
		this.companyname = companyname;
	}

	@Column(name = "department_name", length = 1000)
	public String getDepartmentname()
	{
		return this.departmentname;
	}

	public void setDepartmentname(String departmentname)
	{
		this.departmentname = departmentname;
	}

	@Column(name = "designation_name", length = 1000)
	public String getDesignationname()
	{
		return this.designationname;
	}

	public void setDesignationname(String designationname)
	{
		this.designationname = designationname;
	}
}
