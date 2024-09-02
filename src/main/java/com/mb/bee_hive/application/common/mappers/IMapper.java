package com.mb.bee_hive.application.common.mappers;

import java.util.List;

public interface IMapper<FROM,TO>{
    TO map(FROM t);
    List<TO> mapAll(List<FROM> t);
}
