package cn.edu.zucc.pet_service.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author JiangLR
 * @Time 2018-08-31 21:56
 */
@Entity
@Table(name = "brands", schema = "pet_service", catalog = "")
public class BrandsEntity {
    private int brandsId;
    private String brandsName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandsEntity that = (BrandsEntity) o;
        return brandsId == that.brandsId &&
                Objects.equals(brandsName, that.brandsName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandsId, brandsName);
    }
}
