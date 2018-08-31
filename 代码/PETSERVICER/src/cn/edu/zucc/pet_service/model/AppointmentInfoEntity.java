package cn.edu.zucc.pet_service.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Author JiangLR
 * @Time 2018-08-31 15:35
 */
@Entity
@Table(name = "appointment_info", schema = "pet_service", catalog = "")
public class AppointmentInfoEntity {
    private int appointmentId;
    private int appointmentPetId;
    private Date appointmentStart;
    private Date appointmentFinish;
    private byte appointmentStatus;

    @Id
    @Column(name = "appointment_id")
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    @Basic
    @Column(name = "appointment_pet_id")
    public int getAppointmentPetId() {
        return appointmentPetId;
    }

    public void setAppointmentPetId(int appointmentPetId) {
        this.appointmentPetId = appointmentPetId;
    }

    @Basic
    @Column(name = "appointment_start")
    public Date getAppointmentStart() {
        return appointmentStart;
    }

    public void setAppointmentStart(Date appointmentStart) {
        this.appointmentStart = appointmentStart;
    }

    @Basic
    @Column(name = "appointment_finish")
    public Date getAppointmentFinish() {
        return appointmentFinish;
    }

    public void setAppointmentFinish(Date appointmentFinish) {
        this.appointmentFinish = appointmentFinish;
    }

    @Basic
    @Column(name = "appointment_status")
    public byte getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(byte appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentInfoEntity that = (AppointmentInfoEntity) o;
        return appointmentId == that.appointmentId &&
                appointmentPetId == that.appointmentPetId &&
                appointmentStatus == that.appointmentStatus &&
                Objects.equals(appointmentStart, that.appointmentStart) &&
                Objects.equals(appointmentFinish, that.appointmentFinish);
    }

    @Override
    public int hashCode() {

        return Objects.hash(appointmentId, appointmentPetId, appointmentStart, appointmentFinish, appointmentStatus);
    }
}
