package com.ashish.cactus.school.management.db.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the attachment_master database table.
 * 
 */
@Entity
@Table(name="attachment_master")
@NamedQuery(name="AttachmentMaster.findAll", query="SELECT a FROM AttachmentMaster a")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class AttachmentMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="attachment_id", unique=true, nullable=false)
	private int attachmentId;

	@Column(name="attachment_description", length=200)
	private String attachmentDescription;

	@Column(name="attachment_name", length=100)
	private String attachmentName;

	@Column(name="attachment_path", length=500)
	private String attachmentPath;

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

	//bi-directional many-to-one association to NoticeReference
	@OneToMany(mappedBy="attachmentMaster")
	private List<NoticeReference> noticeReferences;

	public AttachmentMaster() {
	}

	public int getAttachmentId() {
		return this.attachmentId;
	}

	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getAttachmentDescription() {
		return this.attachmentDescription;
	}

	public void setAttachmentDescription(String attachmentDescription) {
		this.attachmentDescription = attachmentDescription;
	}

	public String getAttachmentName() {
		return this.attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentPath() {
		return this.attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
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

	public List<NoticeReference> getNoticeReferences() {
		return this.noticeReferences;
	}

	public void setNoticeReferences(List<NoticeReference> noticeReferences) {
		this.noticeReferences = noticeReferences;
	}

	public NoticeReference addNoticeReference(NoticeReference noticeReference) {
		getNoticeReferences().add(noticeReference);
		noticeReference.setAttachmentMaster(this);

		return noticeReference;
	}

	public NoticeReference removeNoticeReference(NoticeReference noticeReference) {
		getNoticeReferences().remove(noticeReference);
		noticeReference.setAttachmentMaster(null);

		return noticeReference;
	}

}