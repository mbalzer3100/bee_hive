package com.mb.bee_hive.application.honeyblend.read_side.projections;

import com.mb.bee_hive.application.common.mappers.IMapper;
import com.mb.bee_hive.application.honeyblend.read_side.models.HoneyBlendReadModel;
import com.mb.bee_hive.application.honeyblend.read_side.queries.GetAllHoneyBlendQuery;
import com.mb.bee_hive.application.honeyblend.read_side.queries.GetSpecificHoneyBlendQuery;
import com.mb.bee_hive.insfrastructure.database.mysql.models.HoneyBlend;
import com.mb.bee_hive.insfrastructure.database.repositories.IHoneyBlendRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HoneyBlendProjection {

    private final IHoneyBlendRepository honeyBlendRepository;
    private final IMapper<HoneyBlend, HoneyBlendReadModel> honeyBlendHoneyToBlendReadModelMapper;

    @Autowired
    public HoneyBlendProjection(IHoneyBlendRepository honeyBlendRepository, IMapper<HoneyBlend, HoneyBlendReadModel> honeyBlendHoneyToBlendReadModelMapper) {
        this.honeyBlendRepository = honeyBlendRepository;
        this.honeyBlendHoneyToBlendReadModelMapper = honeyBlendHoneyToBlendReadModelMapper;
    }

    @QueryHandler
    public List<HoneyBlendReadModel> handle(GetAllHoneyBlendQuery query){
        List<HoneyBlend> honeyBlendList = honeyBlendRepository.getAll();
        return honeyBlendHoneyToBlendReadModelMapper.mapAll(honeyBlendList);
    }

    @QueryHandler
    public HoneyBlendReadModel handle(GetSpecificHoneyBlendQuery query){
        return honeyBlendHoneyToBlendReadModelMapper.map(honeyBlendRepository.getById(query.getId()));
    }
}
