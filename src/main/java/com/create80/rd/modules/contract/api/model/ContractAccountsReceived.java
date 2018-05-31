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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.receivable_id
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    private String receivableId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.sn
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    private String sn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.name
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.accounts_received
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    private BigDecimal accountsReceived;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.accounts_received_percent
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    private Integer accountsReceivedPercent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.accounts_received_method
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    private String accountsReceivedMethod;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.accounts_received_date
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    private Date accountsReceivedDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.remarks
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.create_by
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.update_by
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.create_date
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.update_date
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract_accounts_received.del_flag
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    private String delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ecm_contract_accounts_received
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.id
     *
     * @return the value of ecm_contract_accounts_received.id
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.create_by
     *
     * @return the value of ecm_contract_accounts_received.create_by
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.create_by
     *
     * @param createBy the value for ecm_contract_accounts_received.create_by
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.update_by
     *
     * @return the value of ecm_contract_accounts_received.update_by
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.create_date
     *
     * @return the value of ecm_contract_accounts_received.create_date
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.create_date
     *
     * @param createDate the value for ecm_contract_accounts_received.create_date
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.update_date
     *
     * @return the value of ecm_contract_accounts_received.update_date
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.update_date
     *
     * @param updateDate the value for ecm_contract_accounts_received.update_date
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract_accounts_received.del_flag
     *
     * @return the value of ecm_contract_accounts_received.del_flag
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract_accounts_received.del_flag
     *
     * @param delFlag the value for ecm_contract_accounts_received.del_flag
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ecm_contract_accounts_received
     *
     * @mbg.generated Thu May 31 11:02:42 CST 2018
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
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}