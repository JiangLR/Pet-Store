package cn.edu.zucc.pet_service.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author JiangLR
 * @Time 2018-08-31 15:35
 */
@Entity
@Table(name = "master_info", schema = "pet_service", catalog = "")
public class MasterInfoEntity {
    private int masterId;
    private String masterName;
    private String masterSex;
    private String masterTel;
    private String masterMail;

    @Id
    @Column(name = "master_id")
    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    @Basic
    @Column(name = "master_name")
    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    @Basic
    @Column(name = "master_sex")
    public String getMasterSex() {
        return masterSex;
    }

    public void setMasterSex(String masterSex) {
        this.masterSex = masterSex;
    }

    @Basic
    @Column(name = "master_tel")
    public String getMasterTel() {
        return masterTel;
    }

    public void setMasterTel(String masterTel) {
        this.masterTel = masterTel;
    }

    @Basic
    @Column(name = "master_mail")
    public String getMasterMail() {
        return masterMail;
    }

    public void setMasterMail(String masterMail) {
        this.masterMail = masterMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterInfoEntity that = (MasterInfoEntity) o;
        return masterId == that.masterId &&
                Objects.equals(masterName, that.masterName) &&
                Objects.equals(masterSex, that.masterSex) &&
                Objects.equals(masterTel, that.masterTel) &&
                Objects.equals(masterMail, that.masterMail);
    }

    @Override
    public int hashCode() {

        return Objects.hash(masterId, masterName, masterSex, masterTel, masterMail);
    }
}
