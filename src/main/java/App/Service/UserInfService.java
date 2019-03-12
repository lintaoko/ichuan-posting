package App.Service;

import App.Domain.UserInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfService {
    @Autowired
    UserInfMapper userInfMapper;

    //查询个人信息
    public UserInf queryUserInfByUserLoginId(Integer userLoginId){
        UserInf selectResult =userInfMapper.queryUserInfByUserLoginId(userLoginId);
        return selectResult;
    }
    //更改user_login邮箱
    public int userInfUpdateEmailById(String email,Integer userLoginId){
        int updateResult =userInfMapper.userInfUpdateEmailById(email, userLoginId);
        return updateResult;
    }
    //更改user_inf电话
    public int userInfUpdatePhoneById(String phone,Integer userLoginId){
        int updateResult =userInfMapper.userInfUpdatePhoneById(phone, userLoginId);
        return updateResult;
    }
    //更改user_inf昵称
    public int userInfUpdateUserNameById(String userName,Integer userLoginId){
        int updateResult =userInfMapper.userInfUpdatePhoneById(userName, userLoginId);
        return updateResult;
    }
    //修改个人地址
    public int userInfUpdateAddressById(String address,Integer userLoginId){
        int updateResult =userInfMapper.userInfUpdateAddressById(address,userLoginId);
        return updateResult;
    }
    //增添个人信息
    public int userInfInsert (Integer userLoginId,String userName,String Phone ,String address,String email ,Integer age ,String Hobby)
    {
        int insertResult =userInfMapper.userInfInsert(userLoginId, userName, Phone, address, email, age, Hobby);
        return insertResult;
    }
}
