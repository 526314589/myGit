package com.allinmd.demo;

import com.allinmd.demo.impl.StudentAgePredicateImpl;
import com.allinmd.demo.impl.StudentAreaPredicateImpl;
import javafx.scene.layout.ConstraintsBase;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelDemo {
    /**
     * 通过java代码创建excel
     */
    @Test
    public void excelDemo() {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("demo");
        XSSFRow xssfRow = xssfSheet.createRow(3);
        XSSFCell xssfRowCell = xssfRow.createCell(3);
        xssfRowCell.setCellValue("excelDemo");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("/Users/allin0939/Documents/demo.xlsx");
            xssfWorkbook.write(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过java代码读取excel
     */
    @Test
    public void excelRead() throws Exception {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook("/Users/allin0939/Documents/demo.xlsx");
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(1);
        for (int i = 0; i < xssfSheet.getLastRowNum() + 1; i++) {
            XSSFRow xssfRow = xssfSheet.getRow(i);
            if (xssfRow != null) {
                for (int j = 0; j < xssfRow.getLastCellNum() + 1; j++) {
                    XSSFCell xssfCell = xssfRow.getCell(j);
                    if (xssfCell != null) {
                        Object value = getValue(xssfCell);
                        System.out.print("第" + i + "行" + "第" + j + "列" + value);
                    }
                }
                System.out.println();
            }
        }
    }

    private static Object getValue(XSSFCell xssfCell) {
        Object obj = null;
        CellType cellType = xssfCell.getCellType();
        switch (cellType) {
            case NUMERIC: {//CELL_TYPE_NUMERIC
                if (DateUtil.isCellDateFormatted(xssfCell)) { //日期
                    obj = xssfCell.getDateCellValue() + "日期";
                } else {
                    obj = xssfCell.getNumericCellValue() + "数字";
                }
                break;
            }
            case STRING: //string
                obj = xssfCell.getStringCellValue() + "字符串";
                break;
            case BOOLEAN: { //boolean
                obj = xssfCell.getBooleanCellValue() + "布尔";
                break;
            }
            default: {
                break;
            }
        }
        return obj;
    }

    @RequestMapping(value = "/conceptBaseTermImport", method = RequestMethod.POST)
    public void conceptBaseImport(MultipartFile file) throws Exception {
        /**
         * 校验文件
         *  文件是否是excel(xls,xlsx)
         *  文件大小不能超过5M
         *  文件中所包含数据行数不能超过2000行
         *  文件中的数据不能放在合并单元格中
         */

        long size = file.getSize();
        Workbook wb = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = wb.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        List baseImportList = new ArrayList();
        List termImportList = new ArrayList();
//        ExcelParse.parse();
    }

    @Test
    public void test() {
        String a = "";
        System.out.println(a == "");
    }

    @Test
    public void test1() {
        String a = "1234567890,";
        System.out.println(a.length());
        System.out.println(a.substring(0, a.length()));
        System.out.println(a.substring(0, a.length() - 1));
        String shouHouItemStr = "血红蛋白，白细胞，c-反应蛋白，白细胞介素-6，血沉";
        String[] shouHouItemArr = shouHouItemStr.split("，");
        for (String s : shouHouItemArr) {
            System.out.println(s);
        }
        System.out.println(shouHouItemArr.length);
        String shouQianItemStr = "伴随疾病，血压控制情况，血糖控制情况，心血管系统病变，呼吸系统病变，消化系统病变，肌肉骨骼系统病变，内分泌系统病变，脑病变，感染性疾病，肿瘤病，外周血管病";
        String[] shouQianItemArr = shouQianItemStr.split("，");
        shouQianItemArr = Arrays.toString(shouQianItemArr).split(",");
        for (String s : shouQianItemArr) {
            System.out.println(s);
        }
        System.out.println(shouQianItemArr.length);
    }

    @Test
    public void test2() {
        List<String> a = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(a));
        System.out.println(a);
        List<ConceptBaseTermVO> b = new ArrayList<>();
//        ConceptBaseTermVO conceptBaseTermVO = null;
//        ConceptBaseTermVO conceptBaseTermVO = new ConceptBaseTermVO();
//        b.add(conceptBaseTermVO);
        System.out.println(b);
        System.out.println(CollectionUtils.isNotEmpty(b));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(5);
        Collections.sort(list);
        System.out.println(list);
        String s = "高血压";
        System.out.println(s.contains("高血压"));
    }

    @Test
    public void aaa() throws Exception {
        String a = "术后第1天，";
        System.out.println(a.length());
//        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy_MM_dd");
//        Date date = new Date();
//        date = simpleDateFormat.parse(a);
//        System.out.println((new Date().compareTo(date)));
        String b = " 左右 ";
        System.out.println(b.length());
        System.out.println(b);
        System.out.println(b.trim().length());
        System.out.println(b.trim());
        System.out.println(b.toCharArray());
        String c = ",";
        System.out.println(b.substring(0, b.length() - 1));
        System.out.println(c.substring(0, c.length() - 1));
    }

    @Test
    public void datedate() {
        Date date1 = new Date();
        Date date2 = new Date();
        Date date3 = new Date();
        Date date4 = new Date();
        List<Date> checkDateList = new ArrayList<>();
        checkDateList.add(date1);
        checkDateList.add(date2);
        checkDateList.add(date3);
        checkDateList.add(date4);
        Date max = Collections.max(checkDateList);
        System.out.println(Collections.max(checkDateList).equals(date4));
    }

    @Test
    public void cc() {
        String a = "1年2月3日4时5分6秒";
        String b = "10-0-10-10-10-10";
        String last = "";
        if (b.contains("-")) {
            String[] split = b.split("-");
//            System.out.println(
//                    split.length
//            );
//            for (int i = 0; i < split.length; i++) {
//                System.out.println(split[i]);
//            }

            if (!("0".equals(split[0]))) {
                last += split[0] + "年";
            }
            if (!("0".equals(split[1]))) {
                last += split[1] + "月";
            }
            if (!("0".equals(split[2]))) {
                last += split[2] + "日";
            }
            if (!("0".equals(split[3]))) {
                last += split[3] + "时";
            }
            if (!("0".equals(split[4]))) {
                last += split[4] + "分";
            }
            if (!("0".equals(split[5]))) {
                last += split[5] + "秒";
            }
            System.out.println(last);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("");
    }

    @Test
    public void equals() {
        String onLine = "c－反应蛋白";
        String offLine = "c-反应蛋白";
        System.out.println(onLine.equals(offLine));
        String onLine1 = "白细胞介素－6";
        String offLine1 = "白细胞介素-6";
        System.out.println(onLine1.equals(offLine1));
        String shouHouItemStr = "血红蛋白，白细胞，c-反应蛋白，c－反应蛋白，白细胞介素-6，白细胞介素－6，血沉";
        String[] shouHouItemArr = shouHouItemStr.split("，");
        for (int i = 0; i < shouHouItemArr.length; i++) {
            System.out.println(shouHouItemArr[i]);
        }

    }

    @Test
    public void testAppend() {
        List<String> list = new ArrayList<>();
        list.add("血液系统疾病");
        list.add("自身免疫疾病");
        list.add("呼吸系统病变");
        list.add("心血管系统病变");
        list.add("内分泌系统病变");
        list.add("脑病变");
        list.add("消化系统病变");
        list.add("肌肉骨骼系统病变");
        list.add("脊柱疾病");
        list.add("感染性疾病");
        list.add("局部感染性疾病");
        list.add("传染病");
        list.add("恶性肿瘤病");
        list.add("外周血管病");

        String itemName = "";
        String option = " ";
        StringBuilder stringBuilder = new StringBuilder(option);
        System.out.println(list.size());
        for (String itemNameStr : list) {
            if (itemNameStr.equals(itemNameStr)) {
                stringBuilder.append(itemNameStr);
                stringBuilder.append(option);
                stringBuilder.append("");
            }
        }
        System.out.println(stringBuilder);
    }

    @Test
    public void date() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
        String str = "2019-11-28 11:22:33";
        Date d = sdf.parse(str);
        System.out.println(sdf2.format(d) + '年');
        System.out.println("1".equals(String.valueOf('1')));
    }

    @Test
    public void abc() throws ParseException {
        String last = "0-1-2-0-4-5";
        String[] split = last.split("-");
        String result = "";
        StringBuilder sBuilder = new StringBuilder(result);
        System.out.println("参数转数组" + Arrays.toString(split));
        for (int i = 0; i < split.length; i++) {
            if (i == 0 && !"0".equals(split[i])) {
                sBuilder.append(split[i]).append("年");
            }
            if (i == 1 && !"0".equals(split[i])) {
                sBuilder.append(split[i]).append("月");
            }
            if (i == 2 && !"0".equals(split[i])) {
                sBuilder.append(split[i]).append("日");
            }
            if (i == 3 && !"0".equals(split[i])) {
                sBuilder.append(split[i]).append("时");
            }
            if (i == 4 && !"0".equals(split[i])) {
                sBuilder.append(split[i]).append("分");
            }
            if (i == 5 && !"0".equals(split[i])) {
                sBuilder.append(split[i]).append("秒");
            }
        }
        System.out.println("年月日时分秒" + sBuilder);


    }

    @Test
    public void mapValue() throws ParseException {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("1", "1.1");
        map.put("2", "2.2");
        map.put("3", "3.3");
        map.put("4", "4.4");
        map.put("5", "5.5");
        map.put("6", "6.6");
        map.put("7", "7.7");
        System.out.println(map.values());
        Collection<String> values = map.values();
        System.out.println(values.toString());
        System.out.println(getMapValue(map));
    }

    private String getMapValue(Map<String, String> map) {
        String values = "";
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                values += entry.getValue() + ",";
            }
        }
        return values;
    }

    @Test
    public void objectPropertyAsMapValue() {
        Map<Object, String> map = new LinkedHashMap<>();
        ConceptBaseTermVO vo = new ConceptBaseTermVO();
        map.put(1, String.valueOf(vo.getId()));
    }

    public static void main(String[] args) {
        //lambda练习
        Student student1 = new Student("苏州",180,123,"男");
        Student student2 = new Student("苏州1",182,13,"男");
        Student student3 = new Student("苏州2",18,43,"男");
        Student student4 = new Student("苏州3",28,63,"男");
        Student student5 = new Student("苏州4",16,93,"女");
        Student student6 = new Student("苏州",66,90,"女");
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        //年龄大于20学生
        List<Student> studentAge = filterStudent(list, new StudentAgePredicateImpl());
        //苏州学生
        List<Student> studentArea = filterStudent(list, new StudentAreaPredicateImpl());
        System.out.println("苏州学生"+studentArea);
        System.out.println("年龄大于20学生"+studentAge);
        //不是苏州的学生
        List<Student> students = filterStudent(list, stu -> !"苏州".equals(stu.getArea()));
        System.out.println("不是苏州的学生"+students);
        //女学生
        List<Student> studentGender = filterStudent(list, new IStudentPredicate() {
            @Override
            public boolean test(Student stu) {
                return "女".equals(stu.getGender());
            }
        });
        System.out.println("女学生"+studentGender);
        //及格>=90
        List<Student> studentScore = filterStudent(list, (Student stu) -> stu.getScore() >= 90);
        System.out.println("及格"+studentScore);
    }
    private static List<Student> filterStudent(List<Student> students,IStudentPredicate isp){
        List<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (isp.test(student)) {
                list.add(student);
            }
        }
        return list;
    }
}

