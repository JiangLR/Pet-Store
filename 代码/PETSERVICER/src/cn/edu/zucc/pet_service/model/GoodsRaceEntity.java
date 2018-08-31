package cn.edu.zucc.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author JiangLR
 * @Time 2018-08-31 15:35
 */
@Entity
@Table(name = "goods_race", schema = "pet_service", catalog = "")
public class GoodsRaceEntity {
    private int raceId;
    private String raceName;
    private String raceDescribe;

    @Id
    @Column(name = "race_id")
    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    @Basic
    @Column(name = "race_name")
    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    @Basic
    @Column(name = "race_describe")
    public String getRaceDescribe() {
        return raceDescribe;
    }

    public void setRaceDescribe(String raceDescribe) {
        this.raceDescribe = raceDescribe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsRaceEntity that = (GoodsRaceEntity) o;
        return raceId == that.raceId &&
                Objects.equals(raceName, that.raceName) &&
                Objects.equals(raceDescribe, that.raceDescribe);
    }

    @Override
    public int hashCode() {

        return Objects.hash(raceId, raceName, raceDescribe);
    }
}
