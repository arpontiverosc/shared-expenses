package com.clean.architecture.sharedexpenses.balances.domain.model;

import lombok.*;

import java.util.Set;



public class Group {


    private String id;
    private Set<String> membersIds;

}
