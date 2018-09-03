package cn.edu.zucc.pet_service.itf;

import cn.edu.zucc.pet_service.model.PetRaceEntity;
import cn.edu.zucc.pet_service.util.BaseException;

/**
 * @Author JiangLR
 * @Time 2018-09-02 19:48
 */
public interface IPetRaceManager {
    public PetRaceEntity reg_pet_race(String name, String describe) throws BaseException;
}
