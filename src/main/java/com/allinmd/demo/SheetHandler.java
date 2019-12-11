package com.allinmd.demo;

import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;

/**
 * 表格逐行处理的处理器
 *      实现SheetContentsHandler接口
 */
public class SheetHandler implements SheetContentsHandler {

    private ConceptBaseTermVO vo;

    //开始解析某一行处理的方法
    //参数：i 行索引
    @Override
    public void startRow(int i) {
        if(i>=2) {
            vo = new ConceptBaseTermVO();
        }
    }

    //解析结束某一行处理的方法
    @Override
    public void endRow(int i) {
        System.out.println(vo);
    }

    //解析每一列触发的方法

    /**
     *
     * @param columnName 列名
     * @param columnValue 当前单元格数据
     * @param xssfComment 注释（不用）
     */
    @Override
    public void cell(String columnName, String columnValue, XSSFComment xssfComment) {
        if(vo == null) {
            return ;
        }
        String prefix = columnName.substring(0,1); //A,B,C,D
        switch (prefix) {
            case "A": {
                vo.setSemanticTag(columnValue);
                break;
            }
            case "B": {
                vo.setComments(columnValue);
                break;
            }
            case "C": {
                vo.setTermType(Integer.parseInt(columnValue));
                break;
            }
            case "D": {
                vo.setTerm(columnValue);
                break;
            }
            default:{break;}
        }
    }



    //当前sheet全部解析结束之后触发的方法
    public void endSheet() {
        System.out.println("处理结束");
    }
}

