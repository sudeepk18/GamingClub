package com.giyu.GamingClub.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giyu.GamingClub.entities.Member;
import com.giyu.GamingClub.entities.Recharge;
import com.giyu.GamingClub.repository.MemberRepository;
import com.giyu.GamingClub.repository.RechargeRepository;

@Service
public class RechargeService {

    @Autowired
    private RechargeRepository rechargeRepository;

    @Autowired
    private MemberRepository memberRepository; // Used to update the member's balance

    @Transactional
    public Recharge saveRecharge(Recharge recharge) {
        Member member = recharge.getMember();

        if (member == null || member.getId() == 0) {
            return null; // Member must exist
        }

        // 1. Fetch the member to update their balance
        Member existingMember = memberRepository.findById(member.getId()).orElse(null);

        if (existingMember == null) {
            return null;
        }

        // 2. Update Member's balance
        float newBalance = existingMember.getBalance() + recharge.getAmount();
        existingMember.setBalance(newBalance);

        // 3. Set the managed member on the recharge object and save
        recharge.setMember(existingMember);

        // Save updated member balance and the new recharge record
        memberRepository.save(existingMember);
        return rechargeRepository.save(recharge);
    }

    public List<Recharge> getAllRecharges() {
        return rechargeRepository.findAll();
    }

    public List<Recharge> getRechargesByMemberId(int memberId) {
        // Find recharges for a specific member - requires custom logic/query
        return rechargeRepository.findAll().stream()
                .filter(r -> r.getMember() != null && r.getMember().getId() == memberId)
                .toList();
    }
}