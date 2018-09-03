package cn.edu.zucc.pet_service.itf;

import cn.edu.zucc.pet_service.model.MasterEntity;
import cn.edu.zucc.pet_service.model.PetEntity;
import cn.edu.zucc.pet_service.util.BaseException;

/**
 * @Author JiangLR
 * @Time 2018-09-02 18:44
 */
public interface IMasterManager {
    public MasterEntity reg_master(String name, String sex, String tel, String mail) throws BaseException;
    public MasterEntity query_master(int master_id);
    public PetEntity reg_pet(String name, String nickname, String sex, MasterEntity master) throws BaseException;
}
