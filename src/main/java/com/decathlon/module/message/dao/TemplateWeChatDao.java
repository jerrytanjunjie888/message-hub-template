package com.decathlon.module.message.dao;

import com.decathlon.module.message.model.TemplateWeChatEntity;
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
public interface TemplateWeChatDao extends JpaRepository<TemplateWeChatEntity, String>,JpaSpecificationExecutor<TemplateWeChatEntity> {

    TemplateWeChatEntity findByUuid(String uuid);

    TemplateWeChatEntity  findByEventTypeUuid(String eventTypeUuId);

    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "update tbl_template_wechat set is_deleted = ?1,gmt_modified = ?3 where uuid = ?2",nativeQuery = true)
    int updateTemplateWeChatByUuid(@Param(value = "isDeleted") int isDeleted, @Param(value = "uuid")String uuid, @Param(value = "date")Date date);
}
