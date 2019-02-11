package com.ashish.cactus.school.management.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the teacher_master database table.
 * 
 */
@Entity
@Table(name="teacher_master")
@NamedQuery(name="TeacherMaster.findAll", query="SELECT t FROM TeacherMaster t")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class TeacherMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacher_id", unique=true, nullable=false)
	private int teacherId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user", length=50)
	private String createUser;

	@Column(name="delete_ind", length=2)
	private String deleteInd;

	@Column(name="delete_reason", length=100)
	private String deleteReason;

	@Column(name="teacher_description", length=100)
	private String teacherDescription;

	@Column(name="teacher_designation", length=100)
	private String teacherDesignation;

	@Column(name="teacher_firstname", length=50)
	private String teacherFirstname;

	@Temporal(TemporalType.DATE)
	@Column(name="teacher_joining_date")
	private Date teacherJoiningDate;

	@Column(name="teacher_lastname", length=50)
	private String teacherLastname;

	@Column(name="teacher_middlename", length=50)
	private String teacherMiddlename;

	@Column(name="teacher_qualification", length=100)
	private String teacherQualification;

	@Temporal(TemporalType.DATE)
	@Column(name="teacher_retired_date")
	private Date teacherRetiredDate;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user", length=50)
	private String updateUser;

	//bi-directional many-to-one association to TeacherSubject
	@OneToMany(mappedBy="teacherMaster")
	private List<TeacherSubject> teacherSubjects;

	public TeacherMaster() {
	}

	public int getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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

	public String getDeleteInd() {
		return this.deleteInd;
	}

	public void setDeleteInd(String deleteInd) {
		this.deleteInd = deleteInd;
	}

	public String getDeleteReason() {
		return this.deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	public String getTeacherDescription() {
		return this.teacherDescription;
	}

	public void setTeacherDescription(String teacherDescription) {
		this.teacherDescription = teacherDescription;
	}

	public String getTeacherDesignation() {
		return this.teacherDesignation;
	}

	public void setTeacherDesignation(String teacherDesignation) {
		this.teacherDesignation = teacherDesignation;
	}

	public String getTeacherFirstname() {
		return this.teacherFirstname;
	}

	public void setTeacherFirstname(String teacherFirstname) {
		this.teacherFirstname = teacherFirstname;
	}

	public Date getTeacherJoiningDate() {
		return this.teacherJoiningDate;
	}

	public void setTeacherJoiningDate(Date teacherJoiningDate) {
		this.teacherJoiningDate = teacherJoiningDate;
	}

	public String getTeacherLastname() {
		return this.teacherLastname;
	}

	public void setTeacherLastname(String teacherLastname) {
		this.teacherLastname = teacherLastname;
	}

	public String getTeacherMiddlename() {
		return this.teacherMiddlename;
	}

	public void setTeacherMiddlename(String teacherMiddlename) {
		this.teacherMiddlename = teacherMiddlename;
	}

	public String getTeacherQualification() {
		return this.teacherQualification;
	}

	public void setTeacherQualification(String teacherQualification) {
		this.teacherQualification = teacherQualification;
	}

	public Date getTeacherRetiredDate() {
		return this.teacherRetiredDate;
	}

	public void setTeacherRetiredDate(Date teacherRetiredDate) {
		this.teacherRetiredDate = teacherRetiredDate;
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

	public List<TeacherSubject> getTeacherSubjects() {
		return this.teacherSubjects;
	}

	public void setTeacherSubjects(List<TeacherSubject> teacherSubjects) {
		this.teacherSubjects = teacherSubjects;
	}

	public TeacherSubject addTeacherSubject(TeacherSubject teacherSubject) {
		getTeacherSubjects().add(teacherSubject);
		teacherSubject.setTeacherMaster(this);

		return teacherSubject;
	}

	public TeacherSubject removeTeacherSubject(TeacherSubject teacherSubject) {
		getTeacherSubjects().remove(teacherSubject);
		teacherSubject.setTeacherMaster(null);

		return teacherSubject;
	}

}