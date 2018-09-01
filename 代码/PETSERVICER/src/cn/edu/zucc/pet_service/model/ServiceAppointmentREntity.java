package cn.edu.zucc.pet_service.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author JiangLR
 * @Time 2018-08-31 21:56
 */
@Entity
@Table(name = "service_appointment_r", schema = "pet_service", catalog = "")
public class ServiceAppointmentREntity {
    private int serviceAppointmentId;
    private byte finishStatus;
    private Date finishTime;
    private ServiceRaceEntity service;
    private AppointmentEntity appointment;

    @Id
    @Column(name = "service_appointment_r")
    public int getServiceAppointmentId() {
        return serviceAppointmentId;
    }

    public void setServiceAppointmentId(int serviceAppointmentR) {
        this.serviceAppointmentId = serviceAppointmentR;
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

    public AppointmentEntity getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentEntity appointment) {
        this.appointment = appointment;
    }

    public ServiceRaceEntity getService() {
        return service;
    }

    public void setService(ServiceRaceEntity service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceAppointmentREntity that = (ServiceAppointmentREntity) o;
        return serviceAppointmentId == that.serviceAppointmentId &&
                finishStatus == that.finishStatus &&
                Objects.equals(finishTime, that.finishTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceAppointmentId, finishStatus, finishTime);
    }
}
