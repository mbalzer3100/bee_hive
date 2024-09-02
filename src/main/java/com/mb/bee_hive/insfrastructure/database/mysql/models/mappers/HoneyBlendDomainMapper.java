package com.mb.bee_hive.insfrastructure.database.mysql.models.mappers;

import com.mb.bee_hive.application.common.mappers.IMapper;
import com.mb.bee_hive.domain.honey.HoneyBlendID;
import com.mb.bee_hive.insfrastructure.database.mysql.models.HoneyBlend;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HoneyBlendDomainMapper implements IMapper<HoneyBlend, com.mb.bee_hive.domain.honey.HoneyBlend> {
    @Override
    public com.mb.bee_hive.domain.honey.HoneyBlend map(HoneyBlend honeyBlend) {
        return new com.mb.bee_hive.domain.honey.HoneyBlend(
                new HoneyBlendID(honeyBlend.getId()),
                honeyBlend.getName(),
                honeyBlend.getDescription(),
                honeyBlend.getQuantity()
        );
    }

    @Override
    public List<com.mb.bee_hive.domain.honey.HoneyBlend> mapAll(List<HoneyBlend> t) {
        return null;
    }
}
