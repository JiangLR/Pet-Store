package cn.edu.zucc.pet_service.control;

import cn.edu.zucc.pet_service.itf.IStaffManager;
import cn.edu.zucc.pet_service.model.StaffEntity;
import cn.edu.zucc.pet_service.util.BaseException;
import cn.edu.zucc.pet_service.util.DbException;
import cn.edu.zucc.pet_service.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * @Author JiangLR
 * @Time 2018-09-02 16:59
 */
public class StaffManager implements IStaffManager {
    @Override
    public StaffEntity reg(String staffAccount, String pwd, String pwd2, String name, int staffRank) throws BaseException {
        if (pwd.equals("") || pwd2.equals(""))
            throw new BaseException("密码不能为空");
        if (staffAccount.equals(""))
            throw new BaseException("用户名不能为空！");
        if (!pwd.equals(pwd2))
            throw new BaseException("两次输入的密码必须一致!");
        if (name.equals(""))
            throw new BaseException("姓名不能为空");
        if (staffRank < 1 || staffRank > 3) {
            throw new BaseException("员工等级错误");
        }

        StaffEntity newstaff = new StaffEntity();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from StaffEntity where staffAccount = :staffAccount";
            Query query = session.createQuery(hql);
            query.setParameter("staffAccount", staffAccount);
            StaffEntity staff = (StaffEntity) query.uniqueResult();
            if (staff == null) {
                newstaff.setStaffAccount(staffAccount);
                newstaff.setStaffPwd(pwd);
                newstaff.setStaffName(name);
                newstaff.setStaffRank(staffRank);
            } else {
                throw new BaseException("此员工已存在");
            }
            session.save(newstaff);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.clear();
        }
        return newstaff;
    }

    @Override
    public StaffEntity login(String staffAccount, String pwd) throws BaseException {
        StaffEntity staff = new StaffEntity();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "from StaffEntity where staffAccount = :staffAccount";
            Query query = session.createQuery(hql);
            query.setParameter("staffAccount", staffAccount);
            staff = (StaffEntity) query.uniqueResult();
            if (staff == null) {
                throw new BaseException("此用户不存在");
            }
            if (!pwd.equals(staff.getStaffPwd())) {
                throw new BaseException("密码错误");
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.clear();
        }
        return staff;
    }

    @Override
    public Boolean changePwd(StaffEntity staff, String oldPwd, String newPwd, String newPwd2) throws BaseException {
        if (!newPwd.equals(newPwd2))
            throw new BaseException("两次输入的密码必须一致!");
        Session session = HibernateUtil.openSession();
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            StaffEntity newstaff = (StaffEntity) session.get(StaffEntity.class, staff.getStaffId());
            if (newstaff == null) {
                throw new BaseException("当前用户不存在！");
            }
            if (!oldPwd.equals(newstaff.getStaffPwd())) {
                throw new BaseException("原密码错误!");
            }
            newstaff.setStaffPwd(newPwd);
            session.update(newstaff);
            ts.commit();
            return true;
        } catch (Exception e) {
            if (ts != null) {
                ts.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}
