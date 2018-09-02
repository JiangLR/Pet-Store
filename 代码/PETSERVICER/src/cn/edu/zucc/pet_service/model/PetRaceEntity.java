package cn.edu.zucc.pet_service.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author JiangLR
 * @Time 2018-09-02 19:29
 */
@Entity
@Table(name = "pet_race", schema = "pet_service", catalog = "")
public class PetRaceEntity {
    private int petRaceId;
    private String petRaceName;
    private String petRaceDescribe;
    private Set<PetEntity> pets = new HashSet<>();

    @Id
    @Column(name = "pet_race_id")
    public int getRaceId() {
        return petRaceId;
    }

    public void setRaceId(int raceId) {
        this.petRaceId = raceId;
    }

    @Basic
    @Column(name = "pet_race_name")
    public String getPetRaceName() {
        return petRaceName;
    }

    public void setPetRaceName(String raceName) {
        this.petRaceName = raceName;
    }

    @Basic
    @Column(name = "pet_race_describe")
    public String getPetRaceDescribe() {
        return petRaceDescribe;
    }

    public void setPetRaceDescribe(String raceDescribe) {
        this.petRaceDescribe = raceDescribe;
    }

    public Set<PetEntity> getPets() {
        return pets;
    }

    public void setPets(Set<PetEntity> pets) {
        this.pets = pets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetRaceEntity that = (PetRaceEntity) o;
        return petRaceId == that.petRaceId &&
                Objects.equals(petRaceName, that.petRaceName) &&
                Objects.equals(petRaceDescribe, that.petRaceDescribe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petRaceId, petRaceName, petRaceDescribe);
    }
}
