package javaapplication1.models;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class OompaLoompaSong {
    private int numberOfLines;
    private ArrayList<String> linesArray;
    private String filePath = "OompaLoompaSong.txt";

    public OompaLoompaSong(int lines){
        this.numberOfLines = lines;
        linesArray = new ArrayList<>();
    };  

    public String getFilePath(){
            return filePath;
    }   
    public void setFilePath(String path){
            this.filePath = path;
    }
    
    public void readFile(){
        try {
            Scanner scanner = new Scanner( new File(filePath) );
            while ( scanner.hasNextLine() )  {
                linesArray.add(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e) {
           e.getMessage();
        } 
    }
        
    public void sing() {
        int randIndex = 0;
        readFile();
        for(int i = 0; i < numberOfLines; i++){
            Random rand = new Random();
            randIndex = rand.nextInt(linesArray.size()-1);
            System.out.println(linesArray.get(randIndex));
        }
    }
    

}


