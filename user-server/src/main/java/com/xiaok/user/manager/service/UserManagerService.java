package com.xiaok.user.manager.service;

/**
 * author: xiao
 * date:   2019/2/7
 * desc:
 */
public interface UserManagerService {


    /**
     * 修改用户信息
     * @param userId
     * @param userAlias
     * @param phone
     * @param sex
     * @param idCardType
     * @param idCardNo
     * @param birthday
     * @param email
     * @param prov
     * @param city
     * @param area
     */
    void change(String userId, String userAlias, String phone, Short sex,
                Short idCardType, String idCardNo, String birthday,
                String email, String prov, String city, String area);


    /**
     * 锁定用户
     * @param userId
     */
    void lock(String userId);

    /**
     * 注销用户
     * @param userId
     */
    void cancel(String userId);


}
