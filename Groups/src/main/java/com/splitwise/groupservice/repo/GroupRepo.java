package com.splitwise.groupservice.repo;

import com.splitwise.groupservice.entity.GroupInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<GroupInfo, Integer> {
}
