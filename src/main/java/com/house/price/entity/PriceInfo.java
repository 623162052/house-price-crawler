package com.house.price.entity;

public class PriceInfo {
    private String executeDate; // 执行日期
    private String type;  // 类型：地市、区县、街道、小区

    private String border;  // 边界
    private String bubbleDesc;
    private String count;   //数量 : 10115
    private String countStr; //展示数量 : "1万套"
    private String countUnit;   // 数量单位: "套"
    private String entityId;    //: ""
    private String entityType;  //: ""
    private String fullSpell;   //地区 : "d320104"
    private String icon;    // : ""
    private String pId;
    private String id;  //: 地区编码：320104
    private String imageType;   //: 30002
    private String latitude;    // 纬度
    private String longitude;   // 经度
    private String name;   // 地区名称
    private String price;   // 价格
    private String priceStr; // 展示价格
    private String priceUnit;   // 价格单位
    private String desc;    // 展示价格
    private String selected;    //: false

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public String getBubbleDesc() {
        return bubbleDesc;
    }

    public void setBubbleDesc(String bubbleDesc) {
        this.bubbleDesc = bubbleDesc;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCountStr() {
        return countStr;
    }

    public void setCountStr(String countStr) {
        this.countStr = countStr;
    }

    public String getCountUnit() {
        return countUnit;
    }

    public void setCountUnit(String countUnit) {
        this.countUnit = countUnit;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getFullSpell() {
        return fullSpell;
    }

    public void setFullSpell(String fullSpell) {
        this.fullSpell = fullSpell;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExecuteDate() {
        return executeDate;
    }

    public void setExecuteDate(String executeDate) {
        this.executeDate = executeDate;
    }

    @Override
    public String toString() {
        return "PriceInfo{" +
                "executeDate='" + executeDate + '\'' +
                ", type='" + type + '\'' +
//                ", border='" + border + '\'' +
                ", bubbleDesc='" + bubbleDesc + '\'' +
                ", count='" + count + '\'' +
                ", countStr='" + countStr + '\'' +
                ", countUnit='" + countUnit + '\'' +
                ", entityId='" + entityId + '\'' +
                ", entityType='" + entityType + '\'' +
                ", fullSpell='" + fullSpell + '\'' +
                ", icon='" + icon + '\'' +
                ", pId='" + pId + '\'' +
                ", id='" + id + '\'' +
                ", imageType='" + imageType + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", priceStr='" + priceStr + '\'' +
                ", priceUnit='" + priceUnit + '\'' +
                ", desc='" + desc + '\'' +
                ", selected='" + selected + '\'' +
                '}';
    }
}
