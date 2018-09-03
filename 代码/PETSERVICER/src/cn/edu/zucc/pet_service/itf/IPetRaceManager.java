package cn.edu.zucc.pet_service.itf;

import cn.edu.zucc.pet_service.model.PetRaceEntity;
import cn.edu.zucc.pet_service.util.BaseException;

import java.util.List;

/**
 * @Author JiangLR
 * @Time 2018-09-02 19:48
 */
public interface IPetRaceManager {
    public PetRaceEntity regPetRace(String name, String describe) throws BaseException;

    public List<PetRaceEntity> loadAll() throws BaseException;

    public PetRaceEntity loadPetRace(String name) throws BaseException;
}
