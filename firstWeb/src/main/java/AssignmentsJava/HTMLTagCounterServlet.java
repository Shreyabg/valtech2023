package AssignmentsJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/htmlTagCounter")
public class HTMLTagCounterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // String filePath = "your_html_file.html"; // Change this to your HTML file's path
        
        Map<String, Integer> tagStartLine = new HashMap<>();
        Map<String, Integer> tagEndLine = new HashMap<>();
        Map<String, Integer> tagCount = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("C://Users/Shreya.BG/Desktop/index.html"));
        String line;
        int lineNumber = 0;
        
        while ((line = reader.readLine()) != null) {
            lineNumber++;
            Pattern pattern = Pattern.compile("<\\s*([\\w]+)[^>]*>");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String tag = matcher.group(1);
                tagCount.put(tag, tagCount.getOrDefault(tag, 0) + 1);
               // System.out.println("Tag: " + tag + " | Start Line: " + lineNumber);
            }
            Pattern pattern1 = Pattern.compile("<\\s*([\\w]+)[^>]*>");
            Matcher matcher1 = pattern1.matcher(line);
            while (matcher1.find()) {
                String tag = matcher1.group(1);
                tagStartLine.put(tag, lineNumber);
            }
            
            pattern = Pattern.compile("</\\s*([\\w]+)>");
            matcher = pattern.matcher(line);
            
            while (matcher.find()) {
                String tag = matcher.group(1);
                tagEndLine.put(tag, lineNumber);
            }
         
            
        }
        
        reader.close();
        for (Map.Entry<String, Integer> entry : tagCount.entrySet()) {
            System.out.println("Tag: " + entry.getKey() + " | Count: " + entry.getValue());
        }
        // Display tag start and end lines
        for (Map.Entry<String, Integer> entry : tagStartLine.entrySet()) {
            String tag = entry.getKey();
            int startLine = entry.getValue();
            int endLine = tagEndLine.getOrDefault(tag, -1);
            System.out.println("Tag: " + tag + " | Start Line: " + startLine + " | End Line: " + endLine);
        }
       
        
        
    }
}