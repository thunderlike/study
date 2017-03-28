package com.stephen.study.modules.test.dao;

import com.stephen.study.core.persistence.CrudDao;
import com.stephen.study.core.persistence.annotation.MyBatisDao;
import com.stephen.study.modules.test.entity.Room;

@MyBatisDao
public interface RoomDao extends CrudDao<Room>{

}
