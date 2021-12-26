/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import Principal.jPrincipal;
import Principal.principalUser;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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
public class operacionesusuarios {
    public void Escritura(String nomArchivo, user e) {
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
    public boolean validarDatos(String nomArchivo, String user, String pass, String tpo){
        String cadena = "";
        FileReader fr;
        user al = null;
        try {
            al = new user();
            fr = new FileReader(nomArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadena = archivoLectura.readLine();
            while (cadena != null) {
                StringTokenizer st = new StringTokenizer(cadena, ",");
                int id=Integer.parseInt(st.nextToken());
                String usuario = st.nextToken();
                String contraseña = st.nextToken();
                String tipo = st.nextToken();
                if (user.equals(usuario) && pass.equals(contraseña) ) {
                    if(tpo.equals("Administrador")){
                    al.setId(id);
                    al.setUsuario(usuario);
                    al.setPass(contraseña);
                    al.setTipo(tipo);
                    jPrincipal p = new jPrincipal();
                    p.setVisible(true);
                    jPrincipal.empleado.setText(user);
                    p.setExtendedState(MAXIMIZED_BOTH);
                    return true;
                    }
                }
                    if (user.equals(usuario) && pass.equals(contraseña) ) {
                    if(tpo.equals("Empleado")){
                    al.setId(id);
                    al.setUsuario(usuario);
                    al.setPass(contraseña);
                    al.setTipo(tipo);
                    principalUser p = new principalUser();
                    p.setVisible(true);
                    principalUser.empleado_user.setText(user);
                    p.setExtendedState(MAXIMIZED_BOTH);
                    return true;
                    }
                    
                     // return al;       
                   // return al;
                }

                cadena = archivoLectura.readLine();
            }
            archivoLectura.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se puede leer el archivo");
            e.printStackTrace();

        }
        return false;
    }
    public user buscar(String nomArchivo, int c) {
        String datos = "";
        String cadena = "";
        FileReader fr;
        user al = null;
        try {
            al = new user();
            fr = new FileReader(nomArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadena = archivoLectura.readLine();
            while (cadena != null) {
                StringTokenizer st = new StringTokenizer(cadena, ",");
                int id=Integer.parseInt(st.nextToken());
//                String usuario = st.nextToken();
//                String contraseña = st.nextToken();
//                String tipo = st.nextToken();
                if (id==c) {
                    al.setId(id);
                    al.setUsuario(st.nextToken());
                    al.setPass(st.nextToken());
                    al.setTipo(st.nextToken());

                      return al;       
                   // return al;
                }

                cadena = archivoLectura.readLine();
            }
            archivoLectura.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se puede leer el archivo");
            e.printStackTrace();

        }
       return al;
    }
     public boolean Eliminar(String nomArchivo, String temporal, int i) {
        String cadenaEncontrada = "";
        FileReader fr;
        try {
            fr = new FileReader(nomArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            user al = new user();
            cadenaEncontrada = archivoLectura.readLine();
            while (cadenaEncontrada != null) {
                StringTokenizer st = new StringTokenizer(cadenaEncontrada, ",");
                int indice = Integer.parseInt(st.nextToken());
                if (indice != i) {
                    try {
                        FileWriter fw = new FileWriter(temporal, true);
                        BufferedWriter archivoEscritura = new BufferedWriter(fw);
                        al.setId(indice);
                        al.setUsuario(st.nextToken());
                        al.setPass(st.nextToken());
                        al.setTipo(st.nextToken());
                        String guardar = al.toString();
                        archivoEscritura.write(guardar);
                        archivoEscritura.newLine();
                        archivoEscritura.flush();
                        archivoEscritura.close();
                        fw.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
                cadenaEncontrada = archivoLectura.readLine();
            }
            archivoLectura.close();
            fr.close();
            File file = new File(nomArchivo);
            file.delete();
            File file2 = new File(temporal);
            file2.renameTo(file);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo");
        }
        return false;
    }


    public boolean modificar(String Archivo, int c, user al, String temporal) {
    String cadenaEncontrada = "";
        FileReader fr;
        try {
            fr = new FileReader(Archivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaEncontrada = archivoLectura.readLine();
            while (cadenaEncontrada != null) {
                StringTokenizer st = new StringTokenizer(cadenaEncontrada, ",");
                int indice = Integer.parseInt(st.nextToken());
                if (indice != c) {
                    try {
                        FileWriter fw = new FileWriter(temporal, true);
                        BufferedWriter archivoEscritura = new BufferedWriter(fw);
                        String guardar = al.toString();
                        archivoEscritura.write(guardar);
                        archivoEscritura.newLine();
                        al.setId(indice);
                        al.setUsuario(st.nextToken());
                        al.setPass(st.nextToken());
                        al.setTipo(st.nextToken());
                        String guardar2 = al.toString();
                        archivoEscritura.write(guardar2);
                        archivoEscritura.newLine();
                        archivoEscritura.flush();
                        archivoEscritura.close();
                        fw.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
                cadenaEncontrada = archivoLectura.readLine();
            }
            archivoLectura.close();
            fr.close();
            File file = new File(Archivo);
            file.delete();
            File file2 = new File(temporal);
            file2.renameTo(file);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo");
        }
        return false;    
    }
    
    public DefaultTableModel listausuarios(){
        Vector ca = new Vector();
//                em.setId(Integer.parseInt(this.id.getText()));
//        em.setUsuario(user);
//        em.setPass(pass);
//        em.setTipo(tipousuario);
        ca.addElement("ID");
        ca.addElement("Usuario");
        ca.addElement("Contraseña");
        ca.addElement("Tipo");
        DefaultTableModel tabla= new DefaultTableModel(ca,0);
        try{
            FileReader fr = new FileReader("usuarios.txt");
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
