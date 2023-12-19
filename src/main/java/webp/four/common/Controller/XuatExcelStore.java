/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webp.four.common.Controller;


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

import webp.four.common.Dao.Impl.GradeDaoImpl;
import webp.four.common.Dao.Impl.StoreDaoImpl;
import webp.four.common.Model.Store;
import webp.four.common.Model.User;


@WebServlet(name = "XuatExcelStore", urlPatterns = {"/xuatExcelStore"})
public class XuatExcelStore extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
        StoreDaoImpl dao = new StoreDaoImpl();
        List<Store> listStore = dao.getAllStore();
        

        int maximum=2147483647;
        int minimum=1;
        
        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum =  rn.nextInt(range) + minimum;

        
        FileOutputStream file=new FileOutputStream("C:\\Toyshop_excel\\"+"Store-"+Integer.toString(randomNum)+".xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet workSheet=workbook.createSheet("1");
        XSSFRow row;
        XSSFCell cell0;
        XSSFCell cell1;
        XSSFCell cell2;
        XSSFCell cell3;
        XSSFCell cell4;
        XSSFCell cell5;
        XSSFCell cell6;

        
        row=workSheet.createRow(0);
        cell0=row.createCell(0);
        cell0.setCellValue("Mã Cửa hàng");
        cell1=row.createCell(1);
        cell1.setCellValue("Tên của Hàng");
        cell2=row.createCell(2);
        cell2.setCellValue("Mã User");
        cell3=row.createCell(3);
        cell3.setCellValue("Trạng thái");
        cell4=row.createCell(4);
        cell4.setCellValue("Ví");
        cell5=row.createCell(5);
        cell5.setCellValue("Bio");
        cell6=row.createCell(6);
        cell6.setCellValue("ngày tạo");
       
        int i=0;       
        
        for (Store st : listStore) {
            i = i + 1;
            row = workSheet.createRow(i);
            cell0 = row.createCell(0);
            cell0.setCellValue(st.getStoreId());
            cell1 = row.createCell(1);
            cell1.setCellValue(st.getStoreName());
            cell2 = row.createCell(2);
            cell2.setCellValue(st.getUserId());
            cell3 = row.createCell(3);
            cell3.setCellValue(st.isActive()); 
            cell4 = row.createCell(4);
            cell4.setCellValue(st.getWallet());
            cell5 = row.createCell(5);
            cell5.setCellValue(st.getBioStore());
            //cell5.setCellValue(st.getCreateDate().toString());
            cell6 = row.createCell(6);
            
        }
          
        workbook.write(file);
        workbook.close();
        file.close();
        
        request.setAttribute("mess", "Đã xuất file Excel thành công");
        request.getRequestDispatcher("admin-store-management").forward(request, response); 
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
