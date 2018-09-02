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
@Table(name = "staff_info", schema = "pet_service", catalog = "")
public class StaffEntity {
    private int staffId;
    private String staffName;
    private int staffRank;
    private String staffAccount;
    private String staffPwd;
    private Set<LogInfoEntity> log_infos = new HashSet<>();

    @Id
    @Column(name = "staff_id")
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "staff_name")
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getStaffRank() {
        return staffRank;
    }

    public void setStaffRank(int staffRank) {
        this.staffRank = staffRank;
    }

    @Basic
    @Column(name = "staff_account")
    public String getStaffAccount() {
        return staffAccount;
    }

    public void setStaffAccount(String staffAccount) {
        this.staffAccount = staffAccount;
    }

    @Basic
    @Column(name = "staff_pwd")
    public String getStaffPwd() {
        return staffPwd;
    }

    public void setStaffPwd(String staffPwd) {
        this.staffPwd = staffPwd;
    }

    public Set<LogInfoEntity> getLog_infos() {
        return log_infos;
    }

    public void setLog_infos(Set<LogInfoEntity> log_infos) {
        this.log_infos = log_infos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffEntity that = (StaffEntity) o;
        return staffId == that.staffId &&
                staffRank == that.staffRank &&
                Objects.equals(staffName, that.staffName) &&
                Objects.equals(staffAccount, that.staffAccount) &&
                Objects.equals(staffPwd, that.staffPwd);
    }

    @Override
    public String toString() {
        return "StaffEntity{" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", staffRank='" + staffRank + '\'' +
                ", staffAccount='" + staffAccount + '\'' +
                ", staffPwd='" + staffPwd + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, staffName, staffRank, staffAccount, staffPwd);
    }
}
