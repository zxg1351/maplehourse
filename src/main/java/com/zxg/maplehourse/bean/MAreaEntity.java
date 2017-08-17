package com.zxg.maplehourse.bean;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/8/17.
 */
@Entity
@Table(name = "m_area", schema = "test", catalog = "")
public class MAreaEntity {
    private int id;
    private String mAreaId;
    private String mAreaName;
    private Integer mCityId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "m_area_id", nullable = true, length = 45)
    public String getmAreaId() {
        return mAreaId;
    }

    public void setmAreaId(String mAreaId) {
        this.mAreaId = mAreaId;
    }

    @Basic
    @Column(name = "m_area_name", nullable = true, length = 45)
    public String getmAreaName() {
        return mAreaName;
    }

    public void setmAreaName(String mAreaName) {
        this.mAreaName = mAreaName;
    }

    @Basic
    @Column(name = "m_city_id", nullable = true)
    public Integer getmCityId() {
        return mCityId;
    }

    public void setmCityId(Integer mCityId) {
        this.mCityId = mCityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MAreaEntity that = (MAreaEntity) o;

        if (id != that.id) return false;
        if (mAreaId != null ? !mAreaId.equals(that.mAreaId) : that.mAreaId != null) return false;
        if (mAreaName != null ? !mAreaName.equals(that.mAreaName) : that.mAreaName != null) return false;
        if (mCityId != null ? !mCityId.equals(that.mCityId) : that.mCityId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mAreaId != null ? mAreaId.hashCode() : 0);
        result = 31 * result + (mAreaName != null ? mAreaName.hashCode() : 0);
        result = 31 * result + (mCityId != null ? mCityId.hashCode() : 0);
        return result;
    }
}
