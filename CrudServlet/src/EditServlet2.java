

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String nombre=request.getParameter("nombre");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String sexo=request.getParameter("sexo");
		String pais=request.getParameter("pais");
		
		Emp e=new Emp();
		e.setId(id);
		e.setNombre(nombre);
		e.setPassword(password);
		e.setEmail(email);
		e.setSexo(sexo);
		e.setPais(pais);
		
		int status=EmpDao.update(e);
		if(status>0){
			response.sendRedirect("ViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
