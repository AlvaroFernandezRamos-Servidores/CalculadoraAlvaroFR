/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.calculadoraalvarofr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.albarregas.calculadoraalvarofr.Calculator;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String path = request.getContextPath();
	Map<String,String[]> mapa = request.getParameterMap();
	int val1,val2;
	String op;
	if((mapa.get("val1")!=null && mapa.get("val1")[0].length()>0) && (mapa.get("val2")!=null && mapa.get("val2")[0].length()>0) && (mapa.get("op")!=null && mapa.get("op")[0].length()>0)){
	    val1 = Integer.parseInt(mapa.get("val1")[0]);
	    val2 = Integer.parseInt(mapa.get("val2")[0]);
	    op = mapa.get("op")[0];
	    if(val2==0 && op.equals("div")){
		response.sendRedirect(path+"/JSP/error.jsp");
	    }else{
		Calculator calc = new Calculator(val1,val2,op);
		request.setAttribute("result",Integer.toString(calc.operate()));
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	    }
	}else{
	    response.sendRedirect(path+"/JSP/error.jsp");
	}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
