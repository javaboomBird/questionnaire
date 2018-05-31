package com.create80.rd.modules.contract.api.model;

import java.io.Serializable;
import java.util.Date;

public class GoodPic implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good_pic.id
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good_pic.good_id
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String goodId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good_pic.description
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good_pic.name
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good_pic.type
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good_pic.path
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String path;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good_pic.create_by
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good_pic.update_by
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good_pic.create_date
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good_pic.update_date
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good_pic.del_flag
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ecm_good_pic
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good_pic.id
     *
     * @return the value of ecm_good_pic.id
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good_pic.id
     *
     * @param id the value for ecm_good_pic.id
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good_pic.good_id
     *
     * @return the value of ecm_good_pic.good_id
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getGoodId() {
        return goodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good_pic.good_id
     *
     * @param goodId the value for ecm_good_pic.good_id
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good_pic.description
     *
     * @return the value of ecm_good_pic.description
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good_pic.description
     *
     * @param description the value for ecm_good_pic.description
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good_pic.name
     *
     * @return the value of ecm_good_pic.name
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good_pic.name
     *
     * @param name the value for ecm_good_pic.name
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good_pic.type
     *
     * @return the value of ecm_good_pic.type
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good_pic.type
     *
     * @param type the value for ecm_good_pic.type
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good_pic.path
     *
     * @return the value of ecm_good_pic.path
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good_pic.path
     *
     * @param path the value for ecm_good_pic.path
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good_pic.create_by
     *
     * @return the value of ecm_good_pic.create_by
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good_pic.create_by
     *
     * @param createBy the value for ecm_good_pic.create_by
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good_pic.update_by
     *
     * @return the value of ecm_good_pic.update_by
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good_pic.update_by
     *
     * @param updateBy the value for ecm_good_pic.update_by
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good_pic.create_date
     *
     * @return the value of ecm_good_pic.create_date
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good_pic.create_date
     *
     * @param createDate the value for ecm_good_pic.create_date
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good_pic.update_date
     *
     * @return the value of ecm_good_pic.update_date
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good_pic.update_date
     *
     * @param updateDate the value for ecm_good_pic.update_date
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good_pic.del_flag
     *
     * @return the value of ecm_good_pic.del_flag
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good_pic.del_flag
     *
     * @param delFlag the value for ecm_good_pic.del_flag
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ecm_good_pic
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodId=").append(goodId);
        sb.append(", description=").append(description);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", path=").append(path);
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