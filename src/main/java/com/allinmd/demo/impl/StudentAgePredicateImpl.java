package com.allinmd.demo.impl;

import com.allinmd.demo.IStudentPredicate;
import com.allinmd.demo.Student;

public class StudentAgePredicateImpl implements IStudentPredicate {
    @Override
    public boolean test(Student stu) {
        return stu.getAge()>20;
    }
}
