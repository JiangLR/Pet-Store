package cn.edu.zucc.pet_service.itf;

import cn.edu.zucc.pet_service.model.MasterEntity;
import cn.edu.zucc.pet_service.model.PetEntity;
import cn.edu.zucc.pet_service.util.BaseException;

import java.util.List;

/**
 * @Author JiangLR
 * @Time 2018-09-02 18:44
 */
public interface IMasterManager {
    public MasterEntity regMaster(String name, String sex, String tel, String mail) throws BaseException;

    public MasterEntity loadMaster(int master_id);

    public List<MasterEntity> loadAll() throws BaseException;
}
