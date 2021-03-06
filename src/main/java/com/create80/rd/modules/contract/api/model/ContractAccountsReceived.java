package com.create80.rd.modules.contract.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ContractAccountsReceived implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.id
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.receivable_id
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    private String receivableId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.sn
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    private String sn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.name
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.accounts_received
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    private BigDecimal accountsReceived;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.accounts_received_percent
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    private Integer accountsReceivedPercent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.accounts_received_method
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    private String accountsReceivedMethod;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.accounts_received_date
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    private Date accountsReceivedDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.remarks
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.insert_by
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    private String insertBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.update_by
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.insert_time
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    private Date insertTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.update_time
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.is_deleted
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    private String isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ecm_contract_accounts_received
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.id
     *
     * @return the value of ecm_contract_accounts_received.id
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.id
     *
     * @param id the value for ecm_contract_accounts_received.id
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.receivable_id
     *
     * @return the value of ecm_contract_accounts_received.receivable_id
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public String getReceivableId() {
        return receivableId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.receivable_id
     *
     * @param receivableId the value for ecm_contract_accounts_received.receivable_id
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public void setReceivableId(String receivableId) {
        this.receivableId = receivableId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.sn
     *
     * @return the value of ecm_contract_accounts_received.sn
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public String getSn() {
        return sn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.sn
     *
     * @param sn the value for ecm_contract_accounts_received.sn
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public void setSn(String sn) {
        this.sn = sn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.name
     *
     * @return the value of ecm_contract_accounts_received.name
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.name
     *
     * @param name the value for ecm_contract_accounts_received.name
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.accounts_received
     *
     * @return the value of ecm_contract_accounts_received.accounts_received
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public BigDecimal getAccountsReceived() {
        return accountsReceived;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.accounts_received
     *
     * @param accountsReceived the value for ecm_contract_accounts_received.accounts_received
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public void setAccountsReceived(BigDecimal accountsReceived) {
        this.accountsReceived = accountsReceived;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.accounts_received_percent
     *
     * @return the value of ecm_contract_accounts_received.accounts_received_percent
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public Integer getAccountsReceivedPercent() {
        return accountsReceivedPercent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.accounts_received_percent
     *
     * @param accountsReceivedPercent the value for ecm_contract_accounts_received.accounts_received_percent
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public void setAccountsReceivedPercent(Integer accountsReceivedPercent) {
        this.accountsReceivedPercent = accountsReceivedPercent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.accounts_received_method
     *
     * @return the value of ecm_contract_accounts_received.accounts_received_method
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public String getAccountsReceivedMethod() {
        return accountsReceivedMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.accounts_received_method
     *
     * @param accountsReceivedMethod the value for ecm_contract_accounts_received.accounts_received_method
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public void setAccountsReceivedMethod(String accountsReceivedMethod) {
        this.accountsReceivedMethod = accountsReceivedMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.accounts_received_date
     *
     * @return the value of ecm_contract_accounts_received.accounts_received_date
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public Date getAccountsReceivedDate() {
        return accountsReceivedDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.accounts_received_date
     *
     * @param accountsReceivedDate the value for ecm_contract_accounts_received.accounts_received_date
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public void setAccountsReceivedDate(Date accountsReceivedDate) {
        this.accountsReceivedDate = accountsReceivedDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.remarks
     *
     * @return the value of ecm_contract_accounts_received.remarks
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.remarks
     *
     * @param remarks the value for ecm_contract_accounts_received.remarks
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.insert_by
     *
     * @return the value of ecm_contract_accounts_received.insert_by
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public String getInsertBy() {
        return insertBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.insert_by
     *
     * @param insertBy the value for ecm_contract_accounts_received.insert_by
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.update_by
     *
     * @return the value of ecm_contract_accounts_received.update_by
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.update_by
     *
     * @param updateBy the value for ecm_contract_accounts_received.update_by
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.insert_time
     *
     * @return the value of ecm_contract_accounts_received.insert_time
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.insert_time
     *
     * @param insertTime the value for ecm_contract_accounts_received.insert_time
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.update_time
     *
     * @return the value of ecm_contract_accounts_received.update_time
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.update_time
     *
     * @param updateTime the value for ecm_contract_accounts_received.update_time
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.is_deleted
     *
     * @return the value of ecm_contract_accounts_received.is_deleted
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.is_deleted
     *
     * @param isDeleted the value for ecm_contract_accounts_received.is_deleted
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ecm_contract_accounts_received
     *
     * @mbg.generated Thu Jun 21 09:54:05 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", receivableId=").append(receivableId);
        sb.append(", sn=").append(sn);
        sb.append(", name=").append(name);
        sb.append(", accountsReceived=").append(accountsReceived);
        sb.append(", accountsReceivedPercent=").append(accountsReceivedPercent);
        sb.append(", accountsReceivedMethod=").append(accountsReceivedMethod);
        sb.append(", accountsReceivedDate=").append(accountsReceivedDate);
        sb.append(", remarks=").append(remarks);
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