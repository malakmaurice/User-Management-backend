package com.example.user_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriateria {
private String searchField;
private Status userGroup;
private String start ;
private String end;
}
