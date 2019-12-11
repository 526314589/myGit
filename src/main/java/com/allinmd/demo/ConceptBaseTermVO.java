package com.allinmd.demo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ConceptBaseTermVO {
    //id
    private Long id;
    // 概念id
    private Long conceptId;
//    概念描述
    private String comments;
    //术语id
    private Long termId;
    //包含的术语名称 （属于类型 术语名称）
    private List<String> termTypeAndName;
//    概念包含的术语集合
//    private List<ConceptTermVO> terms;
//    术语名称
    private String term;
//术语分类
    private Integer termType;
//概念分类id
    private String semanticTagId;
//概念分类
    private String semanticTag;
//创建时间(最近编辑时间)
    private String createTime;
//修改时间
    private String updateTime;
//术语状态
    private Integer status;
//发布时间
    private String releaseDate;
//概念状态
    private Integer conceptStatus;
//术语次个数
    private Long termCounts;
//SNOMED 映射
    private boolean snomedMapping = false;
//icd-10映射
    private boolean icdMapping = false;
//是否是知识点
    private boolean hasKnowledgePoint;
//概念来源  1 来源omaha 0 不是来源omaha
    private Integer omaha;
//    编辑人
    private String updateByUser;
}
