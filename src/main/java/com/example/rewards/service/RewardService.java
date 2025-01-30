package com.example.rewards.service;

import com.example.rewards.model.Transaction;
import com.example.rewards.model.RewardResponse;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.*;

@Service
public class RewardService {

    public List<RewardResponse> calculateRewards(List<Transaction> transactions) {
        Map<Long, Map<Month, Integer>> customerRewards = new HashMap<>();

        for (Transaction transaction : transactions) {
            Long customerId = transaction.getCustomerId();
            Month month = transaction.getDate().getMonth();
            double amount = transaction.getAmount();

            int points = calculatePoints(amount);

            customerRewards.computeIfAbsent(customerId, k -> new HashMap<>())
                    .merge(month, points, Integer::sum);
        }

        List<RewardResponse> response = new ArrayList<>();
        for (Map.Entry<Long, Map<Month, Integer>> entry : customerRewards.entrySet()) {
            RewardResponse rewardResponse = new RewardResponse();
            rewardResponse.setCustomerId(entry.getKey());

            Map<String, Integer> monthlyRewards = new HashMap<>();
            int totalRewards = 0;

            for (Map.Entry<Month, Integer> monthEntry : entry.getValue().entrySet()) {
                monthlyRewards.put(monthEntry.getKey().toString(), monthEntry.getValue());
                totalRewards += monthEntry.getValue();
            }

            rewardResponse.setMonthlyRewards(monthlyRewards);
            rewardResponse.setTotalRewards(totalRewards);
            response.add(rewardResponse);
        }

        return response;
    }

    private int calculatePoints(double amount) {
        int points = 0;
        if (amount > 100) {
            points += (int) (amount - 100) * 2;
            amount = 100;
        }
        if (amount > 50) {
            points += (int) (amount - 50);
        }
        return points;
    }
}