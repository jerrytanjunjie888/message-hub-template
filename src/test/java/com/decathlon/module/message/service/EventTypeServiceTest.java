package com.decathlon.module.message.service;

import com.decathlon.module.message.dao.EventTypeDao;
import com.decathlon.module.message.model.EventTypeDTO;
import com.decathlon.module.message.model.EventTypeEntity;
import com.decathlon.module.message.service.impl.EventTypeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Refrence:
 * @Author: jerry.Tan
 * @Date: 2019/4/11 20:49
 * @Modify:
 **/
@AutoConfigureMockMvc
public class EventTypeServiceTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListEventTypeMessageInfo() throws ParseException {
        Page<EventTypeEntity> page = new Page<EventTypeEntity>() {
            @Override
            public int getTotalPages() {
                return 0;
            }

            @Override
            public long getTotalElements() {
                return 0;
            }

            @Override
            public <U> Page<U> map(Function<? super EventTypeEntity, ? extends U> converter) {
                return null;
            }

            @Override
            public int getNumber() {
                return 0;
            }

            @Override
            public int getSize() {
                return 0;
            }

            @Override
            public int getNumberOfElements() {
                return 0;
            }

            @Override
            public List<EventTypeEntity> getContent() {
                return null;
            }

            @Override
            public boolean hasContent() {
                return false;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public boolean isFirst() {
                return false;
            }

            @Override
            public boolean isLast() {
                return false;
            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Pageable nextPageable() {
                return null;
            }

            @Override
            public Pageable previousPageable() {
                return null;
            }

            @Override
            public Iterator<EventTypeEntity> iterator() {
                return null;
            }
        };
        EventTypeDTO eventTypeDto = new EventTypeDTO();

        eventTypeDto.setUuid("eventTypeDto");

        EventTypeServiceImpl eventTypeService = mock(EventTypeServiceImpl.class);

        when(eventTypeService.listEventTypeMessage(eventTypeDto)).thenReturn(page);

        Assert.assertEquals(eventTypeService.listEventTypeMessage(eventTypeDto),page);

    }

    @Test
    public void testUpdateEventTypeStatus() throws ParseException {

        EventTypeEntity eventTypeEntity = new EventTypeEntity();

        eventTypeEntity.setUuid("eventTypeEntity");

        EventTypeDao eventTypeDao = mock(EventTypeDao.class);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = sdf.parse("2019-08-18 11:11:11");

        when(eventTypeDao.updateEventTypeByUuid(1,"uuid",date)).thenReturn(1);

        Assert.assertEquals(eventTypeDao.updateEventTypeByUuid(1,"uuid",date),1);

    }

    @Test
    public void testEventTypeMessageSave(){

        EventTypeDTO eventTypeDto = new EventTypeDTO();

        eventTypeDto.setUuid("eventTypeDto");

        EventTypeEntity eventTypeEntity = new EventTypeEntity();

        eventTypeEntity.setUuid("eventTypeEntity");

        EventTypeServiceImpl templateEmailEntityService = mock(EventTypeServiceImpl.class);

        when(templateEmailEntityService.insertEventTypeMessage(eventTypeDto)).thenReturn(eventTypeEntity);

        EventTypeEntity  AfterEventTypeEntity = templateEmailEntityService.insertEventTypeMessage(eventTypeDto);

        Assert.assertEquals(AfterEventTypeEntity.getUuid(),"eventTypeEntity");
    }

}
