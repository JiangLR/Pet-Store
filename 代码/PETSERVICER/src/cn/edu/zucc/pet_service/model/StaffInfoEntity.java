package cn.edu.zucc.pet_service.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author JiangLR
 * @Time 2018-08-31 15:35
 */
@Entity
@Table(name = "staff_info", schema = "pet_service", catalog = "")
public class StaffInfoEntity {
    private int staffId;
    private String staffName;
    private String staffRank;
    private String staffPw;

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

    @Basic
    @Column(name = "staff_rank")
    public String getStaffRank() {
        return staffRank;
    }

    public void setStaffRank(String staffRank) {
        this.staffRank = staffRank;
    }

    @Basic
    @Column(name = "staff_pw")
    public String getStaffPw() {
        return staffPw;
    }

    public void setStaffPw(String staffPw) {
        this.staffPw = staffPw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffInfoEntity that = (StaffInfoEntity) o;
        return staffId == that.staffId &&
                Objects.equals(staffName, that.staffName) &&
                Objects.equals(staffRank, that.staffRank) &&
                Objects.equals(staffPw, that.staffPw);
    }

    @Override
    public int hashCode() {

        return Objects.hash(staffId, staffName, staffRank, staffPw);
    }
}
