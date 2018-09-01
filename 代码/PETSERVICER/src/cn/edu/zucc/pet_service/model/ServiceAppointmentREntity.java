package cn.edu.zucc.pet_service.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Author JiangLR
 * @Time 2018-08-31 21:56
 */
@Entity
@Table(name = "service_appointment_r", schema = "pet_service", catalog = "")
public class ServiceAppointmentREntity {
    private int serviceAppointmentR;
    private byte finishStatus;
    private Date finishTime;

    @Id
    @Column(name = "service_appointment_r")
    public int getServiceAppointmentR() {
        return serviceAppointmentR;
    }

    public void setServiceAppointmentR(int serviceAppointmentR) {
        this.serviceAppointmentR = serviceAppointmentR;
    }

    @Basic
    @Column(name = "finish_status")
    public byte getFinishStatus() {
        return finishStatus;
    }

    public void setFinishStatus(byte finishStatus) {
        this.finishStatus = finishStatus;
    }

    @Basic
    @Column(name = "finish_time")
    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceAppointmentREntity that = (ServiceAppointmentREntity) o;
        return serviceAppointmentR == that.serviceAppointmentR &&
                finishStatus == that.finishStatus &&
                Objects.equals(finishTime, that.finishTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceAppointmentR, finishStatus, finishTime);
    }
}
