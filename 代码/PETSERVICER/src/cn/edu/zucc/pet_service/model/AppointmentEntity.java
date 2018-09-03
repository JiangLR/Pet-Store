package cn.edu.zucc.pet_service.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author JiangLR
 * @Time 2018-08-31 21:56
 */
@Entity
@Table(name = "appointment_info", schema = "pet_service", catalog = "")
public class AppointmentEntity {
    private int appointmentId;
    private Timestamp appointmentStart;
    private PetEntity pet;
    private Set<ServiceAppointmentREntity> serviceAppointments = new HashSet<>();

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
    public Timestamp getAppointmentStart() {
        return appointmentStart;
    }

    public void setAppointmentStart(Timestamp appointmentStart) {
        this.appointmentStart = appointmentStart;
    }

    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }

    public Set<ServiceAppointmentREntity> getServiceAppointments() {
        return serviceAppointments;
    }

    public void setServiceAppointments(Set<ServiceAppointmentREntity> serviceAppointments) {
        this.serviceAppointments = serviceAppointments;
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
    public String toString() {
        return "AppointmentEntity{" +
                "appointmentId=" + appointmentId +
                ", appointmentStart=" + appointmentStart +
                ", pet=" + pet +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, appointmentStart);
    }
}
