package cn.edu.zucc.pet_service.itf;

import cn.edu.zucc.pet_service.model.MasterEntity;
import cn.edu.zucc.pet_service.model.PetEntity;
import cn.edu.zucc.pet_service.model.PetRaceEntity;
import cn.edu.zucc.pet_service.util.BaseException;

import java.util.List;

/**
 * @Author JiangLR
 * @Time 2018-09-02 18:40
 */
public interface IPetManager {
    public List<PetEntity> loadAll() throws BaseException;

    public PetEntity loadPet(int pet_id) throws BaseException;

    public List<PetEntity> loadPets(MasterEntity master) throws BaseException;

    public List<PetEntity> loadPets(PetRaceEntity pet_race) throws BaseException;

    public PetEntity regPet(String name, String nickname, String sex, MasterEntity master) throws BaseException;

    public void deletePet(PetEntity pet, MasterEntity master) throws BaseException;
}
