package com.mateo.artemisa.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import java.util.Random;

/**
 * Servlet implementation class Reportes
 */
@WebServlet("/Reportes")
public class Reportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reportes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		  
        // spreadsheet object
        XSSFSheet spreadsheet
            = workbook.createSheet(" Student Data ");
  
        // creating a row object
        XSSFRow row;
  
        // This data needs to be written (Object[])
        Map<String, Object[]> studentData
            = new TreeMap<String, Object[]>();
  
        studentData.put(
            "1",
            new Object[] { "Roll No", "NAME", "Year" });
  
        studentData.put("2", new Object[] { "128", "Aditya",
                                            "2nd year" });
  
        studentData.put(
            "3",
            new Object[] { "129", "Narayana", "2nd year" });
  
        studentData.put("4", new Object[] { "130", "Mohan",
                                            "2nd year" });
  
        studentData.put("5", new Object[] { "131", "Radha",
                                            "2nd year" });
  
        studentData.put("6", new Object[] { "132", "Gopal",
                                            "2nd year" });
  
        Set<String> keyid = studentData.keySet();
  
        int rowid = 0;
  
        // writing the data into the sheets...
  
        for (String key : keyid) {
  
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = studentData.get(key);
            int cellid = 0;
  
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }
  
        final Random aleatorio = new Random(); 
        
        final String nombreArchivo = System.getenv("user.home") + File.separator + "reporte-" + 10000 + aleatorio.nextInt(99999) + ".xlsx";
        
    	System.out.println(nombreArchivo);
        
        FileOutputStream out = new FileOutputStream(
            new File(nombreArchivo));
  
        workbook.write(out);
        out.close();
	}

}
