package JavaPrj.kopo;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import JavaPrj.kopo.util.UrlUtil;

public class AppImageRequest {
	
	public static void main(String[] args) throws Exception{
		
		System.out.println("Hello word");
		
        UrlUtil uu = new UrlUtil();
        
        String url = "http://127.0.0.1:8001";
        String api = "/ImageOcrForJson";
        String pName = "?pFIle=";   
        String pFile = "20210802_21.39.48.png";
        //System.out.println("pFile : " + pFile);
       // File TFile = new File("20210802_21.39.48.png");
        System.out.println("pFile : " + pFile);
        String res = uu.urlReadforString(url + api + pName + URLEncoder.encode(pFile,"UTF-8"));
        
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
        	
        	System.out.println("word : "+ word);
        }
        
	}

}
