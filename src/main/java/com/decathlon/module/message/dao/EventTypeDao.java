package com.decathlon.module.message.dao;

import com.decathlon.module.message.model.EventTypeEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;


/**
 * @Refrence:
 * @Author: jerry.Tan
 * @Date: 2019/4/11 20:49
 * @Modify:
 **/
public interface EventTypeDao extends JpaRepository<EventTypeEntity, String>,JpaSpecificationExecutor<EventTypeEntity> {

    EventTypeEntity findByUuid(String uuid);

    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "update tbl_event_type set enable_status = ?1,gmt_modified = ?3 where uuid = ?2",nativeQuery = true)
    int updateEventTypeByUuid(@Param(value = "enableStatus") int enableStatus, @Param(value = "uuid")String uuid, @Param(value = "date")Date date);
}
