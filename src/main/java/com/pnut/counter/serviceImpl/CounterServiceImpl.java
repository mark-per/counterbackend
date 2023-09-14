package com.pnut.counter.serviceImpl;

import com.pnut.counter.entity.Counter;
import com.pnut.counter.repository.CounterRepository;
import com.pnut.counter.service.CounterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterServiceImpl implements CounterService {

    private final CounterRepository counterRepository;

    public CounterServiceImpl(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @Override
    public List<Counter> getAllCounters() {
        return counterRepository.findAll();
    }

    @Override
    public Counter createCounter(Counter counter) {
        return counterRepository.save(counter);
    }

    @Override
    public Counter incrementCounter(Long id) {
        Counter counter = counterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Counter not found with id " + id));

        counter.setCount(counter.getCount() + 1);
        return counterRepository.save(counter);
    }

    @Override
    public Counter decrementCounter(Long id) {
        Counter counter = counterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Counter not found with id " + id));

        counter.setCount(counter.getCount() - 1);
        return counterRepository.save(counter);
    }

    @Override
    public void deleteCounter(Long id) {
        counterRepository.deleteById(id);
    }

}