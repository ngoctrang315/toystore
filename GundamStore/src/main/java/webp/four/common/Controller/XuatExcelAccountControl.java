/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webp.four.common.Controller;

import webp.four.common.Dao.Impl.UserDaoImpl;



import webp.four.common.Model.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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


@WebServlet(name = "XuatExcelAccountControl", urlPatterns = {"/xuatExcelAccountControl"})
public class XuatExcelAccountControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        UserDaoImpl dao = new UserDaoImpl();
        List<User> list = dao.getAllAccount();

        int maximum = 2147483647;
        int minimum = 1;

        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;

        try (FileOutputStream file = new FileOutputStream("C:\\Toyshop_excel\\" + "DanhSachUser" + Integer.toString(randomNum) + ".xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet workSheet = workbook.createSheet("1");
            XSSFRow row;
            XSSFCell cell0;
            XSSFCell cell1;
            XSSFCell cell2;
            XSSFCell cell3;
            XSSFCell cell4;
            XSSFCell cell5;
            XSSFCell cell6;
            XSSFCell cell7;
            XSSFCell cell8;

            row = workSheet.createRow(0);
            cell0 = row.createCell(0);
            cell0.setCellValue("UserId");
            cell1 = row.createCell(1);
            cell1.setCellValue("UserName");
            cell2 = row.createCell(2);
            cell2.setCellValue("Pass");
            cell3 = row.createCell(3);
            cell3.setCellValue("FullName");
            cell4 = row.createCell(4);
            cell4.setCellValue("wallet");
            cell5 = row.createCell(5);
            cell5.setCellValue("CreateDate");
            cell6 = row.createCell(6);
            cell6.setCellValue("Phone");
            cell7 = row.createCell(7);
            cell7.setCellValue("CreditCard");
            cell8 = row.createCell(8);
            cell8.setCellValue("Address");            
            
            int i = 0;

            for (User acc : list) {
                i = i + 1;
                row = workSheet.createRow(i);
                cell0 = row.createCell(0);
                cell0.setCellValue(acc.getUserId());
                cell1 = row.createCell(1);
                cell1.setCellValue(acc.getUserName());
                cell2 = row.createCell(2);
                cell2.setCellValue(acc.getPass());
                cell3 = row.createCell(3);
                cell3.setCellValue(acc.getFullName());
                cell4 = row.createCell(4);
                cell4.setCellValue(acc.getWallet());
                cell5 = row.createCell(5);
                cell5.setCellValue(acc.getDob().toString());
                cell6 = row.createCell(6);
                cell6.setCellValue(acc.getPhone());
                cell7 = row.createCell(7);
                cell7.setCellValue(acc.getCreditCard());
                cell8 = row.createCell(8);
                cell8.setCellValue(acc.getAddress());
            }

            workbook.write(file);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error creating or writing to Excel file.");
        }

        request.setAttribute("mess", "Đã xuất file Excel thành công");
       // request.getRequestDispatcher("managerAccount").forward(request, response);
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
