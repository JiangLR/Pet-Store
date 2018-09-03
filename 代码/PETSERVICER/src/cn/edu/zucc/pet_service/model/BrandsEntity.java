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
@Table(name = "brands", schema = "pet_service", catalog = "")
public class BrandsEntity {
    private int brandsId;
    private String brandsName;
    private Set<GoodsEntity> goods = new HashSet<>();

    @Id
    @Column(name = "brands_id")
    public int getBrandsId() {
        return brandsId;
    }

    public void setBrandsId(int brandsId) {
        this.brandsId = brandsId;
    }

    @Basic
    @Column(name = "brands_name")
    public String getBrandsName() {
        return brandsName;
    }

    public void setBrandsName(String brandsName) {
        this.brandsName = brandsName;
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
        BrandsEntity that = (BrandsEntity) o;
        return brandsId == that.brandsId &&
                Objects.equals(brandsName, that.brandsName);
    }

    @Override
    public String toString() {
        return "BrandsEntity{" +
                "brandsId=" + brandsId +
                ", brandsName='" + brandsName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandsId, brandsName);
    }
}
