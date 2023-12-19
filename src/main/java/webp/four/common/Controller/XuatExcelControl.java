/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webp.four.common.Controller;


import webp.four.common.Dao.Impl.GradeDaoImpl;
import webp.four.common.Dao.Impl.UserDaoImpl;
import webp.four.common.Model.Grade;

import webp.four.common.Model.User;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





@WebServlet(name = "XuatExcelControl", urlPatterns = {"/xuatExcelControl"})
public class XuatExcelControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");      
        
        GradeDaoImpl dao = new GradeDaoImpl();
        
        
        List<Grade> listGrade= dao.getAllGrade();
        //DatTenFile
        int maximum=2147483647;
        int minimum=1;
        
        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum =  rn.nextInt(range) + minimum;

        
        FileOutputStream file=new FileOutputStream("C:\\Toyshop_excel\\" +"Grade_"+Integer.toString(randomNum)+".xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet workSheet=workbook.createSheet("1");
        XSSFRow row;
        XSSFCell cell0;
        XSSFCell cell1;
        
        row=workSheet.createRow(0);
        cell0=row.createCell(0);
        cell0.setCellValue("grade");
        cell1=row.createCell(1);
        cell1.setCellValue("gradeName");

        int i=0;
        
        for (Grade o : listGrade) {
        	i=i+1;
        	
        	row=workSheet.createRow(i);
        	cell0=row.createCell(0);
        	cell0.setCellValue(o.getGrade());
        	cell1=row.createCell(1);
        	cell1.setCellValue(o.getGradeName());
        	      		
        }
        workbook.write(file);
        workbook.close();
        file.close();
        request.setAttribute("mess", "Đã xuất file Excel ");
        request.getRequestDispatcher("admin-grade-management").forward(request, response);

       
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
