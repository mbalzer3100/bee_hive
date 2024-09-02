package com.mb.bee_hive.insfrastructure.database.repositories;

import com.mb.bee_hive.insfrastructure.database.mysql.models.HoneyBlend;

import java.util.List;
import java.util.UUID;

/**
 * Generic HoneyBlend Repository Interface used for Injection.
 * Can be implemented by several different DB Repositories to allow for easy
 * switch between DBs if need be.
 */
public interface IHoneyBlendRepository {
    void store(HoneyBlend honeyBlend);
    List<HoneyBlend> getAll();
    HoneyBlend getById(String id);
    void delete(String id);
}
