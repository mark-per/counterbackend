package com.pnut.counter.service;

import com.pnut.counter.entity.Counter;

import java.util.List;

public interface CounterService {
    List<Counter> getAllCounters();

    Counter createCounter(Counter counter);

    Counter incrementCounter(Long id);

    Counter decrementCounter(Long id);

    void deleteCounter(Long id);
}

