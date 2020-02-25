package com.example.thymeleaf.vue.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author o.myltsyn * @since 18 дек. 2019 г.
 */

@Data
@Builder
public class Response {
    private Object response;
}
