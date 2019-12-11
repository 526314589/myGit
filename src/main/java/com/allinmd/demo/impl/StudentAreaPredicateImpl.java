package com.allinmd.demo.impl;

import com.allinmd.demo.IStudentPredicate;
import com.allinmd.demo.Student;

public class StudentAreaPredicateImpl implements IStudentPredicate {
    @Override
    public boolean test(Student stu) {
        return "苏州".equals(stu.getArea());
    }
}
