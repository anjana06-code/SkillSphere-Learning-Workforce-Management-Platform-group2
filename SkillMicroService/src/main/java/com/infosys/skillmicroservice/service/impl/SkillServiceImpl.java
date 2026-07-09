package com.infosys.skillmicroservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.skillmicroservice.entity.Skill;
import com.infosys.skillmicroservice.repository.SkillRepository;
import com.infosys.skillmicroservice.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill getSkillById(Long skillId) {
        return skillRepository.findById(skillId).orElse(null);
    }

    @Override
    public Skill updateSkill(Long skillId, Skill skill) {
        skill.setSkillId(skillId);
        return skillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long skillId) {
        skillRepository.deleteById(skillId);
    }
}