package com.ashish.cactus.school.management.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the student_subject database table.
 * 
 */
@Entity
@Table(name="student_subject")
@NamedQuery(name="StudentSubject.findAll", query="SELECT s FROM StudentSubject s")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class StudentSubject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_subject_id", unique=true, nullable=false)
	private int studentSubjectId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user", length=50)
	private String createUser;

	@Column(name="delete_ind", length=50)
	private String deleteInd;

	@Column(name="delete_reason", length=100)
	private String deleteReason;

	@Temporal(TemporalType.DATE)
	@Column(name="student_subject_enddate")
	private Date studentSubjectEnddate;

	@Temporal(TemporalType.DATE)
	@Column(name="student_subject_startdate")
	private Date studentSubjectStartdate;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user", length=50)
	private String updateUser;

	//bi-directional many-to-one association to StudentMaster
	@ManyToOne
	@JoinColumn(name="student_id")
	private StudentMaster studentMaster;

	//bi-directional many-to-one association to SubjectMaster
	@ManyToOne
	@JoinColumn(name="subject_id")
	private SubjectMaster subjectMaster;

	public StudentSubject() {
	}

	public int getStudentSubjectId() {
		return this.studentSubjectId;
	}

	public void setStudentSubjectId(int studentSubjectId) {
		this.studentSubjectId = studentSubjectId;
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

	public Date getStudentSubjectEnddate() {
		return this.studentSubjectEnddate;
	}

	public void setStudentSubjectEnddate(Date studentSubjectEnddate) {
		this.studentSubjectEnddate = studentSubjectEnddate;
	}

	public Date getStudentSubjectStartdate() {
		return this.studentSubjectStartdate;
	}

	public void setStudentSubjectStartdate(Date studentSubjectStartdate) {
		this.studentSubjectStartdate = studentSubjectStartdate;
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

	public StudentMaster getStudentMaster() {
		return this.studentMaster;
	}

	public void setStudentMaster(StudentMaster studentMaster) {
		this.studentMaster = studentMaster;
	}

	public SubjectMaster getSubjectMaster() {
		return this.subjectMaster;
	}

	public void setSubjectMaster(SubjectMaster subjectMaster) {
		this.subjectMaster = subjectMaster;
	}

}