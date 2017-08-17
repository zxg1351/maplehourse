package com.zxg.maplehourse.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/8/17.
 */
@Entity
@Table(name = "m_banner", schema = "test", catalog = "")
public class MBannerEntity {
    private int id;
    private String mBannerName;
    private String mBannerUrl;
    private String mBannerType;
    private Timestamp createTime;
    private Integer createUser;
    private Timestamp updateTime;
    private Integer updateUser;
    private String delFlag;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "m_banner_name", nullable = true, length = 45)
    public String getmBannerName() {
        return mBannerName;
    }

    public void setmBannerName(String mBannerName) {
        this.mBannerName = mBannerName;
    }

    @Basic
    @Column(name = "m_banner_url", nullable = true, length = 45)
    public String getmBannerUrl() {
        return mBannerUrl;
    }

    public void setmBannerUrl(String mBannerUrl) {
        this.mBannerUrl = mBannerUrl;
    }

    @Basic
    @Column(name = "m_banner_type", nullable = true, length = 1)
    public String getmBannerType() {
        return mBannerType;
    }

    public void setmBannerType(String mBannerType) {
        this.mBannerType = mBannerType;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "create_user", nullable = true)
    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "update_user", nullable = true)
    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    @Basic
    @Column(name = "del_flag", nullable = true, length = 1)
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MBannerEntity that = (MBannerEntity) o;

        if (id != that.id) return false;
        if (mBannerName != null ? !mBannerName.equals(that.mBannerName) : that.mBannerName != null) return false;
        if (mBannerUrl != null ? !mBannerUrl.equals(that.mBannerUrl) : that.mBannerUrl != null) return false;
        if (mBannerType != null ? !mBannerType.equals(that.mBannerType) : that.mBannerType != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (updateUser != null ? !updateUser.equals(that.updateUser) : that.updateUser != null) return false;
        if (delFlag != null ? !delFlag.equals(that.delFlag) : that.delFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mBannerName != null ? mBannerName.hashCode() : 0);
        result = 31 * result + (mBannerUrl != null ? mBannerUrl.hashCode() : 0);
        result = 31 * result + (mBannerType != null ? mBannerType.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUser != null ? updateUser.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        return result;
    }
}
