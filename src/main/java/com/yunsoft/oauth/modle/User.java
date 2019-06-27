package com.yunsoft.oauth.modle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {


    private String id;

    private String userName;

    private String password;

    private String role;

    private String address;

    private Integer age;

    private Integer sex;

    private String headUrl;

    private String phone;

    private Integer state;

    private String zone;

    private Date modifyTime;

    private Date createTime;

    private String nickName;

    private String access_token;

    private String userSig;

    public User() {
    }

    public User(String id, String userName, String password, String role, String address, Integer age, Integer sex, String headUrl, String phone, Integer state, String zone, Date modifyTime, Date createTime, String nickName, String access_token, String userSig) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.address = address;
        this.age = age;
        this.sex = sex;
        this.headUrl = headUrl;
        this.phone = phone;
        this.state = state;
        this.zone = zone;
        this.modifyTime = modifyTime;
        this.createTime = createTime;
        this.nickName = nickName;
        this.access_token = access_token;
        this.userSig = userSig;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getUserSig() {
        return userSig;
    }

    public void setUserSig(String userSig) {
        this.userSig = userSig;
    }
}