package com.create80.rd.modules.contract.api.model;

import java.io.Serializable;
import java.util.Date;

public class ContractAttachment implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_attachment.id
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_attachment.contract_id
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String contractId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_attachment.description
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_attachment.name
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_attachment.type
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_attachment.path
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String path;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_attachment.insert_by
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String insertBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_attachment.update_by
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_attachment.insert_time
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private Date insertTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_attachment.update_time
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_attachment.is_deleted
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ecm_contract_attachment
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_attachment.id
     *
     * @return the value of ecm_contract_attachment.id
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_attachment.id
     *
     * @param id the value for ecm_contract_attachment.id
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_attachment.contract_id
     *
     * @return the value of ecm_contract_attachment.contract_id
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_attachment.contract_id
     *
     * @param contractId the value for ecm_contract_attachment.contract_id
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_attachment.description
     *
     * @return the value of ecm_contract_attachment.description
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_attachment.description
     *
     * @param description the value for ecm_contract_attachment.description
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_attachment.name
     *
     * @return the value of ecm_contract_attachment.name
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_attachment.name
     *
     * @param name the value for ecm_contract_attachment.name
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_attachment.type
     *
     * @return the value of ecm_contract_attachment.type
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_attachment.type
     *
     * @param type the value for ecm_contract_attachment.type
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_attachment.path
     *
     * @return the value of ecm_contract_attachment.path
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_attachment.path
     *
     * @param path the value for ecm_contract_attachment.path
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_attachment.insert_by
     *
     * @return the value of ecm_contract_attachment.insert_by
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getInsertBy() {
        return insertBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_attachment.insert_by
     *
     * @param insertBy the value for ecm_contract_attachment.insert_by
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_attachment.update_by
     *
     * @return the value of ecm_contract_attachment.update_by
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_attachment.update_by
     *
     * @param updateBy the value for ecm_contract_attachment.update_by
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_attachment.insert_time
     *
     * @return the value of ecm_contract_attachment.insert_time
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_attachment.insert_time
     *
     * @param insertTime the value for ecm_contract_attachment.insert_time
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_attachment.update_time
     *
     * @return the value of ecm_contract_attachment.update_time
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_attachment.update_time
     *
     * @param updateTime the value for ecm_contract_attachment.update_time
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_attachment.is_deleted
     *
     * @return the value of ecm_contract_attachment.is_deleted
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_attachment.is_deleted
     *
     * @param isDeleted the value for ecm_contract_attachment.is_deleted
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ecm_contract_attachment
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", contractId=").append(contractId);
        sb.append(", description=").append(description);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", path=").append(path);
        sb.append(", insertBy=").append(insertBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", insertTime=").append(insertTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}