package com.example.user_management.repository;


import com.example.user_management.entity.SearchCriateria;
import com.example.user_management.entity.User;

import java.util.List;

public interface customUserReposotory {
    public List<User> search(SearchCriateria searchCriateria);
}

