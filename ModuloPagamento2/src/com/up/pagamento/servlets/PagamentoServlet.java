package com.up.pagamento.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.pagamento.dao.PagamentoDaoImpl;
import com.up.pagamento.services.PagamentoService;
import com.up.pagamento.services.PagamentoServiceImpl;

/**
 * Servlet implementation class PagamentoServlet
 */

public class PagamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PagamentoService pagamentoService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagamentoServlet() {
        super();
        pagamentoService = new PagamentoServiceImpl(new PagamentoDaoImpl());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pagamentos", pagamentoService.listar());
		request.getRequestDispatcher("/WEB-INF/pagamentos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
