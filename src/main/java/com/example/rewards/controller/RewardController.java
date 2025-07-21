package com.example.rewards.controller;

import com.example.rewards.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @GetMapping
    public Map<String, Map<String, Integer>> getRewardsPerCustomer() {
        return rewardService.calculateRewardPoints();
    }
}
