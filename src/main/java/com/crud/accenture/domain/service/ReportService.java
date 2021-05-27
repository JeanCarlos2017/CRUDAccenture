package com.crud.accenture.domain.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.crud.accenture.domain.model.Usuario;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
	private UsuarioService usuarioService;

	public ReportService(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	  public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
	        String path = "C:\\Users\\jean.carlos.a.correa\\Documents\\"
	        		+ "workspace-spring-tool-suite-4-4.10.0.RELEASE\\"
	        		+ "CRUDAccenture\\Report";
	        
	        List<Usuario> listaDeUsuarios = this.usuarioService.buscarTodosUsuarios();
	        
	        //load file and compile it
	        File file = ResourceUtils.getFile("classpath:usuarios.jrxml");
	        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaDeUsuarios);
	        Map<String, Object> parameters = new HashMap<>();
	        parameters.put("createdBy", "Jean Correa");
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
	        if (reportFormat.equalsIgnoreCase("html")) {
	            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\usuarios.html");
	        }
	        if (reportFormat.equalsIgnoreCase("pdf")) {
	            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\usuarios.pdf");
	        }

	        return "report generated in path : " + path;
	    }
}
