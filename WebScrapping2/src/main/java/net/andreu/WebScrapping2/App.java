package net.andreu.WebScrapping2;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	BufferedWriter escriure = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Llista de capitals.txt"), "utf-8"));
    	Document doc=Jsoup.connect("https://ca.wikipedia.org/wiki/Llista_de_capitals_europees").get();
    	
    	Elements taula = doc.select("tbody");
    	Elements files = taula.select("tr");
    	
    	for(int i=1; i<files.size(); i++){
    		Elements td = files.get(i).select("td");
    		
    		escriure.write("INSERT INTO europeus (nom, codiiso, capital, superficie, habitants)VALUES (\""+td.get(1).text()+"\", \""+td.get(2).text()+"\", \""+td.get(5).text()+"\", \""+td.get(3).text()+"\",\""+td.get(4).text()+"\");\n");
    	}
    	escriure.close();
    }
}
