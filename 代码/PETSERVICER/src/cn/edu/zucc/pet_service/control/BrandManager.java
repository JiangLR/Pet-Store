package cn.edu.zucc.pet_service.control;

import cn.edu.zucc.pet_service.itf.IBrandManager;
import cn.edu.zucc.pet_service.model.BrandsEntity;
import cn.edu.zucc.pet_service.util.BaseException;
import cn.edu.zucc.pet_service.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


/**
 * @Author JiangLR
 * @Time 2018-09-03 9:01
 */
public class BrandManager implements IBrandManager{
    @Override
    public BrandsEntity regBrand(String name) throws BaseException{
        if(name.equals(""))
            throw new BaseException("品牌名不能为空");
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        BrandsEntity new_brand = new BrandsEntity();
        try {
            tx = session.beginTransaction();
            String hql = "from BrandsEntity where brandsName = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            BrandsEntity brand = (BrandsEntity) query.uniqueResult();
            if(brand != null)
                throw new BaseException("此品牌已存在");
            new_brand.setBrandsName(name);
            session.save(new_brand);
            tx.commit();
        }catch (Exception e){
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
        }
        finally {
            session.clear();
        }
        return new_brand;
    }
}
