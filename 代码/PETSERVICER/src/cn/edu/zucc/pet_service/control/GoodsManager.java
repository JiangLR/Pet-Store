package cn.edu.zucc.pet_service.control;

import cn.edu.zucc.pet_service.itf.IGoodsManager;
import cn.edu.zucc.pet_service.model.BrandsEntity;
import cn.edu.zucc.pet_service.model.GoodsEntity;
import cn.edu.zucc.pet_service.model.GoodsRaceEntity;
import cn.edu.zucc.pet_service.util.BaseException;
import cn.edu.zucc.pet_service.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Blob;
import java.util.List;

/**
 * @Author JiangLR
 * @Time 2018-09-03 8:37
 */
public class GoodsManager implements IGoodsManager {
    @Override
    public GoodsEntity regGoods(String name, Double price, Double onSale, Blob barcode, int goodsAmount, GoodsRaceEntity goodsRace, BrandsEntity brand) throws BaseException {
        if (name.equals(""))
            throw new BaseException("商品名称不能为空");
        if (goodsRace == null)
            throw new BaseException("商品类别不能为空");
        if (brand == null)
            throw new BaseException("商品品牌不能为空");
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        GoodsEntity newGoods = new GoodsEntity();
        try {
            tx = session.beginTransaction();
            String hql = "from GoodsEntity where goodsName = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            GoodsEntity goods = (GoodsEntity) query.uniqueResult();
            if (goods != null)
                throw new BaseException("此商品已存在");
            newGoods.setGoodsName(name);
            newGoods.setGoodsPrice(price);
            newGoods.setOnSale(onSale);
            newGoods.setGoodsBarcode(barcode);
            newGoods.setGoodsRace(goodsRace);
            newGoods.setGoodsAmount(goodsAmount);
            newGoods.setBrand(brand);

            brand.getGoods().add(newGoods);
            goodsRace.getGoods().add(newGoods);
            session.save(newGoods);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            throw e;
        } finally {
            session.clear();
        }
        return newGoods;
    }

    @Override
    public List<GoodsEntity> loadAll() {
        String hql = "from GoodsEntity";
        Query<GoodsEntity> query = HibernateUtil.openSession().createQuery(hql);
        return query.list();
    }
}


