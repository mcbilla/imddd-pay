package com.mcb.imddd.pay.infrastructure.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils {

    private static class InstanceHolder {
        public static final ObjectMapper INSTANCE = new ObjectMapper();
    }

    public static ObjectMapper getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
