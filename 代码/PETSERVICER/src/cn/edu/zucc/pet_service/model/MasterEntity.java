package cn.edu.zucc.pet_service.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author JiangLR
 * @Time 2018-08-31 21:56
 */
@Entity
@Table(name = "master_info", schema = "pet_service", catalog = "")
public class MasterEntity {
    private int masterId;
    private String masterName;
    private String masterSex;
    private String masterTel;
    private String masterMail;
    private Set<PetEntity> pets = new HashSet<>();
    private Set<GoodsOrderEntity> goodsOrders = new HashSet<>();

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

    public Set<PetEntity> getPets() {
        return pets;
    }

    public void setPets(Set<PetEntity> pets) {
        this.pets = pets;
    }

    public Set<GoodsOrderEntity> getGoodsOrders() {
        return goodsOrders;
    }

    public void setGoodsOrders(Set<GoodsOrderEntity> goodsOrders) {
        this.goodsOrders = goodsOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterEntity that = (MasterEntity) o;
        return masterId == that.masterId &&
                Objects.equals(masterName, that.masterName) &&
                Objects.equals(masterSex, that.masterSex) &&
                Objects.equals(masterTel, that.masterTel) &&
                Objects.equals(masterMail, that.masterMail);
    }

    @Override
    public String toString() {
        return "MasterEntity{" +
                "masterId=" + masterId +
                ", masterName='" + masterName + '\'' +
                ", masterSex='" + masterSex + '\'' +
                ", masterTel='" + masterTel + '\'' +
                ", masterMail='" + masterMail + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(masterId, masterName, masterSex, masterTel, masterMail);
    }
}
