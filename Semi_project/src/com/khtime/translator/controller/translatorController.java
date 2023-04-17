package com.khtime.translator.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//추가 import
import java.io.PrintWriter;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@WebServlet("/translator.bo")
public class translatorController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public translatorController() {
        // TODO Auto-generated constructor stub
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("NMTTestServlet doPost 메소드가 실행되었습니다.");
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=utf-8");

    //번역할 text 값을 받아 옵니다 
    String original_str = (String)request.getParameter("original_str");

    //결과값 보내기 위한것 
    PrintWriter out = response.getWriter();
    out.print((String)nmtReturnRseult(original_str));
    
}

// nmtReturnResult의 함수를 통해서 한글 - > 영어로 번역
public String nmtReturnRseult(String original_str){
    
    //애플리케이션 클라이언트 아이디값";
    String clientId = "jFSZOlYGV39ZsmWDKOQI";
    //애플리케이션 클라이언트 시크릿값";
    String clientSecret = "hx81a_MgJa";
    
    String resultString ="";
    try {
        //original_str 값이 우리가 변환할 값 
        String text = URLEncoder.encode(original_str, "UTF-8");
        
        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("X-Naver-Client-Id", clientId);
        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
        // post request
        String postParams = "source=ko&target=en&text=" + text;
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postParams);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        BufferedReader br;
        if(responseCode==200) { // 정상 호출
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } else {  // 에러 발생
            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = br.readLine()) != null) {
            response.append(inputLine);
        }
        br.close();
        System.out.println(response.toString());
        
        resultString = response.toString();
    } catch (Exception e) {
        System.out.println(e);
    }
    
    return resultString;
}

}