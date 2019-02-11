package com.ashish.cactus.school.management.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the student_section database table.
 * 
 */
@Entity
@Table(name="student_section")
@NamedQuery(name="StudentSection.findAll", query="SELECT s FROM StudentSection s")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class StudentSection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_class_id", unique=true, nullable=false)
	private int studentClassId;

	@Temporal(TemporalType.DATE)
	@Column(name="class_end_date")
	private Date classEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="class_start_date")
	private Date classStartDate;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user", length=50)
	private String createUser;

	@Column(name="delete_ind", length=2)
	private String deleteInd;

	@Column(name="delete_reason", length=100)
	private String deleteReason;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user", length=50)
	private String updateUser;

	//bi-directional many-to-one association to SectionMaster
	@ManyToOne
	@JoinColumn(name="section_id")
	private SectionMaster sectionMaster;

	//bi-directional many-to-one association to StudentMaster
	@ManyToOne
	@JoinColumn(name="student_id")
	private StudentMaster studentMaster;

	public StudentSection() {
	}

	public int getStudentClassId() {
		return this.studentClassId;
	}

	public void setStudentClassId(int studentClassId) {
		this.studentClassId = studentClassId;
	}

	public Date getClassEndDate() {
		return this.classEndDate;
	}

	public void setClassEndDate(Date classEndDate) {
		this.classEndDate = classEndDate;
	}

	public Date getClassStartDate() {
		return this.classStartDate;
	}

	public void setClassStartDate(Date classStartDate) {
		this.classStartDate = classStartDate;
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

	public StudentMaster getStudentMaster() {
		return this.studentMaster;
	}

	public void setStudentMaster(StudentMaster studentMaster) {
		this.studentMaster = studentMaster;
	}

}