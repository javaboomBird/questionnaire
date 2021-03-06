package com.create80.rd.modules.customer.eiareport.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CustomerEiaReport implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.id
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.customer_id
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String customerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.approved
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String approved;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.approve_date
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private Date approveDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.accepted
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String accepted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.accept_date
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private Date acceptDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.expanded
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String expanded;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.expended_device
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String expendedDevice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.pollution_type_id
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String pollutionTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.pollution_permit_status
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String pollutionPermitStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.report_file
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String reportFile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.insert_by
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String insertBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.insert_time
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private Date insertTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.update_by
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.update_time
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.remarks
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report.is_deleted
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String isDeleted;

    private List<CustomerEiaReportPic> customerEiaReportPicList;

    private List<CustomerEiaReportWaste> customerEiaReportWasteList;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table customer_eia_report
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.id
     *
     * @return the value of customer_eia_report.id
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.id
     *
     * @param id the value for customer_eia_report.id
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.customer_id
     *
     * @return the value of customer_eia_report.customer_id
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.customer_id
     *
     * @param customerId the value for customer_eia_report.customer_id
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.approved
     *
     * @return the value of customer_eia_report.approved
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getApproved() {
        return approved;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.approved
     *
     * @param approved the value for customer_eia_report.approved
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setApproved(String approved) {
        this.approved = approved;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.approve_date
     *
     * @return the value of customer_eia_report.approve_date
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public Date getApproveDate() {
        return approveDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.approve_date
     *
     * @param approveDate the value for customer_eia_report.approve_date
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.accepted
     *
     * @return the value of customer_eia_report.accepted
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getAccepted() {
        return accepted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.accepted
     *
     * @param accepted the value for customer_eia_report.accepted
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setAccepted(String accepted) {
        this.accepted = accepted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.accept_date
     *
     * @return the value of customer_eia_report.accept_date
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public Date getAcceptDate() {
        return acceptDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.accept_date
     *
     * @param acceptDate the value for customer_eia_report.accept_date
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.expanded
     *
     * @return the value of customer_eia_report.expanded
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getExpanded() {
        return expanded;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.expanded
     *
     * @param expanded the value for customer_eia_report.expanded
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setExpanded(String expanded) {
        this.expanded = expanded;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.expended_device
     *
     * @return the value of customer_eia_report.expended_device
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getExpendedDevice() {
        return expendedDevice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.expended_device
     *
     * @param expendedDevice the value for customer_eia_report.expended_device
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setExpendedDevice(String expendedDevice) {
        this.expendedDevice = expendedDevice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.pollution_type_id
     *
     * @return the value of customer_eia_report.pollution_type_id
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getPollutionTypeId() {
        return pollutionTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.pollution_type_id
     *
     * @param pollutionTypeId the value for customer_eia_report.pollution_type_id
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setPollutionTypeId(String pollutionTypeId) {
        this.pollutionTypeId = pollutionTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.pollution_permit_status
     *
     * @return the value of customer_eia_report.pollution_permit_status
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getPollutionPermitStatus() {
        return pollutionPermitStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.pollution_permit_status
     *
     * @param pollutionPermitStatus the value for customer_eia_report.pollution_permit_status
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setPollutionPermitStatus(String pollutionPermitStatus) {
        this.pollutionPermitStatus = pollutionPermitStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.report_file
     *
     * @return the value of customer_eia_report.report_file
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getReportFile() {
        return reportFile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.report_file
     *
     * @param reportFile the value for customer_eia_report.report_file
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setReportFile(String reportFile) {
        this.reportFile = reportFile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.insert_by
     *
     * @return the value of customer_eia_report.insert_by
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getInsertBy() {
        return insertBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.insert_by
     *
     * @param insertBy the value for customer_eia_report.insert_by
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.insert_time
     *
     * @return the value of customer_eia_report.insert_time
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.insert_time
     *
     * @param insertTime the value for customer_eia_report.insert_time
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.update_by
     *
     * @return the value of customer_eia_report.update_by
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.update_by
     *
     * @param updateBy the value for customer_eia_report.update_by
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.update_time
     *
     * @return the value of customer_eia_report.update_time
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.update_time
     *
     * @param updateTime the value for customer_eia_report.update_time
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.remarks
     *
     * @return the value of customer_eia_report.remarks
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.remarks
     *
     * @param remarks the value for customer_eia_report.remarks
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report.is_deleted
     *
     * @return the value of customer_eia_report.is_deleted
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report.is_deleted
     *
     * @param isDeleted the value for customer_eia_report.is_deleted
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<CustomerEiaReportPic> getCustomerEiaReportPicList() {
        return customerEiaReportPicList;
    }

    public void setCustomerEiaReportPicList(List<CustomerEiaReportPic> customerEiaReportPicList) {
        this.customerEiaReportPicList=customerEiaReportPicList;
    }

    public List<CustomerEiaReportWaste> getCustomerEiaReportWasteList() {
        return customerEiaReportWasteList;
    }

    public void setCustomerEiaReportWasteList(List<CustomerEiaReportWaste> customerEiaReportWasteList) {
        this.customerEiaReportWasteList=customerEiaReportWasteList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_eia_report
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", customerId=").append(customerId);
        sb.append(", approved=").append(approved);
        sb.append(", approveDate=").append(approveDate);
        sb.append(", accepted=").append(accepted);
        sb.append(", acceptDate=").append(acceptDate);
        sb.append(", expanded=").append(expanded);
        sb.append(", expendedDevice=").append(expendedDevice);
        sb.append(", pollutionTypeId=").append(pollutionTypeId);
        sb.append(", pollutionPermitStatus=").append(pollutionPermitStatus);
        sb.append(", reportFile=").append(reportFile);
        sb.append(", insertBy=").append(insertBy);
        sb.append(", insertTime=").append(insertTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remarks=").append(remarks);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", customerEiaReportPicList=").append(customerEiaReportPicList);
        sb.append(", customerEiaReportWasteList=").append(customerEiaReportWasteList);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}