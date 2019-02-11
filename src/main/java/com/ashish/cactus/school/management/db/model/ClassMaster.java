package com.ashish.cactus.school.management.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the class_master database table.
 * 
 */
@Entity
@Table(name="class_master")
@NamedQuery(name="ClassMaster.findAll", query="SELECT c FROM ClassMaster c")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class ClassMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="class_id", unique=true, nullable=false)
	private int classId;

	@Column(name="class_description", length=100)
	private String classDescription;

	@Column(name="class_name", length=50)
	private String className;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user", length=50)
	private String createUser;

	@Column(name="delete_date")
	private Timestamp deleteDate;

	@Column(name="delete_description", length=100)
	private String deleteDescription;

	@Column(name="delete_ind", length=2)
	private String deleteInd;

	@Column(name="delete_user", length=50)
	private String deleteUser;

	@Temporal(TemporalType.DATE)
	@Column(name="section_enddate")
	private Date sectionEnddate;

	@Temporal(TemporalType.DATE)
	@Column(name="section_startdate")
	private Date sectionStartdate;

	//bi-directional many-to-one association to NoticeMaster
	@OneToMany(mappedBy="classMaster")
	private List<NoticeMaster> noticeMasters;

	//bi-directional many-to-one association to SectionMaster
	@OneToMany(mappedBy="classMaster")
	private List<SectionMaster> sectionMasters;

	//bi-directional many-to-one association to SubjectMaster
	@OneToMany(mappedBy="classMaster")
	private List<SubjectMaster> subjectMasters;

	public ClassMaster() {
	}

	public int getClassId() {
		return this.classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassDescription() {
		return this.classDescription;
	}

	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
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

	public Timestamp getDeleteDate() {
		return this.deleteDate;
	}

	public void setDeleteDate(Timestamp deleteDate) {
		this.deleteDate = deleteDate;
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

	public String getDeleteUser() {
		return this.deleteUser;
	}

	public void setDeleteUser(String deleteUser) {
		this.deleteUser = deleteUser;
	}

	public Date getSectionEnddate() {
		return this.sectionEnddate;
	}

	public void setSectionEnddate(Date sectionEnddate) {
		this.sectionEnddate = sectionEnddate;
	}

	public Date getSectionStartdate() {
		return this.sectionStartdate;
	}

	public void setSectionStartdate(Date sectionStartdate) {
		this.sectionStartdate = sectionStartdate;
	}

	public List<NoticeMaster> getNoticeMasters() {
		return this.noticeMasters;
	}

	public void setNoticeMasters(List<NoticeMaster> noticeMasters) {
		this.noticeMasters = noticeMasters;
	}

	public NoticeMaster addNoticeMaster(NoticeMaster noticeMaster) {
		getNoticeMasters().add(noticeMaster);
		noticeMaster.setClassMaster(this);

		return noticeMaster;
	}

	public NoticeMaster removeNoticeMaster(NoticeMaster noticeMaster) {
		getNoticeMasters().remove(noticeMaster);
		noticeMaster.setClassMaster(null);

		return noticeMaster;
	}

	public List<SectionMaster> getSectionMasters() {
		return this.sectionMasters;
	}

	public void setSectionMasters(List<SectionMaster> sectionMasters) {
		this.sectionMasters = sectionMasters;
	}

	public SectionMaster addSectionMaster(SectionMaster sectionMaster) {
		getSectionMasters().add(sectionMaster);
		sectionMaster.setClassMaster(this);

		return sectionMaster;
	}

	public SectionMaster removeSectionMaster(SectionMaster sectionMaster) {
		getSectionMasters().remove(sectionMaster);
		sectionMaster.setClassMaster(null);

		return sectionMaster;
	}

	public List<SubjectMaster> getSubjectMasters() {
		return this.subjectMasters;
	}

	public void setSubjectMasters(List<SubjectMaster> subjectMasters) {
		this.subjectMasters = subjectMasters;
	}

	public SubjectMaster addSubjectMaster(SubjectMaster subjectMaster) {
		getSubjectMasters().add(subjectMaster);
		subjectMaster.setClassMaster(this);

		return subjectMaster;
	}

	public SubjectMaster removeSubjectMaster(SubjectMaster subjectMaster) {
		getSubjectMasters().remove(subjectMaster);
		subjectMaster.setClassMaster(null);

		return subjectMaster;
	}

}