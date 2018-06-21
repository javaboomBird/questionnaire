package com.create80.rd.modules.contract.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Contract implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.id
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.project_id
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String projectId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.supplemental
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private Boolean supplemental;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.virtual
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private Boolean virtual;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.major_contract_id
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String majorContractId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.project_name
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String projectName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.status
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.type
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.level
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.contract_total_price
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private BigDecimal contractTotalPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.project_total_price
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private BigDecimal projectTotalPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.maintain_total_price
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private BigDecimal maintainTotalPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.signing_date
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private Date signingDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.valid_date
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private Date validDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.first_party
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String firstParty;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.first_party_contact
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String firstPartyContact;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.first_party_contact_phone
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String firstPartyContactPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.second_party
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String secondParty;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.second_party_contact
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String secondPartyContact;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.second_party_contact_phone
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String secondPartyContactPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.third_party
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String thirdParty;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.third_party_contact
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String thirdPartyContact;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.third_party_contact_phone
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String thirdPartyContactPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.delivery_place
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String deliveryPlace;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.service_term
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String serviceTerm;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.service_start_date
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private Date serviceStartDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.service_end_date
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private Date serviceEndDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.agent
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String agent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.remarks
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.insert_by
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String insertBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.update_by
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.insert_time
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private Date insertTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.update_time
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_contract.is_deleted
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private String isDeleted;

    private List<ContractAttachment> contractAttachmentList;

    private List<ContractGood> contractGoodList;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ecm_contract
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.id
     *
     * @return the value of ecm_contract.id
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.id
     *
     * @param id the value for ecm_contract.id
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.project_id
     *
     * @return the value of ecm_contract.project_id
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.project_id
     *
     * @param projectId the value for ecm_contract.project_id
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.supplemental
     *
     * @return the value of ecm_contract.supplemental
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public Boolean getSupplemental() {
        return supplemental;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.supplemental
     *
     * @param supplemental the value for ecm_contract.supplemental
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setSupplemental(Boolean supplemental) {
        this.supplemental = supplemental;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.virtual
     *
     * @return the value of ecm_contract.virtual
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public Boolean getVirtual() {
        return virtual;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.virtual
     *
     * @param virtual the value for ecm_contract.virtual
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setVirtual(Boolean virtual) {
        this.virtual = virtual;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.major_contract_id
     *
     * @return the value of ecm_contract.major_contract_id
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getMajorContractId() {
        return majorContractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.major_contract_id
     *
     * @param majorContractId the value for ecm_contract.major_contract_id
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setMajorContractId(String majorContractId) {
        this.majorContractId = majorContractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.project_name
     *
     * @return the value of ecm_contract.project_name
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.project_name
     *
     * @param projectName the value for ecm_contract.project_name
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.status
     *
     * @return the value of ecm_contract.status
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.status
     *
     * @param status the value for ecm_contract.status
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.type
     *
     * @return the value of ecm_contract.type
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.type
     *
     * @param type the value for ecm_contract.type
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.level
     *
     * @return the value of ecm_contract.level
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.level
     *
     * @param level the value for ecm_contract.level
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.contract_total_price
     *
     * @return the value of ecm_contract.contract_total_price
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public BigDecimal getContractTotalPrice() {
        return contractTotalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.contract_total_price
     *
     * @param contractTotalPrice the value for ecm_contract.contract_total_price
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setContractTotalPrice(BigDecimal contractTotalPrice) {
        this.contractTotalPrice = contractTotalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.project_total_price
     *
     * @return the value of ecm_contract.project_total_price
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public BigDecimal getProjectTotalPrice() {
        return projectTotalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.project_total_price
     *
     * @param projectTotalPrice the value for ecm_contract.project_total_price
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setProjectTotalPrice(BigDecimal projectTotalPrice) {
        this.projectTotalPrice = projectTotalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.maintain_total_price
     *
     * @return the value of ecm_contract.maintain_total_price
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public BigDecimal getMaintainTotalPrice() {
        return maintainTotalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.maintain_total_price
     *
     * @param maintainTotalPrice the value for ecm_contract.maintain_total_price
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setMaintainTotalPrice(BigDecimal maintainTotalPrice) {
        this.maintainTotalPrice = maintainTotalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.signing_date
     *
     * @return the value of ecm_contract.signing_date
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public Date getSigningDate() {
        return signingDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.signing_date
     *
     * @param signingDate the value for ecm_contract.signing_date
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setSigningDate(Date signingDate) {
        this.signingDate = signingDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.valid_date
     *
     * @return the value of ecm_contract.valid_date
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public Date getValidDate() {
        return validDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.valid_date
     *
     * @param validDate the value for ecm_contract.valid_date
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.first_party
     *
     * @return the value of ecm_contract.first_party
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getFirstParty() {
        return firstParty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.first_party
     *
     * @param firstParty the value for ecm_contract.first_party
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setFirstParty(String firstParty) {
        this.firstParty = firstParty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.first_party_contact
     *
     * @return the value of ecm_contract.first_party_contact
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getFirstPartyContact() {
        return firstPartyContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.first_party_contact
     *
     * @param firstPartyContact the value for ecm_contract.first_party_contact
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setFirstPartyContact(String firstPartyContact) {
        this.firstPartyContact = firstPartyContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.first_party_contact_phone
     *
     * @return the value of ecm_contract.first_party_contact_phone
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getFirstPartyContactPhone() {
        return firstPartyContactPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.first_party_contact_phone
     *
     * @param firstPartyContactPhone the value for ecm_contract.first_party_contact_phone
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setFirstPartyContactPhone(String firstPartyContactPhone) {
        this.firstPartyContactPhone = firstPartyContactPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.second_party
     *
     * @return the value of ecm_contract.second_party
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getSecondParty() {
        return secondParty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.second_party
     *
     * @param secondParty the value for ecm_contract.second_party
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setSecondParty(String secondParty) {
        this.secondParty = secondParty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.second_party_contact
     *
     * @return the value of ecm_contract.second_party_contact
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getSecondPartyContact() {
        return secondPartyContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.second_party_contact
     *
     * @param secondPartyContact the value for ecm_contract.second_party_contact
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setSecondPartyContact(String secondPartyContact) {
        this.secondPartyContact = secondPartyContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.second_party_contact_phone
     *
     * @return the value of ecm_contract.second_party_contact_phone
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getSecondPartyContactPhone() {
        return secondPartyContactPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.second_party_contact_phone
     *
     * @param secondPartyContactPhone the value for ecm_contract.second_party_contact_phone
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setSecondPartyContactPhone(String secondPartyContactPhone) {
        this.secondPartyContactPhone = secondPartyContactPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.third_party
     *
     * @return the value of ecm_contract.third_party
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getThirdParty() {
        return thirdParty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.third_party
     *
     * @param thirdParty the value for ecm_contract.third_party
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setThirdParty(String thirdParty) {
        this.thirdParty = thirdParty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.third_party_contact
     *
     * @return the value of ecm_contract.third_party_contact
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getThirdPartyContact() {
        return thirdPartyContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.third_party_contact
     *
     * @param thirdPartyContact the value for ecm_contract.third_party_contact
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setThirdPartyContact(String thirdPartyContact) {
        this.thirdPartyContact = thirdPartyContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.third_party_contact_phone
     *
     * @return the value of ecm_contract.third_party_contact_phone
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getThirdPartyContactPhone() {
        return thirdPartyContactPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.third_party_contact_phone
     *
     * @param thirdPartyContactPhone the value for ecm_contract.third_party_contact_phone
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setThirdPartyContactPhone(String thirdPartyContactPhone) {
        this.thirdPartyContactPhone = thirdPartyContactPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.delivery_place
     *
     * @return the value of ecm_contract.delivery_place
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.delivery_place
     *
     * @param deliveryPlace the value for ecm_contract.delivery_place
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.service_term
     *
     * @return the value of ecm_contract.service_term
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getServiceTerm() {
        return serviceTerm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.service_term
     *
     * @param serviceTerm the value for ecm_contract.service_term
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setServiceTerm(String serviceTerm) {
        this.serviceTerm = serviceTerm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.service_start_date
     *
     * @return the value of ecm_contract.service_start_date
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public Date getServiceStartDate() {
        return serviceStartDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.service_start_date
     *
     * @param serviceStartDate the value for ecm_contract.service_start_date
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setServiceStartDate(Date serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.service_end_date
     *
     * @return the value of ecm_contract.service_end_date
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public Date getServiceEndDate() {
        return serviceEndDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.service_end_date
     *
     * @param serviceEndDate the value for ecm_contract.service_end_date
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setServiceEndDate(Date serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.agent
     *
     * @return the value of ecm_contract.agent
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getAgent() {
        return agent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.agent
     *
     * @param agent the value for ecm_contract.agent
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setAgent(String agent) {
        this.agent = agent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.remarks
     *
     * @return the value of ecm_contract.remarks
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.remarks
     *
     * @param remarks the value for ecm_contract.remarks
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.insert_by
     *
     * @return the value of ecm_contract.insert_by
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getInsertBy() {
        return insertBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.insert_by
     *
     * @param insertBy the value for ecm_contract.insert_by
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.update_by
     *
     * @return the value of ecm_contract.update_by
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.update_by
     *
     * @param updateBy the value for ecm_contract.update_by
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.insert_time
     *
     * @return the value of ecm_contract.insert_time
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.insert_time
     *
     * @param insertTime the value for ecm_contract.insert_time
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.update_time
     *
     * @return the value of ecm_contract.update_time
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.update_time
     *
     * @param updateTime the value for ecm_contract.update_time
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_contract.is_deleted
     *
     * @return the value of ecm_contract.is_deleted
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_contract.is_deleted
     *
     * @param isDeleted the value for ecm_contract.is_deleted
     *
     * @mbg.generated Thu Jun 21 09:53:57 CST 2018
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<ContractAttachment> getContractAttachmentList() {
        return contractAttachmentList;
    }

    public void setContractAttachmentList(List<ContractAttachment> contractAttachmentList) {
        this.contractAttachmentList=contractAttachmentList;
    }

    public List<ContractGood> getContractGoodList() {
        return contractGoodList;
    }

    public void setContractGoodList(List<ContractGood> contractGoodList) {
        this.contractGoodList=contractGoodList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ecm_contract
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
        sb.append(", projectId=").append(projectId);
        sb.append(", supplemental=").append(supplemental);
        sb.append(", virtual=").append(virtual);
        sb.append(", majorContractId=").append(majorContractId);
        sb.append(", projectName=").append(projectName);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append(", level=").append(level);
        sb.append(", contractTotalPrice=").append(contractTotalPrice);
        sb.append(", projectTotalPrice=").append(projectTotalPrice);
        sb.append(", maintainTotalPrice=").append(maintainTotalPrice);
        sb.append(", signingDate=").append(signingDate);
        sb.append(", validDate=").append(validDate);
        sb.append(", firstParty=").append(firstParty);
        sb.append(", firstPartyContact=").append(firstPartyContact);
        sb.append(", firstPartyContactPhone=").append(firstPartyContactPhone);
        sb.append(", secondParty=").append(secondParty);
        sb.append(", secondPartyContact=").append(secondPartyContact);
        sb.append(", secondPartyContactPhone=").append(secondPartyContactPhone);
        sb.append(", thirdParty=").append(thirdParty);
        sb.append(", thirdPartyContact=").append(thirdPartyContact);
        sb.append(", thirdPartyContactPhone=").append(thirdPartyContactPhone);
        sb.append(", deliveryPlace=").append(deliveryPlace);
        sb.append(", serviceTerm=").append(serviceTerm);
        sb.append(", serviceStartDate=").append(serviceStartDate);
        sb.append(", serviceEndDate=").append(serviceEndDate);
        sb.append(", agent=").append(agent);
        sb.append(", remarks=").append(remarks);
        sb.append(", insertBy=").append(insertBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", insertTime=").append(insertTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", contractAttachmentList=").append(contractAttachmentList);
        sb.append(", contractGoodList=").append(contractGoodList);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}