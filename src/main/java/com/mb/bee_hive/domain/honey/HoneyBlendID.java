package com.mb.bee_hive.domain.honey;

import java.util.UUID;

/**
 * ID Object for the Honey Blend. Created for Type Safety reasons, this Object makes up the ID of a Honey Blend.
 * Contains a Long at its core which finally identifies the Honey Blend.
 * @param id a Long that makes up the core identifier for the Honey Blend.
 */
public record HoneyBlendID(
        String id) {
}
