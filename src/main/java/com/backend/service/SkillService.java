package com.backend.service;


import com.backend.entity.Skill;
import com.backend.repo.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository repository;

    public List<Skill> getAllSkills() {
        return repository.findAll();
    }

    public List<Skill> addSkill(String name) {
        if (repository.findByName(name).isPresent()) {
            throw new RuntimeException("Skill already exists");
        }
        repository.save(new Skill(name));
        return getAllSkills();
    }

    public List<Skill> deleteSkillById(Long id) {
        repository.deleteById(id);
        return repository.findAll();
    }
}
