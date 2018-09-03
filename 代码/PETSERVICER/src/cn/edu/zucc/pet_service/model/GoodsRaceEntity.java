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
@Table(name = "goods_race", schema = "pet_service", catalog = "")
public class GoodsRaceEntity {
    private int GoodsRaceId;
    private String goodsRaceName;
    private String goodsRaceDescribe;
    private Set<GoodsEntity> goods = new HashSet<>();

    public int getGoodsRaceId() {
        return GoodsRaceId;
    }

    public void setGoodsRaceId(int goodsRaceId) {
        GoodsRaceId = goodsRaceId;
    }

    @Basic
    @Column(name = "goods_race_name")
    public String getGoodsRaceName() {
        return goodsRaceName;
    }

    public void setGoodsRaceName(String raceName) {
        this.goodsRaceName = raceName;
    }

    @Basic
    @Column(name = "goods_race_describe")
    public String getGoodsRaceDescribe() {
        return goodsRaceDescribe;
    }

    public void setGoodsRaceDescribe(String raceDescribe) {
        this.goodsRaceDescribe = raceDescribe;
    }

    public Set<GoodsEntity> getGoods() {
        return goods;
    }

    public void setGoods(Set<GoodsEntity> goods) {
        this.goods = goods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsRaceEntity that = (GoodsRaceEntity) o;
        return GoodsRaceId == that.GoodsRaceId &&
                Objects.equals(goodsRaceName, that.goodsRaceName) &&
                Objects.equals(goodsRaceDescribe, that.goodsRaceDescribe);
    }

    @Override
    public String toString() {
        return "GoodsRaceEntity{" +
                "raceId=" + GoodsRaceId +
                ", raceName='" + goodsRaceName + '\'' +
                ", raceDescribe='" + goodsRaceDescribe + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(GoodsRaceId, goodsRaceName, goodsRaceDescribe);
    }
}
