package cn.edu.zucc.pet_service.itf;

import cn.edu.zucc.pet_service.model.GoodsRaceEntity;
import cn.edu.zucc.pet_service.util.BaseException;

import java.util.List;

/**
 * @Author JiangLR
 * @Time 2018-09-02 18:51
 */
public interface IGoodsRaceManager {
    public GoodsRaceEntity regGoodsRace(String name, String describe) throws BaseException;

    public void deleteGoodsRace(GoodsRaceEntity goods_race) throws BaseException;

    public List<GoodsRaceEntity> loadAll() throws BaseException;
}
