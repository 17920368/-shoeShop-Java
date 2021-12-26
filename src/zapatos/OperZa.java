/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zapatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor Rodriguez
 */
public class OperZa {
    public void Escritura(String nomArchivo, zapatos e) {
        try {
            FileWriter fw = new FileWriter(nomArchivo, true);
            BufferedWriter archivoEscritura = new BufferedWriter(fw);
            String guardar = e.toString();
            archivoEscritura.write(guardar);
            archivoEscritura.newLine();//como salto de linea
            archivoEscritura.flush();//para borrar el bufferedWrite
            archivoEscritura.close();//cierra el archivo
        } catch (IOException a) {
            System.out.println(a);

        }

    }
     public DefaultTableModel listausuarios(){
        Vector ca = new Vector();
//                em.setId(Integer.parseInt(this.id.getText()));
//        em.setUsuario(user);
//        em.setPass(pass);
//        em.setTipo(tipousuario);
        ca.addElement("Codigo");
        ca.addElement("Modelo");
        ca.addElement("Numero");
        ca.addElement("Color");
        ca.addElement("Precio");
        ca.addElement("Stock");
        DefaultTableModel tabla= new DefaultTableModel(ca,0);
        try{
            FileReader fr = new FileReader("zapatos.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while((d=br.readLine())!=null){
                StringTokenizer dato= new StringTokenizer(d,",");
                Vector x = new Vector();
                while(dato.hasMoreElements()){
                    x.addElement(dato.nextToken());
                }
                tabla.addRow(x);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return tabla;
    }
}
