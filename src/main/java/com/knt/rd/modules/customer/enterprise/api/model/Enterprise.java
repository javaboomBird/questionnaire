package com.knt.rd.modules.customer.enterprise.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Enterprise implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.id
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.enterprise_name
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String enterpriseName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.lat
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private BigDecimal lat;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.lng
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private BigDecimal lng;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.usc_code
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String uscCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.legal_person
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String legalPerson;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.registered_capital
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private BigDecimal registeredCapital;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.registered_date
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private Date registeredDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.registered_address
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String registeredAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.registered_postcode
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private Integer registeredPostcode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.area_id
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String areaId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.business_scope
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String businessScope;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.business_phone
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String businessPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.business_fax
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String businessFax;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.bank_account
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String bankAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.bank_number
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String bankNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.bank_name
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String bankName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.tax_number
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String taxNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.tax_phone
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String taxPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.recycling_type
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String recyclingType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.status_type
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String statusType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.create_by
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.create_date
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.update_by
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.update_date
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.remarks
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise.del_flag
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String delFlag;

    private Area area;

    private User user;

    private User updateByUser;

    private List<EnterpriseBusinessTypeRelation> enterpriseBusinessTypeRelationList;

    private List<EnterpriseIndustryTypeRelation> enterpriseIndustryTypeRelationList;

    private List<EnterprisePollutionTypeRelation> enterprisePollutionTypeRelationList;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table enterprise
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.id
     *
     * @return the value of enterprise.id
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.id
     *
     * @param id the value for enterprise.id
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.enterprise_name
     *
     * @return the value of enterprise.enterprise_name
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getEnterpriseName() {
        return enterpriseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.enterprise_name
     *
     * @param enterpriseName the value for enterprise.enterprise_name
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.lat
     *
     * @return the value of enterprise.lat
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public BigDecimal getLat() {
        return lat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.lat
     *
     * @param lat the value for enterprise.lat
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.lng
     *
     * @return the value of enterprise.lng
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public BigDecimal getLng() {
        return lng;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.lng
     *
     * @param lng the value for enterprise.lng
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.usc_code
     *
     * @return the value of enterprise.usc_code
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getUscCode() {
        return uscCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.usc_code
     *
     * @param uscCode the value for enterprise.usc_code
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setUscCode(String uscCode) {
        this.uscCode = uscCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.legal_person
     *
     * @return the value of enterprise.legal_person
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.legal_person
     *
     * @param legalPerson the value for enterprise.legal_person
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.registered_capital
     *
     * @return the value of enterprise.registered_capital
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public BigDecimal getRegisteredCapital() {
        return registeredCapital;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.registered_capital
     *
     * @param registeredCapital the value for enterprise.registered_capital
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setRegisteredCapital(BigDecimal registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.registered_date
     *
     * @return the value of enterprise.registered_date
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public Date getRegisteredDate() {
        return registeredDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.registered_date
     *
     * @param registeredDate the value for enterprise.registered_date
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.registered_address
     *
     * @return the value of enterprise.registered_address
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getRegisteredAddress() {
        return registeredAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.registered_address
     *
     * @param registeredAddress the value for enterprise.registered_address
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.registered_postcode
     *
     * @return the value of enterprise.registered_postcode
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public Integer getRegisteredPostcode() {
        return registeredPostcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.registered_postcode
     *
     * @param registeredPostcode the value for enterprise.registered_postcode
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setRegisteredPostcode(Integer registeredPostcode) {
        this.registeredPostcode = registeredPostcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.area_id
     *
     * @return the value of enterprise.area_id
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.area_id
     *
     * @param areaId the value for enterprise.area_id
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.business_scope
     *
     * @return the value of enterprise.business_scope
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getBusinessScope() {
        return businessScope;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.business_scope
     *
     * @param businessScope the value for enterprise.business_scope
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.business_phone
     *
     * @return the value of enterprise.business_phone
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getBusinessPhone() {
        return businessPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.business_phone
     *
     * @param businessPhone the value for enterprise.business_phone
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.business_fax
     *
     * @return the value of enterprise.business_fax
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getBusinessFax() {
        return businessFax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.business_fax
     *
     * @param businessFax the value for enterprise.business_fax
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setBusinessFax(String businessFax) {
        this.businessFax = businessFax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.bank_account
     *
     * @return the value of enterprise.bank_account
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.bank_account
     *
     * @param bankAccount the value for enterprise.bank_account
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.bank_number
     *
     * @return the value of enterprise.bank_number
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getBankNumber() {
        return bankNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.bank_number
     *
     * @param bankNumber the value for enterprise.bank_number
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.bank_name
     *
     * @return the value of enterprise.bank_name
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.bank_name
     *
     * @param bankName the value for enterprise.bank_name
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.tax_number
     *
     * @return the value of enterprise.tax_number
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getTaxNumber() {
        return taxNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.tax_number
     *
     * @param taxNumber the value for enterprise.tax_number
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.tax_phone
     *
     * @return the value of enterprise.tax_phone
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getTaxPhone() {
        return taxPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.tax_phone
     *
     * @param taxPhone the value for enterprise.tax_phone
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setTaxPhone(String taxPhone) {
        this.taxPhone = taxPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.recycling_type
     *
     * @return the value of enterprise.recycling_type
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getRecyclingType() {
        return recyclingType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.recycling_type
     *
     * @param recyclingType the value for enterprise.recycling_type
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setRecyclingType(String recyclingType) {
        this.recyclingType = recyclingType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.status_type
     *
     * @return the value of enterprise.status_type
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getStatusType() {
        return statusType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.status_type
     *
     * @param statusType the value for enterprise.status_type
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.create_by
     *
     * @return the value of enterprise.create_by
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.create_by
     *
     * @param createBy the value for enterprise.create_by
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.create_date
     *
     * @return the value of enterprise.create_date
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.create_date
     *
     * @param createDate the value for enterprise.create_date
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.update_by
     *
     * @return the value of enterprise.update_by
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.update_by
     *
     * @param updateBy the value for enterprise.update_by
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.update_date
     *
     * @return the value of enterprise.update_date
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.update_date
     *
     * @param updateDate the value for enterprise.update_date
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.remarks
     *
     * @return the value of enterprise.remarks
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.remarks
     *
     * @param remarks the value for enterprise.remarks
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise.del_flag
     *
     * @return the value of enterprise.del_flag
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise.del_flag
     *
     * @param delFlag the value for enterprise.del_flag
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area=area;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }

    public User getUpdateByUser() {
        return updateByUser;
    }

    public void setUpdateByUser(User updateByUser) {
        this.updateByUser=updateByUser;
    }

    public List<EnterpriseBusinessTypeRelation> getEnterpriseBusinessTypeRelationList() {
        return enterpriseBusinessTypeRelationList;
    }

    public void setEnterpriseBusinessTypeRelationList(List<EnterpriseBusinessTypeRelation> enterpriseBusinessTypeRelationList) {
        this.enterpriseBusinessTypeRelationList=enterpriseBusinessTypeRelationList;
    }

    public List<EnterpriseIndustryTypeRelation> getEnterpriseIndustryTypeRelationList() {
        return enterpriseIndustryTypeRelationList;
    }

    public void setEnterpriseIndustryTypeRelationList(List<EnterpriseIndustryTypeRelation> enterpriseIndustryTypeRelationList) {
        this.enterpriseIndustryTypeRelationList=enterpriseIndustryTypeRelationList;
    }

    public List<EnterprisePollutionTypeRelation> getEnterprisePollutionTypeRelationList() {
        return enterprisePollutionTypeRelationList;
    }

    public void setEnterprisePollutionTypeRelationList(List<EnterprisePollutionTypeRelation> enterprisePollutionTypeRelationList) {
        this.enterprisePollutionTypeRelationList=enterprisePollutionTypeRelationList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", enterpriseName=").append(enterpriseName);
        sb.append(", lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append(", uscCode=").append(uscCode);
        sb.append(", legalPerson=").append(legalPerson);
        sb.append(", registeredCapital=").append(registeredCapital);
        sb.append(", registeredDate=").append(registeredDate);
        sb.append(", registeredAddress=").append(registeredAddress);
        sb.append(", registeredPostcode=").append(registeredPostcode);
        sb.append(", areaId=").append(areaId);
        sb.append(", businessScope=").append(businessScope);
        sb.append(", businessPhone=").append(businessPhone);
        sb.append(", businessFax=").append(businessFax);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", bankNumber=").append(bankNumber);
        sb.append(", bankName=").append(bankName);
        sb.append(", taxNumber=").append(taxNumber);
        sb.append(", taxPhone=").append(taxPhone);
        sb.append(", recyclingType=").append(recyclingType);
        sb.append(", statusType=").append(statusType);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", area=").append(area);
        sb.append(", user=").append(user);
        sb.append(", updateByUser=").append(updateByUser);
        sb.append(", enterpriseBusinessTypeRelationList=").append(enterpriseBusinessTypeRelationList);
        sb.append(", enterpriseIndustryTypeRelationList=").append(enterpriseIndustryTypeRelationList);
        sb.append(", enterprisePollutionTypeRelationList=").append(enterprisePollutionTypeRelationList);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}