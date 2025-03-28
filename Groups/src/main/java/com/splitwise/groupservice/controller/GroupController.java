package com.splitwise.groupservice.controller;

import com.splitwise.groupservice.entity.GroupInfo;
import com.splitwise.groupservice.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/create")
    public ResponseEntity<?> createGroup(@RequestBody GroupInfo groupInfo) {
        groupService.createGroup(groupInfo);
        return ResponseEntity.ok("GroupInfo created successfully");
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllGroups() {
        List<GroupInfo> groupInfoList = groupService.getAllGroups();
        return ResponseEntity.ok(groupInfoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGroupById(@PathVariable int id) {
        GroupInfo group = groupService.getGroupById(id);
        if(group == null) {
            return ResponseEntity.ok("Group not found with with given id:" + id);
        } else {
            return ResponseEntity.ok(group);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGroupById(@PathVariable int id) {
        groupService.deleteGroupById(id);
        return ResponseEntity.ok("Group deleted successfully");
    }
}
