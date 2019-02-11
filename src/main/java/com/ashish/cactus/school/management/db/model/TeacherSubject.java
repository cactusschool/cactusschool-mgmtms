package com.ashish.cactus.school.management.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the teacher_subject database table.
 * 
 */
@Entity
@Table(name="teacher_subject")
@NamedQuery(name="TeacherSubject.findAll", query="SELECT t FROM TeacherSubject t")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class TeacherSubject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacher_subject_id", unique=true, nullable=false)
	private int teacherSubjectId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user", length=50)
	private String createUser;

	@Column(name="delete_ind", length=50)
	private String deleteInd;

	@Column(name="delete_reason", length=100)
	private String deleteReason;

	@Temporal(TemporalType.DATE)
	@Column(name="teacher_subject_enddate")
	private Date teacherSubjectEnddate;

	@Temporal(TemporalType.DATE)
	@Column(name="teacher_subject_startdate")
	private Date teacherSubjectStartdate;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user", length=50)
	private String updateUser;

	//bi-directional many-to-one association to SectionMaster
	@ManyToOne
	@JoinColumn(name="section_id")
	private SectionMaster sectionMaster;

	//bi-directional many-to-one association to SubjectMaster
	@ManyToOne
	@JoinColumn(name="subject_id")
	private SubjectMaster subjectMaster;

	//bi-directional many-to-one association to TeacherMaster
	@ManyToOne
	@JoinColumn(name="teacher_id")
	private TeacherMaster teacherMaster;

	public TeacherSubject() {
	}

	public int getTeacherSubjectId() {
		return this.teacherSubjectId;
	}

	public void setTeacherSubjectId(int teacherSubjectId) {
		this.teacherSubjectId = teacherSubjectId;
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

	public Date getTeacherSubjectEnddate() {
		return this.teacherSubjectEnddate;
	}

	public void setTeacherSubjectEnddate(Date teacherSubjectEnddate) {
		this.teacherSubjectEnddate = teacherSubjectEnddate;
	}

	public Date getTeacherSubjectStartdate() {
		return this.teacherSubjectStartdate;
	}

	public void setTeacherSubjectStartdate(Date teacherSubjectStartdate) {
		this.teacherSubjectStartdate = teacherSubjectStartdate;
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

	public SectionMaster getSectionMaster() {
		return this.sectionMaster;
	}

	public void setSectionMaster(SectionMaster sectionMaster) {
		this.sectionMaster = sectionMaster;
	}

	public SubjectMaster getSubjectMaster() {
		return this.subjectMaster;
	}

	public void setSubjectMaster(SubjectMaster subjectMaster) {
		this.subjectMaster = subjectMaster;
	}

	public TeacherMaster getTeacherMaster() {
		return this.teacherMaster;
	}

	public void setTeacherMaster(TeacherMaster teacherMaster) {
		this.teacherMaster = teacherMaster;
	}

}