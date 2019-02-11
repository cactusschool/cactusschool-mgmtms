package com.ashish.cactus.school.management.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the notice_master database table.
 * 
 */
@Entity
@Table(name="notice_master")
@NamedQuery(name="NoticeMaster.findAll", query="SELECT n FROM NoticeMaster n")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class NoticeMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="notice_id", unique=true, nullable=false)
	private int noticeId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_user", length=50)
	private String createUser;

	@Column(name="delete_description", length=100)
	private String deleteDescription;

	@Column(name="delete_ind", length=2)
	private String deleteInd;

	@Lob
	@Column(name="notice_content")
	private byte[] noticeContent;

	@Column(name="notice_description", length=500)
	private String noticeDescription;

	@Column(name="notice_enddate")
	private Timestamp noticeEnddate;

	@Column(name="notice_name", length=100)
	private String noticeName;

	@Column(name="notice_startdate")
	private Timestamp noticeStartdate;

	@Column(name="update_date")
	private Timestamp updateDate;

	@Column(name="update_user", length=50)
	private String updateUser;

	//bi-directional many-to-one association to ClassMaster
	@ManyToOne
	@JoinColumn(name="class_id")
	private ClassMaster classMaster;

	//bi-directional many-to-one association to SectionMaster
	@ManyToOne
	@JoinColumn(name="section_id")
	private SectionMaster sectionMaster;

	//bi-directional many-to-one association to NoticeReference
	@OneToMany(mappedBy="noticeMaster")
	private List<NoticeReference> noticeReferences;

	public NoticeMaster() {
	}

	public int getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
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

	public byte[] getNoticeContent() {
		return this.noticeContent;
	}

	public void setNoticeContent(byte[] noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeDescription() {
		return this.noticeDescription;
	}

	public void setNoticeDescription(String noticeDescription) {
		this.noticeDescription = noticeDescription;
	}

	public Timestamp getNoticeEnddate() {
		return this.noticeEnddate;
	}

	public void setNoticeEnddate(Timestamp noticeEnddate) {
		this.noticeEnddate = noticeEnddate;
	}

	public String getNoticeName() {
		return this.noticeName;
	}

	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}

	public Timestamp getNoticeStartdate() {
		return this.noticeStartdate;
	}

	public void setNoticeStartdate(Timestamp noticeStartdate) {
		this.noticeStartdate = noticeStartdate;
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

	public ClassMaster getClassMaster() {
		return this.classMaster;
	}

	public void setClassMaster(ClassMaster classMaster) {
		this.classMaster = classMaster;
	}

	public SectionMaster getSectionMaster() {
		return this.sectionMaster;
	}

	public void setSectionMaster(SectionMaster sectionMaster) {
		this.sectionMaster = sectionMaster;
	}

	public List<NoticeReference> getNoticeReferences() {
		return this.noticeReferences;
	}

	public void setNoticeReferences(List<NoticeReference> noticeReferences) {
		this.noticeReferences = noticeReferences;
	}

	public NoticeReference addNoticeReference(NoticeReference noticeReference) {
		getNoticeReferences().add(noticeReference);
		noticeReference.setNoticeMaster(this);

		return noticeReference;
	}

	public NoticeReference removeNoticeReference(NoticeReference noticeReference) {
		getNoticeReferences().remove(noticeReference);
		noticeReference.setNoticeMaster(null);

		return noticeReference;
	}

}