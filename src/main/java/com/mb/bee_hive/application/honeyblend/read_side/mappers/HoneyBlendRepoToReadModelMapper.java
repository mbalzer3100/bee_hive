package com.mb.bee_hive.application.honeyblend.read_side.mappers;

import com.mb.bee_hive.application.common.mappers.IMapper;
import com.mb.bee_hive.application.honeyblend.read_side.models.HoneyBlendReadModel;
import com.mb.bee_hive.insfrastructure.database.mysql.models.HoneyBlend;
import com.mb.bee_hive.insfrastructure.database.repositories.IHoneyBlendRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class HoneyBlendRepoToReadModelMapper implements IMapper<HoneyBlend, HoneyBlendReadModel> {

    @Override
    public HoneyBlendReadModel map(HoneyBlend t) {
        return HoneyBlendReadModel.builder()
                .id(t.getId())
                .name(t.getName())
                .description(t.getDescription())
                .quantity(t.getQuantity())
                .build();
    }

    public List<HoneyBlendReadModel> mapAll(List<HoneyBlend> t) {
        Iterator iterator = t.iterator();
        ArrayList<HoneyBlendReadModel> result = new ArrayList<HoneyBlendReadModel>();
        while (iterator.hasNext()) {
            HoneyBlendReadModel readModel = map((HoneyBlend) iterator.next());
            result.add(readModel);
        }
        return result;
    }
}
