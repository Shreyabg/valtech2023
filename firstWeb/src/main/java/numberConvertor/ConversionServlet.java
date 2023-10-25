package numberConvertor;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ConversionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve input parameters
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String selectedSystem = request.getParameter("selectedSystem");

        // Perform the conversion
        String convertedResult = convertToSelectedSystem(number1, number2, selectedSystem);

        // Store the result in a variable
        request.setAttribute("result", convertedResult);

        // Forward the result back to the JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("converterResults.jsp");
        dispatcher.forward(request, response);
    }

    private String convertToSelectedSystem(String number1, String number2, String selectedSystem) {
    	  try {
    	        int decimalNumber1 = Integer.parseInt(number1);
    	        int decimalNumber2 = Integer.parseInt(number2);
    	        int add=decimalNumber1+decimalNumber2;
    	        String result;

    	        switch (selectedSystem) {
    	            case "binary":
    	            	
    	                String res = Integer.toBinaryString(add);
    	               
    	                result = "Binary Conversion:  " +res+ "<br> " ;
    	                break;
    	            case "octal":
    	            	 String res1 = Integer.toOctalString(add);
    	                
    	                result = "Octal Conversion: " + res1 + "<br>";
    	                break;
    	            case "hexadecimal":
    	            	
    	            	String res2 = Integer.toHexString(add);
    	               
    	                result = "Hexadecimal Conversion: " + res2 + "<br>" ;
    	                break;
                     case "base64":
    	            	String num1=Base64.getEncoder().encodeToString(number1.getBytes());
    	            	String num2 =  Base64.getEncoder().encodeToString(number2.getBytes());
    	               String s3=num1+num2;
    	                result = "Base64 Conversion: " + s3+ "<br>" ;
    	                break;
                     
                     case "dec":
 	                    String res6 = Integer.toString(add);
 	                   result = "decimal Conversion: " + res6 + "<br>" ;
 	                    break;
    	                
    	            default:
    	                result = "Unsupported conversion";
    	                
    	                
    	        }

    	        return result;
    	    } catch (NumberFormatException e) {
    	        return "Invalid input. Please enter valid decimal numbers.";
    	    }
    	
    	
    }
}
