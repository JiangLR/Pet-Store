package cn.edu.zucc.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author JiangLR
 * @Time 2018-08-31 15:35
 */
@Entity
@Table(name = "goods_order", schema = "pet_service", catalog = "")
public class GoodsOrderEntity {
    private int orderId;
    private int orderNum;
    private double orderPrice;
    private byte orderStatus;

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "order_num")
    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
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
    public byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsOrderEntity that = (GoodsOrderEntity) o;
        return orderId == that.orderId &&
                orderNum == that.orderNum &&
                Double.compare(that.orderPrice, orderPrice) == 0 &&
                orderStatus == that.orderStatus;
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, orderNum, orderPrice, orderStatus);
    }
}
