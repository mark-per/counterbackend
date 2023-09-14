package com.pnut.counter.controller;

import com.pnut.counter.entity.Counter;
import com.pnut.counter.service.CounterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/counters")
@CrossOrigin()
public class CounterController {

    private final CounterService counterService;

    // Get all counters
    @GetMapping
    public ResponseEntity<List<Counter>> getAllCounters() {
        return ResponseEntity.ok(counterService.getAllCounters());
    }

    // Create a counter
    @PostMapping
    public ResponseEntity<String> createCounter(@RequestBody Counter counter) {
        return ResponseEntity.ok(counterService.createCounter(counter));
    }

    // Increment a counter
    @PutMapping("/{id}/increment")
    public ResponseEntity<String> incrementCounter(@PathVariable Long id) {

        counterService.incrementCounter(id);
        return ResponseEntity.ok("Counter incremented successfully");
    }

    // Decrement a counter
    @PutMapping("/{id}/decrement")
    public ResponseEntity<String> decrementCounter(@PathVariable Long id) {

        counterService.decrementCounter(id);
        return ResponseEntity.ok("Counter decremented successfully");
    }

    // Delete a counter
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCounter(@PathVariable Long id) {
        counterService.deleteCounter(id);
        return ResponseEntity.ok("Counter deleted successfully");
    }
}