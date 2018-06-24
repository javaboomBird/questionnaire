package com.create80.rd.modules.customer.customer.api.model;

import java.io.Serializable;
import java.util.Date;

public class CustomerPollutionTypeRelation implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_pollution_type_relation.id
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_pollution_type_relation.customer_id
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    private String customerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_pollution_type_relation.pollution_type_id
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    private String pollutionTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_pollution_type_relation.insert_by
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    private String insertBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_pollution_type_relation.insert_time
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    private Date insertTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_pollution_type_relation.update_by
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_pollution_type_relation.update_time
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_pollution_type_relation.remarks
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_pollution_type_relation.is_deleted
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    private String isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table customer_pollution_type_relation
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_pollution_type_relation.id
     *
     * @return the value of customer_pollution_type_relation.id
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_pollution_type_relation.id
     *
     * @param id the value for customer_pollution_type_relation.id
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_pollution_type_relation.customer_id
     *
     * @return the value of customer_pollution_type_relation.customer_id
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_pollution_type_relation.customer_id
     *
     * @param customerId the value for customer_pollution_type_relation.customer_id
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_pollution_type_relation.pollution_type_id
     *
     * @return the value of customer_pollution_type_relation.pollution_type_id
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public String getPollutionTypeId() {
        return pollutionTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_pollution_type_relation.pollution_type_id
     *
     * @param pollutionTypeId the value for customer_pollution_type_relation.pollution_type_id
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public void setPollutionTypeId(String pollutionTypeId) {
        this.pollutionTypeId = pollutionTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_pollution_type_relation.insert_by
     *
     * @return the value of customer_pollution_type_relation.insert_by
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public String getInsertBy() {
        return insertBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_pollution_type_relation.insert_by
     *
     * @param insertBy the value for customer_pollution_type_relation.insert_by
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_pollution_type_relation.insert_time
     *
     * @return the value of customer_pollution_type_relation.insert_time
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_pollution_type_relation.insert_time
     *
     * @param insertTime the value for customer_pollution_type_relation.insert_time
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_pollution_type_relation.update_by
     *
     * @return the value of customer_pollution_type_relation.update_by
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_pollution_type_relation.update_by
     *
     * @param updateBy the value for customer_pollution_type_relation.update_by
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_pollution_type_relation.update_time
     *
     * @return the value of customer_pollution_type_relation.update_time
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_pollution_type_relation.update_time
     *
     * @param updateTime the value for customer_pollution_type_relation.update_time
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_pollution_type_relation.remarks
     *
     * @return the value of customer_pollution_type_relation.remarks
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_pollution_type_relation.remarks
     *
     * @param remarks the value for customer_pollution_type_relation.remarks
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_pollution_type_relation.is_deleted
     *
     * @return the value of customer_pollution_type_relation.is_deleted
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_pollution_type_relation.is_deleted
     *
     * @param isDeleted the value for customer_pollution_type_relation.is_deleted
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_pollution_type_relation
     *
     * @mbg.generated Fri Jun 22 15:01:36 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", customerId=").append(customerId);
        sb.append(", pollutionTypeId=").append(pollutionTypeId);
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