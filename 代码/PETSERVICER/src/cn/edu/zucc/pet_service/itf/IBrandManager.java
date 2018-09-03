package cn.edu.zucc.pet_service.itf;

import cn.edu.zucc.pet_service.model.BrandsEntity;
import cn.edu.zucc.pet_service.util.BaseException;

/**
 * @Author JiangLR
 * @Time 2018-09-02 18:51
 */
public interface IBrandManager {
    public BrandsEntity reg_brand(String name) throws BaseException;

}
