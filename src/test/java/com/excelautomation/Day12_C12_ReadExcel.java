package com.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Day12_C12_ReadExcel {
    /*
    Import the apache poi dependency in your pom file
    resources package olustur > java altinda acilmali (java'ya sag tikla ve dosyayi olustur)
    Add the excel file on the resources folder
    Yeni package olustur: excelautomation
    Yeni class olustur : ReadExcel
    test method olustur: readExcel()
    Dosyanin adresini String olarak bir konteynira koy
    dosyayi ac
    fileinputstream kullanarak workbook'u ac
    ilk worksheet'i ac
    ilk row'a git
    ilk row'daki ilk cell'e git ve yazdir
    ilk row'daki ikinci cell'e git ve yazdir
    2nd row'daki ilk cell'e git ve datanin ABD'ye esit oldugunu assert e
    3rd row'daki 2nd cell-chain the row and cell
    row sayisini bul
    Kullanilan row sayisini bul
    Ulke ve baskent key-value ciftlerini map object olarak yazdir
    */

    @Test
    public void readExcel() throws IOException {
        // Dosyanin adresini String olarak bir konteynira koy
        String path = "./src/test/java/resources/Baskent.xlsx";

        // dosyayi ac
        FileInputStream fileInputStream = new FileInputStream(path);

        // fileinputstream kullanarak workbook'u ac
       Workbook workbook = WorkbookFactory.create(fileInputStream);

        // ilk worksheet'i ac
       Sheet sheet = workbook.getSheetAt(0); //sheet sayfalari "0" inci indexten baslar

        //    ilk row'a git
        Row ilkRow = sheet.getRow(0); //row lar da index 0 dan baslar

        //    ilk row'daki ilk cell'e git ve yazdir
       Cell ilkcell = ilkRow.getCell(0); // cell indexi 0 dan baslar
        System.out.println(ilkcell);

//       2. row'daki ikinci cell'e git ve yazdir
        //1.yol
//        Row row2 = sheet.getRow(1);
//        Cell cell21 = row2.getCell(1);
//        System.out.println(cell21);
        //2.yol
       Cell row1Cell2 = sheet.getRow(0).getCell(1);
       System.out.println(row1Cell2); //Baskent


//        2nd row'daki ilk cell'e git ve datanin ABD'ye esit oldugunu assert e
        Cell row2Cell1 = sheet.getRow(1).getCell(0);
        System.out.println("Data ABD olmali : " +row2Cell1);

        boolean esitMi = row2Cell1.toString().equals("ABD");
        Assert.assertTrue(esitMi);


//        3rd row'daki 2nd cell-chain the row and cell
        Cell row3Cell2 = sheet.getRow(2).getCell(1);
        System.out.println("Data paris olmali : " +row3Cell2); //paris

//        row sayisini bul
       int rowSayisi = sheet.getLastRowNum()+ 1;
        System.out.println(rowSayisi); //11

//        Kullanilan row sayisini bul
        int kullanilanRowSayisi = sheet.getPhysicalNumberOfRows();
        System.out.println(kullanilanRowSayisi);

//        Ulke ve baskent key-value ciftlerini map object olarak yazdir
        Map<String, String> dunyaBaskentleri = new HashMap<>();
        /*
        row numarasi 1 den baslar
        */

    }
}
