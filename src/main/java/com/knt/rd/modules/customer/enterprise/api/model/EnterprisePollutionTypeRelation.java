package com.knt.rd.modules.customer.enterprise.api.model;

import java.io.Serializable;
import java.util.Date;

public class EnterprisePollutionTypeRelation implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pollution_type_relation.id
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pollution_type_relation.enterprise_id
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String enterpriseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pollution_type_relation.pollution_type_id
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String pollutionTypeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pollution_type_relation.create_by
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pollution_type_relation.create_date
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pollution_type_relation.update_by
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pollution_type_relation.update_date
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pollution_type_relation.remarks
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pollution_type_relation.del_flag
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private String delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table enterprise_pollution_type_relation
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pollution_type_relation.id
     *
     * @return the value of enterprise_pollution_type_relation.id
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pollution_type_relation.id
     *
     * @param id the value for enterprise_pollution_type_relation.id
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pollution_type_relation.enterprise_id
     *
     * @return the value of enterprise_pollution_type_relation.enterprise_id
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pollution_type_relation.enterprise_id
     *
     * @param enterpriseId the value for enterprise_pollution_type_relation.enterprise_id
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pollution_type_relation.pollution_type_id
     *
     * @return the value of enterprise_pollution_type_relation.pollution_type_id
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getPollutionTypeId() {
        return pollutionTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pollution_type_relation.pollution_type_id
     *
     * @param pollutionTypeId the value for enterprise_pollution_type_relation.pollution_type_id
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setPollutionTypeId(String pollutionTypeId) {
        this.pollutionTypeId = pollutionTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pollution_type_relation.create_by
     *
     * @return the value of enterprise_pollution_type_relation.create_by
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pollution_type_relation.create_by
     *
     * @param createBy the value for enterprise_pollution_type_relation.create_by
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pollution_type_relation.create_date
     *
     * @return the value of enterprise_pollution_type_relation.create_date
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pollution_type_relation.create_date
     *
     * @param createDate the value for enterprise_pollution_type_relation.create_date
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pollution_type_relation.update_by
     *
     * @return the value of enterprise_pollution_type_relation.update_by
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pollution_type_relation.update_by
     *
     * @param updateBy the value for enterprise_pollution_type_relation.update_by
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pollution_type_relation.update_date
     *
     * @return the value of enterprise_pollution_type_relation.update_date
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pollution_type_relation.update_date
     *
     * @param updateDate the value for enterprise_pollution_type_relation.update_date
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pollution_type_relation.remarks
     *
     * @return the value of enterprise_pollution_type_relation.remarks
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pollution_type_relation.remarks
     *
     * @param remarks the value for enterprise_pollution_type_relation.remarks
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pollution_type_relation.del_flag
     *
     * @return the value of enterprise_pollution_type_relation.del_flag
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pollution_type_relation.del_flag
     *
     * @param delFlag the value for enterprise_pollution_type_relation.del_flag
     *
     * @mbg.generated Mon May 21 21:32:11 CST 2018
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_pollution_type_relation
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
        sb.append(", enterpriseId=").append(enterpriseId);
        sb.append(", pollutionTypeId=").append(pollutionTypeId);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}