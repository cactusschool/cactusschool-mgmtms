package com.ashish.cactus.school.management.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the section_master database table.
 * 
 */
@Entity
@Table(name="section_master")
@NamedQuery(name="SectionMaster.findAll", query="SELECT s FROM SectionMaster s")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class SectionMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="section_id", unique=true, nullable=false)
	private int sectionId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user", length=50)
	private String createUser;

	@Column(name="delete_description", length=100)
	private String deleteDescription;

	@Column(name="delete_ind", length=2)
	private String deleteInd;

	@Column(name="section_descrition", length=100)
	private String sectionDescrition;

	@Temporal(TemporalType.DATE)
	@Column(name="section_enddate")
	private Date sectionEnddate;

	@Column(name="section_name", length=50)
	private String sectionName;

	@Temporal(TemporalType.DATE)
	@Column(name="section_startdate")
	private Date sectionStartdate;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user", length=50)
	private String updateUser;

	//bi-directional many-to-one association to NoticeMaster
	@OneToMany(mappedBy="sectionMaster")
	private List<NoticeMaster> noticeMasters;

	//bi-directional many-to-one association to ClassMaster
	@ManyToOne
	@JoinColumn(name="class_id")
	private ClassMaster classMaster;

	//bi-directional many-to-one association to StudentSection
	@OneToMany(mappedBy="sectionMaster")
	private List<StudentSection> studentSections;

	//bi-directional many-to-one association to TeacherSubject
	@OneToMany(mappedBy="sectionMaster")
	private List<TeacherSubject> teacherSubjects;

	public SectionMaster() {
	}

	public int getSectionId() {
		return this.sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
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

	public String getSectionDescrition() {
		return this.sectionDescrition;
	}

	public void setSectionDescrition(String sectionDescrition) {
		this.sectionDescrition = sectionDescrition;
	}

	public Date getSectionEnddate() {
		return this.sectionEnddate;
	}

	public void setSectionEnddate(Date sectionEnddate) {
		this.sectionEnddate = sectionEnddate;
	}

	public String getSectionName() {
		return this.sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Date getSectionStartdate() {
		return this.sectionStartdate;
	}

	public void setSectionStartdate(Date sectionStartdate) {
		this.sectionStartdate = sectionStartdate;
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

	public List<NoticeMaster> getNoticeMasters() {
		return this.noticeMasters;
	}

	public void setNoticeMasters(List<NoticeMaster> noticeMasters) {
		this.noticeMasters = noticeMasters;
	}

	public NoticeMaster addNoticeMaster(NoticeMaster noticeMaster) {
		getNoticeMasters().add(noticeMaster);
		noticeMaster.setSectionMaster(this);

		return noticeMaster;
	}

	public NoticeMaster removeNoticeMaster(NoticeMaster noticeMaster) {
		getNoticeMasters().remove(noticeMaster);
		noticeMaster.setSectionMaster(null);

		return noticeMaster;
	}

	public ClassMaster getClassMaster() {
		return this.classMaster;
	}

	public void setClassMaster(ClassMaster classMaster) {
		this.classMaster = classMaster;
	}

	public List<StudentSection> getStudentSections() {
		return this.studentSections;
	}

	public void setStudentSections(List<StudentSection> studentSections) {
		this.studentSections = studentSections;
	}

	public StudentSection addStudentSection(StudentSection studentSection) {
		getStudentSections().add(studentSection);
		studentSection.setSectionMaster(this);

		return studentSection;
	}

	public StudentSection removeStudentSection(StudentSection studentSection) {
		getStudentSections().remove(studentSection);
		studentSection.setSectionMaster(null);

		return studentSection;
	}

	public List<TeacherSubject> getTeacherSubjects() {
		return this.teacherSubjects;
	}

	public void setTeacherSubjects(List<TeacherSubject> teacherSubjects) {
		this.teacherSubjects = teacherSubjects;
	}

	public TeacherSubject addTeacherSubject(TeacherSubject teacherSubject) {
		getTeacherSubjects().add(teacherSubject);
		teacherSubject.setSectionMaster(this);

		return teacherSubject;
	}

	public TeacherSubject removeTeacherSubject(TeacherSubject teacherSubject) {
		getTeacherSubjects().remove(teacherSubject);
		teacherSubject.setSectionMaster(null);

		return teacherSubject;
	}

}