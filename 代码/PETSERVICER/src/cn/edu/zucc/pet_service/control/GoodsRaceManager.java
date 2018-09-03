package cn.edu.zucc.pet_service.control;

import cn.edu.zucc.pet_service.itf.IGoodsRaceManager;
import cn.edu.zucc.pet_service.model.GoodsRaceEntity;
import cn.edu.zucc.pet_service.util.BaseException;
import cn.edu.zucc.pet_service.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @Author JiangLR
 * @Time 2018-09-03 9:44
 */
public class GoodsRaceManager implements IGoodsRaceManager {
    @Override
    public GoodsRaceEntity regGoodsRace(String name, String describe) throws BaseException {
        if (name.equals(""))
            throw new BaseException("商品类别不能为空");
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        GoodsRaceEntity new_goods_race = new GoodsRaceEntity();
        try {
            tx = session.beginTransaction();
            String hql = "from GoodsEntity where goodsName = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            GoodsRaceEntity goods_race = (GoodsRaceEntity) query.uniqueResult();
            if (goods_race != null)
                throw new BaseException("此商品类别已存在");
            new_goods_race.setGoodsRaceName(name);
            new_goods_race.setGoodsRaceDescribe(describe);
            session.save(new_goods_race);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.clear();
        }
        return new_goods_race;
    }

    @Override
    public void deleteGoodsRace(GoodsRaceEntity goods_race) throws BaseException {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(goods_race);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            throw e;
        } finally {
            session.clear();
        }
    }

    @Override
    public List<GoodsRaceEntity> loadAll() throws BaseException {
        String hql = "from GoodsRaceEntity";
        Query<GoodsRaceEntity> query = HibernateUtil.openSession().createQuery(hql);
        return query.list();
    }
}
