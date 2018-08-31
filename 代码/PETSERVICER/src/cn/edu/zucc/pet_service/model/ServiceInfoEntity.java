package cn.edu.zucc.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author JiangLR
 * @Time 2018-08-31 15:35
 */
@Entity
@Table(name = "service_info", schema = "pet_service", catalog = "")
public class ServiceInfoEntity {
    private int serviceId;
    private String serviceName;
    private double servicePrice;
    private String serviceDescribe;

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
    @Column(name = "service_price")
    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    @Basic
    @Column(name = "service_describe")
    public String getServiceDescribe() {
        return serviceDescribe;
    }

    public void setServiceDescribe(String serviceDescribe) {
        this.serviceDescribe = serviceDescribe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceInfoEntity that = (ServiceInfoEntity) o;
        return serviceId == that.serviceId &&
                Double.compare(that.servicePrice, servicePrice) == 0 &&
                Objects.equals(serviceName, that.serviceName) &&
                Objects.equals(serviceDescribe, that.serviceDescribe);
    }

    @Override
    public int hashCode() {

        return Objects.hash(serviceId, serviceName, servicePrice, serviceDescribe);
    }
}
