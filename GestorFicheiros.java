/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorDeExames;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author jmmonteiro
 */
public class GestorFicheiros {
    private ObjectInputStream inS;
    private ObjectOutputStream outS;
    
    public void openORead(String fileName) throws IOException{
        inS = new ObjectInputStream(new FileInputStream(fileName));
    }
    
    public void openOWrite(String fileName) throws IOException{
        outS = new ObjectOutputStream(new FileOutputStream(fileName));
    }
    
    public Object readObject() throws IOException, ClassNotFoundException{
        return inS.readObject();
    }
    
    public void writeObject(Object o) throws IOException{
        outS.writeObject(o);
    }
    
    public void closeORead() throws IOException{
        inS.close();
    }
    
    public void closeOWrite() throws IOException{
        outS.close();
    }

    public void writeObjectFileArray(String fileName, ArrayList<Pessoa> list){
        try{
            openOWrite(fileName);
            writeObject(list);
            closeOWrite();
        }
        catch(IOException e){
            System.out.println("Error opening file.");
        }
    }

    public ArrayList readObjectFileArray(String fileName){
        ArrayList list = new ArrayList();
        try{
            openORead(fileName);
            list = (ArrayList)readObject();
            closeORead();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return list;
    }
}
