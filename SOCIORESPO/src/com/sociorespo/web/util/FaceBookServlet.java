package com.sociorespo.web.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class FaceBookServlet
 */
public class FaceBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//CHECK PORTAL
	//private static final String API_KEY = "621c6a40f9a1d794080e10b9cf94c793";
	
	//Event Porch
	//private final String API_KEY = "35da82b9e7418dc5c3a10267b1c0812f";

	private static final String API_KEY = "35da82b9e7418dc5c3a10267b1c0812f";
	
	public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException{
		
		res.setContentType( "text/html" );
		
		doPost(req,res);
	}

	public void doPost(HttpServletRequest req, 
			HttpServletResponse res) 
	throws ServletException, IOException {

		HttpSession session = null;
		String profileId = null;

		//String code=req.getParameter("code"); 
		String authToken=req.getParameter("auth_token"); 
		//System.out.println("authToken"+code);
		System.out.println("authToken"+authToken);
		
        session = req.getSession(true); 
        
        session.setAttribute("AUTH_TOKEN", authToken);
        profileId = (String)session.getAttribute("USERPROFILEID");
        System.out.println("Profile Id is"+profileId);

        if(authToken == null){
        	res.sendRedirect("http://www.facebook.com/login.php?api_key="+API_KEY+"&v=1.0&next=FaceBookServlet");
        }else{
        	res.sendRedirect("/SOCIORESPO/faceBookAction.do");
        }
		
	}

}
