package com.ashish.cactus.school.management.admin.db.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Where;


/**
 * The persistent class for the school_master database table.
 * 
 */
@Entity
@Table(name="school_master")
@NamedQuery(name="AdminSchoolMaster.findAll", query="SELECT s FROM AdminSchoolMaster s")
@Where(clause="delete_ind is NULL or delete_ind='N'")
public class AdminSchoolMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="school_id", unique=true, nullable=false)
	private int schoolId;

	@Column(name="address_id", nullable=false)
	private int addressId;

	@Column(name="context_root", nullable=false, length=50)
	private String contextRoot;

	@Column(name="contract_id", nullable=false)
	private int contractId;

	@Column(name="create_date", nullable=false)
	private Timestamp createDate;

	@Column(name="create_user", nullable=false, length=100)
	private String createUser;

	@Column(name="db_name", nullable=false, length=50)
	private String dbName;

	@Column(name="delete_ind", nullable=false, length=2)
	private String deleteInd;

	@Column(name="delete_reason", nullable=false, length=100)
	private String deleteReason;

	@Column(name="school_code", nullable=false, length=50)
	private String schoolCode;

	@Column(name="school_group_name", length=150)
	private String schoolGroupName;

	@Column(name="school_name", nullable=false, length=150)
	private String schoolName;

	@Column(name="school_parent_id", nullable=false)
	private int schoolParentId;

	@Column(name="sms_sender_id", nullable=false, length=50)
	private String smsSenderId;

	@Column(name="update_date", nullable=false)
	private Timestamp updateDate;

	@Column(name="update_user", nullable=false, length=100)
	private String updateUser;

	public AdminSchoolMaster() {
	}

	public int getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getContextRoot() {
		return this.contextRoot;
	}

	public void setContextRoot(String contextRoot) {
		this.contextRoot = contextRoot;
	}

	public int getContractId() {
		return this.contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
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

	public String getDbName() {
		return this.dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
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

	public String getSchoolCode() {
		return this.schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolGroupName() {
		return this.schoolGroupName;
	}

	public void setSchoolGroupName(String schoolGroupName) {
		this.schoolGroupName = schoolGroupName;
	}

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getSchoolParentId() {
		return this.schoolParentId;
	}

	public void setSchoolParentId(int schoolParentId) {
		this.schoolParentId = schoolParentId;
	}

	public String getSmsSenderId() {
		return this.smsSenderId;
	}

	public void setSmsSenderId(String smsSenderId) {
		this.smsSenderId = smsSenderId;
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
}