package calculadora;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;


@WebServlet("/calculo")
public class Calculo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String valor1 = request.getParameter("valor1");
        String valor2 = request.getParameter("valor2");
        String operacao = request.getParameter("operacao");

        String erroValor1 = null;
        String erroValor2 = null;
        String erroOperacao = null;

        Float resultado = null;
        Float num1 = null;
        Float num2 = null;

        try {

            if (valor1 == null || valor1.isEmpty()) {
                erroValor1 = "Informe o primeiro valor";
            } else {
                try {
                    num1 = Float.parseFloat(valor1);
                } catch (Exception e) {
                    erroValor1 = "Primeiro valor invalido.";
                }
            }

            if (valor2 == null || valor2.isEmpty()) {
                erroValor2 = "Informe o segundo valor";
            } else {
                try {
                    num2 = Float.parseFloat(valor2);
                } catch (NumberFormatException e) {
                    erroValor2 = "Segundo valor invalido.";
                }
            }

            if (erroValor1 != null || erroValor2 != null) {
                throw new NumberFormatException("Erro na leitura dos parametros valores");
            }

            switch (operacao) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        erroOperacao = "Divisao por zero nao permitida";
                    } else {
                        resultado = num1 / num2;
                    }
                    break;
                default:
                    erroOperacao = "Operacao invalida";
                    break;

            }

        } catch(NumberFormatException e){
            // Ocorreu algum erro na leitura dos parametros, pulou o calculo
        }

        // Encaminhamento para o JSP
        request.setAttribute("resultado", resultado);
        request.setAttribute("erroValor1", erroValor1);
        request.setAttribute("erroValor2", erroValor2);
        request.setAttribute("erroOperacao", erroOperacao);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }
}
