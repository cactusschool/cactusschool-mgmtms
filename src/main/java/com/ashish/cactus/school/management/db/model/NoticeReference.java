package com.ashish.cactus.school.management.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;


/**
 * The persistent class for the notice_reference database table.
 * 
 */
@Entity
@Table(name="notice_reference")
@NamedQuery(name="NoticeReference.findAll", query="SELECT n FROM NoticeReference n")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class NoticeReference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="notice_reference_id", unique=true, nullable=false)
	private int noticeReferenceId;

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

	//bi-directional many-to-one association to AttachmentMaster
	@ManyToOne
	@JoinColumn(name="attachment_id")
	private AttachmentMaster attachmentMaster;

	//bi-directional many-to-one association to NoticeMaster
	@ManyToOne
	@JoinColumn(name="notice_id")
	private NoticeMaster noticeMaster;

	public NoticeReference() {
	}

	public int getNoticeReferenceId() {
		return this.noticeReferenceId;
	}

	public void setNoticeReferenceId(int noticeReferenceId) {
		this.noticeReferenceId = noticeReferenceId;
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

	public AttachmentMaster getAttachmentMaster() {
		return this.attachmentMaster;
	}

	public void setAttachmentMaster(AttachmentMaster attachmentMaster) {
		this.attachmentMaster = attachmentMaster;
	}

	public NoticeMaster getNoticeMaster() {
		return this.noticeMaster;
	}

	public void setNoticeMaster(NoticeMaster noticeMaster) {
		this.noticeMaster = noticeMaster;
	}

}