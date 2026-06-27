package com.princechouhan.ormqueryhandson.repository;

import com.princechouhan.ormqueryhandson.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
