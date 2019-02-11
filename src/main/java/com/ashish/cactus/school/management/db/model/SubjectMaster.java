package com.ashish.cactus.school.management.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the subject_master database table.
 * 
 */
@Entity
@Table(name="subject_master")
@NamedQuery(name="SubjectMaster.findAll", query="SELECT s FROM SubjectMaster s")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class SubjectMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subject_id", unique=true, nullable=false)
	private int subjectId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user", length=50)
	private String createUser;

	@Column(name="delete_ind", length=2)
	private String deleteInd;

	@Column(name="delete_reason", length=50)
	private String deleteReason;

	@Column(name="subject_description", length=50)
	private String subjectDescription;

	@Temporal(TemporalType.DATE)
	@Column(name="subject_enddate")
	private Date subjectEnddate;

	@Column(name="subject_name", length=50)
	private String subjectName;

	@Temporal(TemporalType.DATE)
	@Column(name="subject_startdate")
	private Date subjectStartdate;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user", length=50)
	private String updateUser;

	//bi-directional many-to-one association to StudentSubject
	@OneToMany(mappedBy="subjectMaster")
	private List<StudentSubject> studentSubjects;

	//bi-directional many-to-one association to ClassMaster
	@ManyToOne
	@JoinColumn(name="class_id")
	private ClassMaster classMaster;

	//bi-directional many-to-one association to TeacherSubject
	@OneToMany(mappedBy="subjectMaster")
	private List<TeacherSubject> teacherSubjects;

	public SubjectMaster() {
	}

	public int getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
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

	public String getSubjectDescription() {
		return this.subjectDescription;
	}

	public void setSubjectDescription(String subjectDescription) {
		this.subjectDescription = subjectDescription;
	}

	public Date getSubjectEnddate() {
		return this.subjectEnddate;
	}

	public void setSubjectEnddate(Date subjectEnddate) {
		this.subjectEnddate = subjectEnddate;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Date getSubjectStartdate() {
		return this.subjectStartdate;
	}

	public void setSubjectStartdate(Date subjectStartdate) {
		this.subjectStartdate = subjectStartdate;
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

	public List<StudentSubject> getStudentSubjects() {
		return this.studentSubjects;
	}

	public void setStudentSubjects(List<StudentSubject> studentSubjects) {
		this.studentSubjects = studentSubjects;
	}

	public StudentSubject addStudentSubject(StudentSubject studentSubject) {
		getStudentSubjects().add(studentSubject);
		studentSubject.setSubjectMaster(this);

		return studentSubject;
	}

	public StudentSubject removeStudentSubject(StudentSubject studentSubject) {
		getStudentSubjects().remove(studentSubject);
		studentSubject.setSubjectMaster(null);

		return studentSubject;
	}

	public ClassMaster getClassMaster() {
		return this.classMaster;
	}

	public void setClassMaster(ClassMaster classMaster) {
		this.classMaster = classMaster;
	}

	public List<TeacherSubject> getTeacherSubjects() {
		return this.teacherSubjects;
	}

	public void setTeacherSubjects(List<TeacherSubject> teacherSubjects) {
		this.teacherSubjects = teacherSubjects;
	}

	public TeacherSubject addTeacherSubject(TeacherSubject teacherSubject) {
		getTeacherSubjects().add(teacherSubject);
		teacherSubject.setSubjectMaster(this);

		return teacherSubject;
	}

	public TeacherSubject removeTeacherSubject(TeacherSubject teacherSubject) {
		getTeacherSubjects().remove(teacherSubject);
		teacherSubject.setSubjectMaster(null);

		return teacherSubject;
	}

}