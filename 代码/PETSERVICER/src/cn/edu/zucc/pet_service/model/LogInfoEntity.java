package cn.edu.zucc.pet_service.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author JiangLR
 * @Time 2018-09-02 9:59
 */
@Entity
@Table(name = "log_info", schema = "pet_service", catalog = "")
public class LogInfoEntity {
    private int logId;
    private Timestamp staffInTime;
    private Timestamp staffOutTime;
    private StaffEntity staff;

    @Id
    @Column(name = "log_id")
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "staff_in_time")
    public Timestamp getStaffInTime() {
        return staffInTime;
    }

    public void setStaffInTime(Timestamp staffInTime) {
        this.staffInTime = staffInTime;
    }

    @Basic
    @Column(name = "staff_out_time")
    public Timestamp getStaffOutTime() {
        return staffOutTime;
    }

    public void setStaffOutTime(Timestamp staffOutTime) {
        this.staffOutTime = staffOutTime;
    }

    public StaffEntity getStaff() {
        return staff;
    }

    public void setStaff(StaffEntity staff) {
        this.staff = staff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogInfoEntity that = (LogInfoEntity) o;
        return logId == that.logId &&
                Objects.equals(staffInTime, that.staffInTime) &&
                Objects.equals(staffOutTime, that.staffOutTime);
    }

    @Override
    public String toString() {
        return "LogInfoEntity{" +
                "logId=" + logId +
                ", staffInTime=" + staffInTime +
                ", staffOutTime=" + staffOutTime +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(logId, staffInTime, staffOutTime);
    }
}
