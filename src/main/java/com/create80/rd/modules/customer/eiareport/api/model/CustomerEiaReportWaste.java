package com.create80.rd.modules.customer.eiareport.api.model;

import java.io.Serializable;
import java.util.Date;

public class CustomerEiaReportWaste implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report_waste.id
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report_waste.eia_report_id
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String eiaReportId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report_waste.type
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report_waste.allow_concentration
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String allowConcentration;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report_waste.allow_scale
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String allowScale;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report_waste.insert_by
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String insertBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report_waste.insert_time
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private Date insertTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report_waste.update_by
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report_waste.update_time
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report_waste.remarks
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_eia_report_waste.is_deleted
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private String isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table customer_eia_report_waste
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report_waste.id
     *
     * @return the value of customer_eia_report_waste.id
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report_waste.id
     *
     * @param id the value for customer_eia_report_waste.id
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report_waste.eia_report_id
     *
     * @return the value of customer_eia_report_waste.eia_report_id
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getEiaReportId() {
        return eiaReportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report_waste.eia_report_id
     *
     * @param eiaReportId the value for customer_eia_report_waste.eia_report_id
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setEiaReportId(String eiaReportId) {
        this.eiaReportId = eiaReportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report_waste.type
     *
     * @return the value of customer_eia_report_waste.type
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report_waste.type
     *
     * @param type the value for customer_eia_report_waste.type
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report_waste.allow_concentration
     *
     * @return the value of customer_eia_report_waste.allow_concentration
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getAllowConcentration() {
        return allowConcentration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report_waste.allow_concentration
     *
     * @param allowConcentration the value for customer_eia_report_waste.allow_concentration
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setAllowConcentration(String allowConcentration) {
        this.allowConcentration = allowConcentration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report_waste.allow_scale
     *
     * @return the value of customer_eia_report_waste.allow_scale
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getAllowScale() {
        return allowScale;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report_waste.allow_scale
     *
     * @param allowScale the value for customer_eia_report_waste.allow_scale
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setAllowScale(String allowScale) {
        this.allowScale = allowScale;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report_waste.insert_by
     *
     * @return the value of customer_eia_report_waste.insert_by
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getInsertBy() {
        return insertBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report_waste.insert_by
     *
     * @param insertBy the value for customer_eia_report_waste.insert_by
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report_waste.insert_time
     *
     * @return the value of customer_eia_report_waste.insert_time
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report_waste.insert_time
     *
     * @param insertTime the value for customer_eia_report_waste.insert_time
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report_waste.update_by
     *
     * @return the value of customer_eia_report_waste.update_by
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report_waste.update_by
     *
     * @param updateBy the value for customer_eia_report_waste.update_by
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report_waste.update_time
     *
     * @return the value of customer_eia_report_waste.update_time
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report_waste.update_time
     *
     * @param updateTime the value for customer_eia_report_waste.update_time
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report_waste.remarks
     *
     * @return the value of customer_eia_report_waste.remarks
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report_waste.remarks
     *
     * @param remarks the value for customer_eia_report_waste.remarks
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_eia_report_waste.is_deleted
     *
     * @return the value of customer_eia_report_waste.is_deleted
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_eia_report_waste.is_deleted
     *
     * @param isDeleted the value for customer_eia_report_waste.is_deleted
     *
     * @mbg.generated Fri Jun 22 14:47:34 CST 2018
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_eia_report_waste
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
        sb.append(", eiaReportId=").append(eiaReportId);
        sb.append(", type=").append(type);
        sb.append(", allowConcentration=").append(allowConcentration);
        sb.append(", allowScale=").append(allowScale);
        sb.append(", insertBy=").append(insertBy);
        sb.append(", insertTime=").append(insertTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remarks=").append(remarks);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}