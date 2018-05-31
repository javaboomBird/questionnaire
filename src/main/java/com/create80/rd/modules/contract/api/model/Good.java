package com.create80.rd.modules.contract.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Good implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.id
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.no
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String no;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.name
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.model
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String model;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.type
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.manufacturer
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String manufacturer;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.supplier
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String supplier;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.purchase_price
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private BigDecimal purchasePrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.tag_price
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private BigDecimal tagPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.introduction
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String introduction;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.remarks
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.create_by
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.update_by
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.create_date
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.update_date
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ecm_good.del_flag
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private String delFlag;

    private List<GoodPic> goodPicList;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ecm_good
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.id
     *
     * @return the value of ecm_good.id
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.id
     *
     * @param id the value for ecm_good.id
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.no
     *
     * @return the value of ecm_good.no
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getNo() {
        return no;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.no
     *
     * @param no the value for ecm_good.no
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.name
     *
     * @return the value of ecm_good.name
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.name
     *
     * @param name the value for ecm_good.name
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.model
     *
     * @return the value of ecm_good.model
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getModel() {
        return model;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.model
     *
     * @param model the value for ecm_good.model
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.type
     *
     * @return the value of ecm_good.type
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.type
     *
     * @param type the value for ecm_good.type
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.manufacturer
     *
     * @return the value of ecm_good.manufacturer
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.manufacturer
     *
     * @param manufacturer the value for ecm_good.manufacturer
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.supplier
     *
     * @return the value of ecm_good.supplier
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.supplier
     *
     * @param supplier the value for ecm_good.supplier
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.purchase_price
     *
     * @return the value of ecm_good.purchase_price
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.purchase_price
     *
     * @param purchasePrice the value for ecm_good.purchase_price
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.tag_price
     *
     * @return the value of ecm_good.tag_price
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public BigDecimal getTagPrice() {
        return tagPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.tag_price
     *
     * @param tagPrice the value for ecm_good.tag_price
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setTagPrice(BigDecimal tagPrice) {
        this.tagPrice = tagPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.introduction
     *
     * @return the value of ecm_good.introduction
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.introduction
     *
     * @param introduction the value for ecm_good.introduction
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.remarks
     *
     * @return the value of ecm_good.remarks
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.remarks
     *
     * @param remarks the value for ecm_good.remarks
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.create_by
     *
     * @return the value of ecm_good.create_by
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.create_by
     *
     * @param createBy the value for ecm_good.create_by
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.update_by
     *
     * @return the value of ecm_good.update_by
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.update_by
     *
     * @param updateBy the value for ecm_good.update_by
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.create_date
     *
     * @return the value of ecm_good.create_date
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.create_date
     *
     * @param createDate the value for ecm_good.create_date
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.update_date
     *
     * @return the value of ecm_good.update_date
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.update_date
     *
     * @param updateDate the value for ecm_good.update_date
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ecm_good.del_flag
     *
     * @return the value of ecm_good.del_flag
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ecm_good.del_flag
     *
     * @param delFlag the value for ecm_good.del_flag
     *
     * @mbg.generated Thu May 31 11:02:31 CST 2018
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public List<GoodPic> getGoodPicList() {
        return goodPicList;
    }

    public void setGoodPicList(List<GoodPic> goodPicList) {
        this.goodPicList=goodPicList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ecm_good
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
        sb.append(", no=").append(no);
        sb.append(", name=").append(name);
        sb.append(", model=").append(model);
        sb.append(", type=").append(type);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", supplier=").append(supplier);
        sb.append(", purchasePrice=").append(purchasePrice);
        sb.append(", tagPrice=").append(tagPrice);
        sb.append(", introduction=").append(introduction);
        sb.append(", remarks=").append(remarks);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", goodPicList=").append(goodPicList);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}