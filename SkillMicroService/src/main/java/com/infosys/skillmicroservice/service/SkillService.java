package com.infosys.skillmicroservice.service;

import java.util.List;

import com.infosys.skillmicroservice.entity.Skill;

public interface SkillService {

    Skill addSkill(Skill skill);

    List<Skill> getAllSkills();

    Skill getSkillById(Long skillId);

    Skill updateSkill(Long skillId, Skill skill);

    void deleteSkill(Long skillId);

}