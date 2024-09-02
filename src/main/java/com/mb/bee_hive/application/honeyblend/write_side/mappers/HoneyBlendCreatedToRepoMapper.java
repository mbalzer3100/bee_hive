package com.mb.bee_hive.application.honeyblend.write_side.mappers;

import com.mb.bee_hive.application.common.mappers.IMapper;
import com.mb.bee_hive.application.honeyblend.write_side.events.HoneyBlendCreatedEvent;
import com.mb.bee_hive.insfrastructure.database.mysql.models.HoneyBlend;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HoneyBlendCreatedToRepoMapper implements IMapper<HoneyBlendCreatedEvent, HoneyBlend> {
    @Override
    public HoneyBlend map(HoneyBlendCreatedEvent honeyBlendCreatedEvent) {
        HoneyBlend honeyBlend = new HoneyBlend();
        BeanUtils.copyProperties(honeyBlendCreatedEvent, honeyBlend);
        return honeyBlend;
    }

    @Override
    public List<HoneyBlend> mapAll(List<HoneyBlendCreatedEvent> t) {
        return null;
    }
}
