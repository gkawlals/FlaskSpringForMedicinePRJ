package JavaPrj.kopo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import JavaPrj.kopo.util.UrlUtil;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception{
    	
        System.out.println( "Hello World!" );
        
        UrlUtil uu = new UrlUtil();
        
        String url = "http://127.0.0.1:8001";
        String api = "/myTextAPI";
        String pName = "?pText=";
        String pText = "함지민은 한국폴리텍대학 서울강서캠퍼스 학생이다.";
        
        String res = uu.urlReadforString(url + api + pName + URLEncoder.encode(pText,"UTF-8"));
        
        System.out.println("res : "+ res);
        
        uu = null;
    }
}
