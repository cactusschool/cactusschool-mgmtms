package com.ashish.cactus.school.management.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the student_master database table.
 * 
 */
@Entity
@Table(name="student_master")
@NamedQuery(name="StudentMaster.findAll", query="SELECT s FROM StudentMaster s")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class StudentMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id", unique=true, nullable=false)
	private int studentId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user", length=50)
	private String createUser;

	@Column(name="delete_description", length=50)
	private String deleteDescription;

	@Column(name="delete_ind", length=50)
	private String deleteInd;

	@Column(name="student_description", length=50)
	private String studentDescription;

	@Column(name="student_firstname", length=50)
	private String studentFirstname;

	@Column(name="student_lastname", length=50)
	private String studentLastname;

	@Column(name="student_middlename", length=50)
	private String studentMiddlename;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user", length=50)
	private String updateUser;

	//bi-directional many-to-one association to StudentSection
	@OneToMany(mappedBy="studentMaster")
	private List<StudentSection> studentSections;

	//bi-directional many-to-one association to StudentSubject
	@OneToMany(mappedBy="studentMaster")
	private List<StudentSubject> studentSubjects;

	public StudentMaster() {
	}

	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	public String getStudentDescription() {
		return this.studentDescription;
	}

	public void setStudentDescription(String studentDescription) {
		this.studentDescription = studentDescription;
	}

	public String getStudentFirstname() {
		return this.studentFirstname;
	}

	public void setStudentFirstname(String studentFirstname) {
		this.studentFirstname = studentFirstname;
	}

	public String getStudentLastname() {
		return this.studentLastname;
	}

	public void setStudentLastname(String studentLastname) {
		this.studentLastname = studentLastname;
	}

	public String getStudentMiddlename() {
		return this.studentMiddlename;
	}

	public void setStudentMiddlename(String studentMiddlename) {
		this.studentMiddlename = studentMiddlename;
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

	public List<StudentSection> getStudentSections() {
		return this.studentSections;
	}

	public void setStudentSections(List<StudentSection> studentSections) {
		this.studentSections = studentSections;
	}

	public StudentSection addStudentSection(StudentSection studentSection) {
		getStudentSections().add(studentSection);
		studentSection.setStudentMaster(this);

		return studentSection;
	}

	public StudentSection removeStudentSection(StudentSection studentSection) {
		getStudentSections().remove(studentSection);
		studentSection.setStudentMaster(null);

		return studentSection;
	}

	public List<StudentSubject> getStudentSubjects() {
		return this.studentSubjects;
	}

	public void setStudentSubjects(List<StudentSubject> studentSubjects) {
		this.studentSubjects = studentSubjects;
	}

	public StudentSubject addStudentSubject(StudentSubject studentSubject) {
		getStudentSubjects().add(studentSubject);
		studentSubject.setStudentMaster(this);

		return studentSubject;
	}

	public StudentSubject removeStudentSubject(StudentSubject studentSubject) {
		getStudentSubjects().remove(studentSubject);
		studentSubject.setStudentMaster(null);

		return studentSubject;
	}

}