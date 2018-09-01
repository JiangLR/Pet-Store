package cn.edu.zucc.pet_service.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Author JiangLR
 * @Time 2018-08-31 21:56
 */
@Entity
@Table(name = "appointment_info", schema = "pet_service", catalog = "")
public class AppointmentEntity {
    private int appointmentId;
    private Date appointmentStart;

    @Id
    @Column(name = "appointment_id")
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    @Basic
    @Column(name = "appointment_start")
    public Date getAppointmentStart() {
        return appointmentStart;
    }

    public void setAppointmentStart(Date appointmentStart) {
        this.appointmentStart = appointmentStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentEntity that = (AppointmentEntity) o;
        return appointmentId == that.appointmentId &&
                Objects.equals(appointmentStart, that.appointmentStart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, appointmentStart);
    }
}
