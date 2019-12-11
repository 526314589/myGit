package com.allinmd.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生类
 * @author liutieqiang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String area;
    private Integer age;
    private Integer score;
    private String gender;
}
