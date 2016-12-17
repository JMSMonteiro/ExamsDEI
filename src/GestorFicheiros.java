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
    
    /**
     * Abre o input Stream
     * @param fileName Nome do ficheiro 
     * @throws IOException 
     */
    public void openORead(String fileName) throws IOException{
        inS = new ObjectInputStream(new FileInputStream(fileName));
    }
    
    /**
     * Abre o output stream
     * @param fileName Nome do ficheiro
     * @throws IOException 
     */
    public void openOWrite(String fileName) throws IOException{
        outS = new ObjectOutputStream(new FileOutputStream(fileName));
    }
    
    /**
     * 
     * @return devolve o stream de informação
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Object readObject() throws IOException, ClassNotFoundException{
        return inS.readObject();
    }
    
    /**
     * 
     * @param o Objeto que vai ser escrito
     * @throws IOException 
     */
    public void writeObject(Object o) throws IOException{
        outS.writeObject(o);
    }
    
    /**
     * Fecha o  Input Stream
     * @throws IOException 
     */
    public void closeORead() throws IOException{
        inS.close();
    }
    
    /**
     * Fecha o output stream
     * @throws IOException 
     */
    public void closeOWrite() throws IOException{
        outS.close();
    }

    /**
     * Escreve um ArrayList no ficheiro de objetos
     * @param fileName Nome do ficheiro
     * @param list ArrayList que vai ser escrita
     */
    public void writeObjectFileArray(String fileName, ArrayList list){
        try{
            openOWrite(fileName);
            writeObject(list);
            closeOWrite();
        }
        catch(IOException e){
            System.out.println("Error opening file.");
        }
    }

    /**
     * Lê o ArrayList do ficheiro de objetos
     * @param fileName Nome do ficheiro
     * @return devolve o Array lido
     */
    public ArrayList readObjectFileArray(String fileName){
        ArrayList list = new ArrayList();
        try{
            openORead(fileName);
            list = (ArrayList)readObject();
            closeORead();
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return list;
    }
}
