package com.create80.rd.modules.customer.eiareport.api.model;

import java.io.Serializable;
import java.util.Date;

public class EiaReportPic implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eia_report_pic.id
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eia_report_pic.eia_report_id
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    private String eiaReportId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eia_report_pic.type
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eia_report_pic.name
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eia_report_pic.file_path
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    private String filePath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eia_report_pic.create_by
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eia_report_pic.create_date
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eia_report_pic.update_by
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eia_report_pic.update_date
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eia_report_pic.remarks
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column eia_report_pic.del_flag
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    private String delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table eia_report_pic
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eia_report_pic.id
     *
     * @return the value of eia_report_pic.id
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eia_report_pic.id
     *
     * @param id the value for eia_report_pic.id
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eia_report_pic.eia_report_id
     *
     * @return the value of eia_report_pic.eia_report_id
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public String getEiaReportId() {
        return eiaReportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eia_report_pic.eia_report_id
     *
     * @param eiaReportId the value for eia_report_pic.eia_report_id
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public void setEiaReportId(String eiaReportId) {
        this.eiaReportId = eiaReportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eia_report_pic.type
     *
     * @return the value of eia_report_pic.type
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eia_report_pic.type
     *
     * @param type the value for eia_report_pic.type
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eia_report_pic.name
     *
     * @return the value of eia_report_pic.name
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eia_report_pic.name
     *
     * @param name the value for eia_report_pic.name
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eia_report_pic.file_path
     *
     * @return the value of eia_report_pic.file_path
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eia_report_pic.file_path
     *
     * @param filePath the value for eia_report_pic.file_path
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eia_report_pic.create_by
     *
     * @return the value of eia_report_pic.create_by
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eia_report_pic.create_by
     *
     * @param createBy the value for eia_report_pic.create_by
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eia_report_pic.create_date
     *
     * @return the value of eia_report_pic.create_date
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eia_report_pic.create_date
     *
     * @param createDate the value for eia_report_pic.create_date
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eia_report_pic.update_by
     *
     * @return the value of eia_report_pic.update_by
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eia_report_pic.update_by
     *
     * @param updateBy the value for eia_report_pic.update_by
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eia_report_pic.update_date
     *
     * @return the value of eia_report_pic.update_date
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eia_report_pic.update_date
     *
     * @param updateDate the value for eia_report_pic.update_date
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eia_report_pic.remarks
     *
     * @return the value of eia_report_pic.remarks
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eia_report_pic.remarks
     *
     * @param remarks the value for eia_report_pic.remarks
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column eia_report_pic.del_flag
     *
     * @return the value of eia_report_pic.del_flag
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column eia_report_pic.del_flag
     *
     * @param delFlag the value for eia_report_pic.del_flag
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eia_report_pic
     *
     * @mbg.generated Tue May 22 17:48:34 CST 2018
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
        sb.append(", name=").append(name);
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