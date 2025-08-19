package com.mcb.imddd.pay.domain.cache;

public interface ICacheService<T> {

    T get(String key);

    void set(String key, T value);

    void remove(String key);

    boolean exist(String key);
}
