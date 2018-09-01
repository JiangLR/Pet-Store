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
@Table(name = "pet_info", schema = "pet_service", catalog = "")
public class PetEntity {
    private int petId;
    private String petName;
    private String petNickname;
    private String petSex;
    private String petRace;
    private MasterEntity master;
    private Set<AppointmentEntity> appointments = new HashSet<>();

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
    @Column(name = "pet_race")
    public String getPetRace() {
        return petRace;
    }

    public void setPetRace(String petRace) {
        this.petRace = petRace;
    }

    public MasterEntity getMaster() {
        return master;
    }

    public void setMaster(MasterEntity master) {
        this.master = master;
    }

    public Set<AppointmentEntity> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<AppointmentEntity> appointments) {
        this.appointments = appointments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetEntity that = (PetEntity) o;
        return petId == that.petId &&
                Objects.equals(petName, that.petName) &&
                Objects.equals(petNickname, that.petNickname) &&
                Objects.equals(petSex, that.petSex) &&
                Objects.equals(petRace, that.petRace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId, petName, petNickname, petSex, petRace);
    }
}
