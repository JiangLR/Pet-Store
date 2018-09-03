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
    private int goodsOrderId;
    private GoodsEntity goods;
    private GoodsOrderEntity goodsOrder;
    private int amount;

    @Id
    @Column(name = "goods_order_id")
    public int getGoodsOrderId() {
        return goodsOrderId;
    }

    public void setGoodsOrderId(int goodsOrderId) {
        this.goodsOrderId = goodsOrderId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsOrderREntity that = (GoodsOrderREntity) o;
        return goodsOrderId == that.goodsOrderId;
    }

    public GoodsEntity getGoods() {
        return goods;
    }

    public void setGoods(GoodsEntity goods) {
        this.goods = goods;
    }

    public GoodsOrderEntity getGoodsOrder() {
        return goodsOrder;
    }

    public void setGoodsOrder(GoodsOrderEntity goodsOrder) {
        this.goodsOrder = goodsOrder;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "GoodsOrderREntity{" +
                "goodsOrderId=" + goodsOrderId +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsOrderId);
    }
}
