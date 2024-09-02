package com.mb.bee_hive.application.honeyblend.write_side.mappers;

import com.mb.bee_hive.application.common.mappers.IMapper;
import com.mb.bee_hive.application.honeyblend.write_side.events.HoneyBlendDeletedEvent;
import com.mb.bee_hive.application.honeyblend.write_side.events.HoneyBlendUpdatedEvent;
import com.mb.bee_hive.insfrastructure.database.mysql.models.HoneyBlend;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HoneyBlendUpdatedToRepoMapper implements IMapper<HoneyBlendUpdatedEvent, HoneyBlend> {
    @Override
    public HoneyBlend map(HoneyBlendUpdatedEvent t) {
        HoneyBlend honeyBlend = new HoneyBlend();
        BeanUtils.copyProperties(t, honeyBlend);
        return honeyBlend;
    }

    @Override
    public List<HoneyBlend> mapAll(List<HoneyBlendUpdatedEvent> t) {
        return null;
    }
}
