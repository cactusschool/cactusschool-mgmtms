package com.ashish.cactus.school.management.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the academic_year database table.
 * 
 */
@Entity
@Table(name="academic_year")
@NamedQuery(name="AcademicYear.findAll", query="SELECT a FROM AcademicYear a")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class AcademicYear implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="academic_year_id", unique=true, nullable=false)
	private int academicYearId;

	@Temporal(TemporalType.DATE)
	@Column(name="academic_year_enddate")
	private Date academicYearEnddate;

	@Temporal(TemporalType.DATE)
	@Column(name="academic_year_startdate")
	private Date academicYearStartdate;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user", length=50)
	private String createUser;

	@Column(name="delete_description", length=100)
	private String deleteDescription;

	@Column(name="delete_ind", length=2)
	private String deleteInd;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user", length=50)
	private String updateUser;

	public AcademicYear() {
	}

	public int getAcademicYearId() {
		return this.academicYearId;
	}

	public void setAcademicYearId(int academicYearId) {
		this.academicYearId = academicYearId;
	}

	public Date getAcademicYearEnddate() {
		return this.academicYearEnddate;
	}

	public void setAcademicYearEnddate(Date academicYearEnddate) {
		this.academicYearEnddate = academicYearEnddate;
	}

	public Date getAcademicYearStartdate() {
		return this.academicYearStartdate;
	}

	public void setAcademicYearStartdate(Date academicYearStartdate) {
		this.academicYearStartdate = academicYearStartdate;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getDeleteDescription() {
		return this.deleteDescription;
	}

	public void setDeleteDescription(String deleteDescription) {
		this.deleteDescription = deleteDescription;
	}

	public String getDeleteInd() {
		return this.deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}