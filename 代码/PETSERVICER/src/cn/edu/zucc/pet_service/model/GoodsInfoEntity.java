package cn.edu.zucc.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author JiangLR
 * @Time 2018-08-31 15:35
 */
@Entity
@Table(name = "goods_info", schema = "pet_service", catalog = "")
public class GoodsInfoEntity {
    private int goodsId;
    private String goodsName;
    private double goodsPrice;
    private String goodsBarcode;

    @Id
    @Column(name = "goods_id")
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "goods_name")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "goods_price")
    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Basic
    @Column(name = "goods_barcode")
    public String getGoodsBarcode() {
        return goodsBarcode;
    }

    public void setGoodsBarcode(String goodsBarcode) {
        this.goodsBarcode = goodsBarcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsInfoEntity that = (GoodsInfoEntity) o;
        return goodsId == that.goodsId &&
                Double.compare(that.goodsPrice, goodsPrice) == 0 &&
                Objects.equals(goodsName, that.goodsName) &&
                Objects.equals(goodsBarcode, that.goodsBarcode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(goodsId, goodsName, goodsPrice, goodsBarcode);
    }
}
