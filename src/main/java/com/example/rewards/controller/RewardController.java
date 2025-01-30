package com.example.rewards.controller;

import com.example.rewards.model.Transaction;
import com.example.rewards.model.RewardResponse;
import com.example.rewards.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @PostMapping("/calculate")
    public List<RewardResponse> calculateRewards(@RequestBody List<Transaction> transactions) {
        return rewardService.calculateRewards(transactions);
    }
}