package com.create80.rd.modules.assets.api.model;

import java.io.Serializable;
import java.util.Date;

public class AssetsImage implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column assets_image.id
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column assets_image.assets_id
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    private String assetsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column assets_image.path
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    private String path;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column assets_image.create_by
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column assets_image.create_date
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column assets_image.update_by
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column assets_image.update_date
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column assets_image.remarks
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column assets_image.del_flag
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    private String delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table assets_image
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column assets_image.id
     *
     * @return the value of assets_image.id
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column assets_image.id
     *
     * @param id the value for assets_image.id
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column assets_image.assets_id
     *
     * @return the value of assets_image.assets_id
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public String getAssetsId() {
        return assetsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column assets_image.assets_id
     *
     * @param assetsId the value for assets_image.assets_id
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public void setAssetsId(String assetsId) {
        this.assetsId = assetsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column assets_image.path
     *
     * @return the value of assets_image.path
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column assets_image.path
     *
     * @param path the value for assets_image.path
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column assets_image.create_by
     *
     * @return the value of assets_image.create_by
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column assets_image.create_by
     *
     * @param createBy the value for assets_image.create_by
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column assets_image.create_date
     *
     * @return the value of assets_image.create_date
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column assets_image.create_date
     *
     * @param createDate the value for assets_image.create_date
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column assets_image.update_by
     *
     * @return the value of assets_image.update_by
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column assets_image.update_by
     *
     * @param updateBy the value for assets_image.update_by
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column assets_image.update_date
     *
     * @return the value of assets_image.update_date
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column assets_image.update_date
     *
     * @param updateDate the value for assets_image.update_date
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column assets_image.remarks
     *
     * @return the value of assets_image.remarks
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column assets_image.remarks
     *
     * @param remarks the value for assets_image.remarks
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column assets_image.del_flag
     *
     * @return the value of assets_image.del_flag
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column assets_image.del_flag
     *
     * @param delFlag the value for assets_image.del_flag
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table assets_image
     *
     * @mbg.generated Tue Jun 05 18:11:43 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", assetsId=").append(assetsId);
        sb.append(", path=").append(path);
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