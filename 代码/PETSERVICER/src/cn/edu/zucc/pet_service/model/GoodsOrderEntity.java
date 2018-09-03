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
@Table(name = "goods_order", schema = "pet_service", catalog = "")
public class GoodsOrderEntity {
    private int orderId;
    private double orderPrice;
    private int orderStatus;
    private MasterEntity master;
    private Set<GoodsOrderREntity> goodsOrders = new HashSet<>();

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "order_price")
    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Basic
    @Column(name = "order_status")
    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<GoodsOrderREntity> getGoodsOrders() {
        return goodsOrders;
    }

    public void setGoodsOrders(Set<GoodsOrderREntity> goodsOrders) {
        this.goodsOrders = goodsOrders;
    }

    public MasterEntity getMaster() {
        return master;
    }

    public void setMaster(MasterEntity master) {
        this.master = master;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsOrderEntity that = (GoodsOrderEntity) o;
        return orderId == that.orderId &&
                Double.compare(that.orderPrice, orderPrice) == 0 &&
                orderStatus == that.orderStatus;
    }

    @Override
    public String toString() {
        return "GoodsOrderEntity{" +
                "orderId=" + orderId +
                ", orderPrice=" + orderPrice +
                ", orderStatus=" + orderStatus +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderPrice, orderStatus);
    }
}
