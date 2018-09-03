package cn.edu.zucc.pet_service.itf;

import cn.edu.zucc.pet_service.model.StaffEntity;
import cn.edu.zucc.pet_service.util.BaseException;

/**
 * @Author JiangLR
 * @Time 2018-09-02 16:46
 */
public interface IStaffManager {
    public StaffEntity reg(String staffid, String pwd, String pwd2, String name, int staffrank) throws BaseException;
    public StaffEntity login(String staffid, String pwd) throws BaseException;
    public Boolean changePwd(StaffEntity staff, String oldPwd, String newPwd, String newPwd2) throws BaseException;
}