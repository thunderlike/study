package com.stephen.study.app.service.impl;

import com.stephen.study.app.entity.User;
import com.stephen.study.app.mapper.UserMapper;
import com.stephen.study.app.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lvzhenyu
 * @since 2019-04-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
