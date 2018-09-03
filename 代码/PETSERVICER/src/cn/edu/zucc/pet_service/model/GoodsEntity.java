package cn.edu.zucc.pet_service.model;

import javax.persistence.*;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author JiangLR
 * @Time 2018-08-31 21:56
 */
@Entity
@Table(name = "goods_info", schema = "pet_service", catalog = "")
public class GoodsEntity {
    private int goodsId;
    private String goodsName;
    private double goodsPrice;
    private double onSale;
    private Blob goodsBarcode;
    private GoodsRaceEntity goodsRace;
    private int goodsAmount;
    private BrandsEntity brand;
    private Set<GoodsOrderREntity> goodsOrders = new HashSet<>();

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
    @Column(name = "on_sale")
    public double getOnSale() {
        return onSale;
    }

    public void setOnSale(double onSale) {
        this.onSale = onSale;
    }

    @Basic
    @Column(name = "goods_barcode")
    public Blob getGoodsBarcode() {
        return goodsBarcode;
    }

    public void setGoodsBarcode(Blob goodsBarcode) {
        this.goodsBarcode = goodsBarcode;
    }

    public Set<GoodsOrderREntity> getGoodsOrders() {
        return goodsOrders;
    }

    public void setGoodsOrders(Set<GoodsOrderREntity> goodsOrders) {
        this.goodsOrders = goodsOrders;
    }

    public GoodsRaceEntity getGoodsRace() {
        return goodsRace;
    }

    public void setGoodsRace(GoodsRaceEntity goodsRace) {
        this.goodsRace = goodsRace;
    }

    public int getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(int goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public BrandsEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandsEntity brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsEntity that = (GoodsEntity) o;
        return goodsId == that.goodsId &&
                Double.compare(that.goodsPrice, goodsPrice) == 0 &&
                Double.compare(that.onSale, onSale) == 0 &&
                Objects.equals(goodsName, that.goodsName) &&
                Objects.equals(goodsBarcode, that.goodsBarcode);
    }

    @Override
    public String toString() {
        return "GoodsEntity{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", onSale=" + onSale +
                ", goodsBarcode='" + goodsBarcode +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, goodsName, goodsPrice, onSale, goodsBarcode);
    }
}
