package com.mb.bee_hive.application.honeyblend.read_side.queries;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Builder
public class GetSpecificHoneyBlendQuery {
    private String id;
}
