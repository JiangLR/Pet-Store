package cn.edu.zucc.pet_service.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author JiangLR
 * @Time 2018-08-31 15:35
 */
@Entity
@Table(name = "pet_info", schema = "pet_service", catalog = "")
public class PetInfoEntity {
    private int petId;
    private String petName;
    private String petNickname;
    private String petSex;
    private String petMaster;
    private String petRace;

    @Id
    @Column(name = "pet_id")
    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    @Basic
    @Column(name = "pet_name")
    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    @Basic
    @Column(name = "pet_nickname")
    public String getPetNickname() {
        return petNickname;
    }

    public void setPetNickname(String petNickname) {
        this.petNickname = petNickname;
    }

    @Basic
    @Column(name = "pet_sex")
    public String getPetSex() {
        return petSex;
    }

    public void setPetSex(String petSex) {
        this.petSex = petSex;
    }

    @Basic
    @Column(name = "pet_master")
    public String getPetMaster() {
        return petMaster;
    }

    public void setPetMaster(String petMaster) {
        this.petMaster = petMaster;
    }

    @Basic
    @Column(name = "pet_race")
    public String getPetRace() {
        return petRace;
    }

    public void setPetRace(String petRace) {
        this.petRace = petRace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetInfoEntity that = (PetInfoEntity) o;
        return petId == that.petId &&
                Objects.equals(petName, that.petName) &&
                Objects.equals(petNickname, that.petNickname) &&
                Objects.equals(petSex, that.petSex) &&
                Objects.equals(petMaster, that.petMaster) &&
                Objects.equals(petRace, that.petRace);
    }

    @Override
    public int hashCode() {

        return Objects.hash(petId, petName, petNickname, petSex, petMaster, petRace);
    }
}
