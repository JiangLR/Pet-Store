package cn.edu.zucc.pet_service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @Author JiangLR
 * @Time 2018-08-31 21:56
 */
@Entity
@Table(name = "goods_order_r", schema = "pet_service", catalog = "")
public class GoodsOrderREntity {
    private int goodsOrderR;

    @Id
    @Column(name = "goods_order_r")
    public int getServiceAppointmentR() {
        return goodsOrderR;
    }

    public void setServiceAppointmentR(int goodsOrderR) {
        this.goodsOrderR = goodsOrderR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsOrderREntity that = (GoodsOrderREntity) o;
        return goodsOrderR == that.goodsOrderR;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsOrderR);
    }
}
