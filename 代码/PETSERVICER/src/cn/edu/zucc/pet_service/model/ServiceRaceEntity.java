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
@Table(name = "service_race", schema = "pet_service", catalog = "")
public class ServiceRaceEntity {
    private int serviceId;
    private String serviceName;
    private String serviceDescribe;
    private double servicePrice;
    private Set<ServiceAppointmentREntity> service_appointments = new HashSet<>();

    @Id
    @Column(name = "service_id")
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "service_name")
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Basic
    @Column(name = "service_describe")
    public String getServiceDescribe() {
        return serviceDescribe;
    }

    public void setServiceDescribe(String serviceDescribe) {
        this.serviceDescribe = serviceDescribe;
    }

    @Basic
    @Column(name = "service_price")
    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Set<ServiceAppointmentREntity> getService_appointments() {
        return service_appointments;
    }

    public void setService_appointments(Set<ServiceAppointmentREntity> service_appointment) {
        this.service_appointments = service_appointment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceRaceEntity that = (ServiceRaceEntity) o;
        return serviceId == that.serviceId &&
                Double.compare(that.servicePrice, servicePrice) == 0 &&
                Objects.equals(serviceName, that.serviceName) &&
                Objects.equals(serviceDescribe, that.serviceDescribe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, serviceName, serviceDescribe, servicePrice);
    }
}
