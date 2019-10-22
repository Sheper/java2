package com.pp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;



@ManagedBean
@RequestScoped
public class Persona2Bean {
	
	private List<User> usuarios = new ArrayList<User>();

	public List<User> getUsuarios() {
		User u = new User();
		
		u.setNombre("PP");
		u.setEmail("@email");
		u.setPassword("pass");
		u.setSexo("Masculino");
		u.setPais("Ecuador");
		usuarios.add(u);
		
		u = new User();
		u.setNombre("PP");
		u.setEmail("@email");
		u.setPassword("pass");
		u.setSexo("Masculino");
		u.setPais("Ecuador");
		usuarios.add(u);
		
		return usuarios;
	}

	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	public void exportarPDF(ActionEvent actionEvent) throws JRException, IOException{
		System.out.print("Hola desde Jasper");
		
		Map<String,Object> parametros= new HashMap<String,Object>();
		parametros.put("nombre", "nombre");
		
		//File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/rptJSF.jasper"));
		File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("usuario.jasper"));
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),parametros, new JRBeanCollectionDataSource(this.getUsuarios()));
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition","attachment; filename=jsfReporte.pdf");
		ServletOutputStream stream = response.getOutputStream();
		
		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		
		stream.flush();
		stream.close();
		FacesContext.getCurrentInstance().responseComplete();
		
		
	}
	

}
