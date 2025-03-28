package com.splitwise.groupservice.service;

import com.splitwise.groupservice.entity.GroupInfo;
import com.splitwise.groupservice.repo.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepo groupRepo;

    public GroupInfo getGroupById(int id) {
        return groupRepo.findById(id).orElse(null);
    }

    public void createGroup(GroupInfo groupInfo) {
        groupRepo.save(groupInfo);
    }

    public void deleteGroupById(int id) {
        groupRepo.deleteById(id);
    }

    public List<GroupInfo> getAllGroups() {
        return groupRepo.findAll();
    }
}
