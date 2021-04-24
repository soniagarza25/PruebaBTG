package com.nuevoProyecto.server;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.LoginContext;
import javax.servlet.*;
import javax.servlet.http.*;

import com.nuevoProyecto.javamysql.JavaMysqlEjemplo;
import com.nuevoProyecto.model.*;
import com.nuevoProyecto.util.*;

// Extend HttpServlet class

public class LandingPage extends HttpServlet {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

// Method to handle GET method request.
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      
   }

   // Method to handle POST method request.
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   JavaMysqlEjemplo conexion = new JavaMysqlEjemplo();
	   String [] algo = new String [0];
	   conexion.main(algo);
	   
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("text/html");
	    Date fechaCreacion=new Date();
		Map<String, Object> mson = new HashMap<String, Object>();
		mson.put("success", true);
		 String nombres1		="";
		 String apellidos1	    ="";
		 String email1		    ="";
		 String telefono1 	    ="";
		 String tipodepqr1      ="";
		 String descripcion 	="";
		 String Respuesta		="";
		request.removeAttribute("submitForm");
		request.removeAttribute("descripciondelplan");

		try {
				LoginContext lcServer = new LoginContext("client-login", new ClientCallbackHandler("anonymous", ""));
				lcServer.login();
	   
			   Usuario persona=new Usuario();
			  
			  nombres1		=request.getParameter("nombres");
			  apellidos1	=request.getParameter("apellidos");
			  email1		= request.getParameter("email");
			  telefono1 	= request.getParameter("telefono");
			  tipodepqr1 	= request.getParameter("tipodepqr");
			  descripcion	=request.getParameter("descripcion");
			  
			  Calendar calendar = Calendar.getInstance();
			        calendar.setTime(fechaCreacion); // Configuramos la fecha que se recibe
			        calendar.add(Calendar.DAY_OF_YEAR, 5);
			  Date fecha5dias =calendar.getTime();
			   if(tipodepqr1!=null || tipodepqr1=="reclamo") {
				   if (fecha5dias.after(fechaCreacion)) {
					   Respuesta="NO SE PUEDE GENERAR EL RECLAMO";
				   }else {
					   Respuesta="SE GENERO EL RECLAMO";
				   }
			   }else {
				Respuesta="SE GENERO LA PQR";
			}
			   
			   persona.setNombres(nombres1);
			   persona.setApellidos(apellidos1);
			   persona.setTelefono(telefono1);
			   persona.setEmail(email1);
			   persona.setTelefono(telefono1);
			   
			   Pqr pqr = new Pqr();
			   pqr.setCliente(persona);
			   pqr.setFechaCreacion(fechaCreacion);
			   pqr.setTipoDeSolicitud(tipodepqr1);
			   pqr.setDescripcionDelCaso(descripcion);
	   
		} catch (Exception e) {
			int i =0;
			i++;

		}
		
		
	    PrintWriter out = response.getWriter();
	    String title = "Resumen Pqr´s";
	    out.println(ServletUtilities.headWithTitle(title) +
	                "<body align=\"center\"  background=\"images/bg-image.jpg\"\n" +
	    		    "<div class=\"userInfoWindow\" style=\"background-color: white; width: 500px; position: absolute; left: 50%; top: 50%; margin-left: -480px; margin-top: -380px;\">"+
	                "<H1 ALIGN=CENTER> <font color='white'>" + title + "</font></H1>\n" +
	                "<table class='formContainer' width='100%'>" + 
	                "<tbody>"+
	                "<tbody><tr style='background-color: #ff0e64; font-weight: bold; text-align: center; font-size: 30px; color: #ffffff; height: 10px;'>" + 
	                "<td colspan='2'>"+Respuesta+"</td>" + 
	                "</tr>" + 
	                "</tbody>"+
	                " </tbody>" + 
	                "</table>"  );
	    out.println("\n</BODY></HTML>");
			
   }
   
}
