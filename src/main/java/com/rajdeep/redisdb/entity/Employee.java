package com.rajdeep.redisdb.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable{
	private int id;
	private String name;
	private long salary;
}
