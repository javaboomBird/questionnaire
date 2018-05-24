package com.create80.rd.modules.customer.enterprise.api.model;

import java.io.Serializable;
import java.util.Date;

public class EnterprisePic implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pic.id
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pic.enterprise_id
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    private String enterpriseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pic.file_path
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    private String filePath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pic.create_by
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pic.create_date
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pic.update_by
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pic.update_date
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pic.remarks
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column enterprise_pic.del_flag
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    private String delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table enterprise_pic
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pic.id
     *
     * @return the value of enterprise_pic.id
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pic.id
     *
     * @param id the value for enterprise_pic.id
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pic.enterprise_id
     *
     * @return the value of enterprise_pic.enterprise_id
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public String getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pic.enterprise_id
     *
     * @param enterpriseId the value for enterprise_pic.enterprise_id
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pic.file_path
     *
     * @return the value of enterprise_pic.file_path
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pic.file_path
     *
     * @param filePath the value for enterprise_pic.file_path
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pic.create_by
     *
     * @return the value of enterprise_pic.create_by
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pic.create_by
     *
     * @param createBy the value for enterprise_pic.create_by
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pic.create_date
     *
     * @return the value of enterprise_pic.create_date
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pic.create_date
     *
     * @param createDate the value for enterprise_pic.create_date
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pic.update_by
     *
     * @return the value of enterprise_pic.update_by
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pic.update_by
     *
     * @param updateBy the value for enterprise_pic.update_by
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pic.update_date
     *
     * @return the value of enterprise_pic.update_date
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pic.update_date
     *
     * @param updateDate the value for enterprise_pic.update_date
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pic.remarks
     *
     * @return the value of enterprise_pic.remarks
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pic.remarks
     *
     * @param remarks the value for enterprise_pic.remarks
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column enterprise_pic.del_flag
     *
     * @return the value of enterprise_pic.del_flag
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column enterprise_pic.del_flag
     *
     * @param delFlag the value for enterprise_pic.del_flag
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table enterprise_pic
     *
     * @mbg.generated Thu May 24 19:13:21 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", enterpriseId=").append(enterpriseId);
        sb.append(", filePath=").append(filePath);
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