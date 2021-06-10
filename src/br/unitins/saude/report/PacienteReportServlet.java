package br.unitins.saude.report;

import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;

import br.unitins.saude.application.JDBCUtil;

@WebServlet("/pacientereportservlet")
public class PacienteReportServlet extends ReportServlet {

	private static final long serialVersionUID = 3336581594588250594L;

	@Override
	public String getArquivoJasper() {
		return "pacientes.jasper";
	}

	@Override
	public HashMap<String, Class<?>> getParametros() {
		 HashMap<String, Class<?>> param = new HashMap<String, Class<?>>();
		 param.put("NOME", String.class);
		 return param;
	}

	@Override
	public Connection getConnection() {
		return JDBCUtil.getConnection();
	}

}