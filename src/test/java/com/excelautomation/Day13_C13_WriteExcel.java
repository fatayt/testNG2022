package com.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day13_C13_WriteExcel {
    /*
     Dosya path icin String bir kontainer olustur
     Dosyayi ac
     workbook ac
     ilk worksheet'i ac
     ilk row'a git
     ilk row 3. column'da bir cell olustur
     cell'de “Nufus” yaz
     2. row 3. cell'de (index 2) cell olustur ve 150000 yaz
     3. row 3. cell de bir cell olustur ve 250000 yaz
     4. row 3. cell'de bir cell olustur ve 54000 yaz
     workbook kaydet
     Dosyayi kapat
     Workbook'u kapat
     */
@Test
    public void writeExcel() throws IOException {
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

//        ilk row 3. column'da bir cell olustur
    Cell rowCell3 = ilkRow.createCell(2);

//        cell'de “Nufus” yaz
    rowCell3.setCellValue("Nufus");

//        2. row 3. cell'de (index 2) cell olustur ve 150000 yaz
    sheet.getRow(1).createCell(2).setCellValue("150000");

//        3. row 3. cell de bir cell olustur ve 250000 yaz
    sheet.getRow(2).createCell(2).setCellValue("25000");

//        4. row 3. cell'de bir cell olustur ve 54000 yaz
    sheet.getRow(3).createCell(2).setCellValue(540000);

//        workbook kaydet
    FileOutputStream fileOutputStream = new FileOutputStream(path);
    workbook.write(fileOutputStream);
//        Dosyayi kapat
    fileInputStream.close();
    fileOutputStream.close();
//        Workbook'u kapat
    workbook.close();

    }
}