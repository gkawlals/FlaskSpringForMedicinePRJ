package JavaPrj.kopo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import JavaPrj.kopo.util.UrlUtil;

/**
 * Hello world!
 *
 */
public class App2 {
    public static void main( String[] args ) throws Exception{
    	
        System.out.println( "Hello World!" );
        
        UrlUtil uu = new UrlUtil();
        
        String url = "http://127.0.0.1:8001";
        String api = "/App2Test";
        String pName = "?Filename=";
        String Filename = "20210802_21.39.48.png";
        
        String res = uu.urlReadforString(url + api + pName + URLEncoder.encode(Filename,"UTF-8"));
        
        System.out.println("res : "+ res);
        
        uu = null;
        
        // json parsing
        
        JSONParser parser = new JSONParser();
        
        JSONObject json = (JSONObject) parser.parse(res);
        
        List<String> rList = (List<String>) json.get("word");
        
        if(rList == null) {
        	rList = new ArrayList<String>();
        }
        
        Iterator<String> it = rList.iterator();
        
        while(it.hasNext()) {
        	String word = (String) it.next();
        	if(word.endsWith("주")) {
        		System.out.println("word : "+ word);
        	}else if (word.endsWith("정")){
        		System.out.println("word : "+ word);
        	}else if (word.endsWith("복)")){
        		System.out.println("word : "+ word);
        	}else if (word.endsWith("급여)")){
        		System.out.println("word : "+ word);
        	}else if (word.endsWith("비")){
        		System.out.println("word : "+ word);
        	}else if (word.endsWith("100")){
        		System.out.println("word : "+ word + "밀리그램");
        	}else if (word.endsWith("150")){
        		System.out.println("word : "+ word + "밀리그램");
        	}else if (word.endsWith("200")){
        		System.out.println("word : "+ word+ "밀리그램");
        	}else if (word.endsWith("250")){
        		System.out.println("word : "+ word + "밀리그램");
        	}
        	
        }
    }
}