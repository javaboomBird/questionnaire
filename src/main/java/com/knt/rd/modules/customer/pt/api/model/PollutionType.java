package com.knt.rd.modules.customer.pt.api.model;

import java.io.Serializable;
import java.util.Date;

public class PollutionType implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pollution_type.id
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pollution_type.pollution_type_name
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    private String pollutionTypeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pollution_type.create_by
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pollution_type.create_date
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pollution_type.update_by
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pollution_type.update_date
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pollution_type.remarks
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pollution_type.del_flag
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    private String delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pollution_type
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pollution_type.id
     *
     * @return the value of pollution_type.id
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pollution_type.id
     *
     * @param id the value for pollution_type.id
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pollution_type.pollution_type_name
     *
     * @return the value of pollution_type.pollution_type_name
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public String getPollutionTypeName() {
        return pollutionTypeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pollution_type.pollution_type_name
     *
     * @param pollutionTypeName the value for pollution_type.pollution_type_name
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public void setPollutionTypeName(String pollutionTypeName) {
        this.pollutionTypeName = pollutionTypeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pollution_type.create_by
     *
     * @return the value of pollution_type.create_by
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pollution_type.create_by
     *
     * @param createBy the value for pollution_type.create_by
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pollution_type.create_date
     *
     * @return the value of pollution_type.create_date
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pollution_type.create_date
     *
     * @param createDate the value for pollution_type.create_date
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pollution_type.update_by
     *
     * @return the value of pollution_type.update_by
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pollution_type.update_by
     *
     * @param updateBy the value for pollution_type.update_by
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pollution_type.update_date
     *
     * @return the value of pollution_type.update_date
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pollution_type.update_date
     *
     * @param updateDate the value for pollution_type.update_date
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pollution_type.remarks
     *
     * @return the value of pollution_type.remarks
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pollution_type.remarks
     *
     * @param remarks the value for pollution_type.remarks
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pollution_type.del_flag
     *
     * @return the value of pollution_type.del_flag
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pollution_type.del_flag
     *
     * @param delFlag the value for pollution_type.del_flag
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pollution_type
     *
     * @mbg.generated Mon May 21 18:19:21 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pollutionTypeName=").append(pollutionTypeName);
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