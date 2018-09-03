package cn.edu.zucc.pet_service.itf;

import cn.edu.zucc.pet_service.model.MasterEntity;
import cn.edu.zucc.pet_service.model.PetEntity;
import cn.edu.zucc.pet_service.model.PetRaceEntity;
import cn.edu.zucc.pet_service.util.BaseException;

import java.util.List;
import java.util.Set;

/**
 * @Author JiangLR
 * @Time 2018-09-02 18:40
 */
public interface IPetManager {
    public List<PetEntity> loadAll();

    public PetEntity loadPet(int pet_id);

    public Set<PetEntity> loadPets(MasterEntity master);

    public Set<PetEntity> loadPets(PetRaceEntity petRace);

    public PetEntity regPet(String name, String nickname, String sex, MasterEntity master, PetRaceEntity petRace) throws BaseException;

    public void deletePet(PetEntity pet, MasterEntity master) throws BaseException;
}
