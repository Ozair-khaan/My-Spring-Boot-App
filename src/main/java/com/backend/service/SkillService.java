package com.backend.service;


import com.backend.entity.Skill;
import com.backend.repo.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {

    @Autowired
    private SkillRepository repository;

    // READ: Get all entities and map them to a simple List<String> for Angular
    public List<String> getAllSkills() {
        return repository.findAll()
                .stream()
                .map(Skill::getName)
                .collect(Collectors.toList());
    }

    // CREATE: Save a new skill
    public List<String> addSkill(String name) {
        // Prevent duplicates
        if (repository.findByName(name).isEmpty()) {
            repository.save(new Skill(name));
        }
        return getAllSkills(); // Return updated list
    }

    // DELETE: Remove by Index (Mapped to DB logic)
    // Note: Deleting by index is risky in real apps (concurrency),
    // but we use it here to match your current Angular logic.
    @Transactional
    public List<String> deleteSkillByIndex(int index) {
        List<Skill> allSkills = repository.findAll();

        if (index >= 0 && index < allSkills.size()) {
            repository.delete(allSkills.get(index));
        }

        return getAllSkills();
    }
}
