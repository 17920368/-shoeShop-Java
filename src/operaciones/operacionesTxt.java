/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor Rodriguez
 */
public class operacionesTxt {

    ArrayList<ventas> emp = new ArrayList();

    public void Escritura(String nomArchivo, ventas e) {
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

    public ventas con1(String nomArchivo, String nom) {
        String datos = "";
        ventas al = null;
        String cadena = "";
        FileReader fr;
        try {
            al = new ventas();
            fr = new FileReader(nomArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadena = archivoLectura.readLine();
            while (cadena != null) {
                StringTokenizer st = new StringTokenizer(cadena, ",");
                int venta = Integer.parseInt(st.nextToken());
                String empleado = st.nextToken();
                String fe = st.nextToken();
                int talla = Integer.parseInt(st.nextToken());
                int cantidad = Integer.parseInt(st.nextToken());
                int codigo = Integer.parseInt(st.nextToken());
                String modelo = st.nextToken();
                String color = st.nextToken();
                double precio = Double.parseDouble(st.nextToken());
                double total = Double.parseDouble(st.nextToken());
                if (nom.equals(empleado)) {
                    al.setVenta(venta);
                    al.setEmpleado(empleado);
                    al.setFecha(fe);
                    al.setTalla(talla);
                    al.setCantidad(cantidad);
                    al.setCodigo(codigo);
                    al.setModelo(modelo);
                    al.setColor(color);
                    al.setPrecio(precio);
                    al.setTotal(total);

//                    al.setNomCliente(cliente);
//                    al.setFecha(fe);
//                    al.setTipoPago(tipopago);
//                    al.setImporte(importe);
//                    al.setArreglo(arreglo);
//                    al.setNumPedido(pedido);
                    return al;
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

    public String con2(String nomArchivo) {
        String cadena = "", datos = "";
        FileReader fr;

        try {
            fr = new FileReader(nomArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            ventas al = new ventas();
            cadena = archivoLectura.readLine();
            while (cadena != null) {
                StringTokenizer st = new StringTokenizer(cadena, ",");
                int venta = Integer.parseInt(st.nextToken());
                String empleado = st.nextToken();
                String fe = st.nextToken();
                int talla = Integer.parseInt(st.nextToken());
                int cantidad = Integer.parseInt(st.nextToken());
                int codigo = Integer.parseInt(st.nextToken());
                String modelo = st.nextToken();
                String color = st.nextToken();
                double precio = Double.parseDouble(st.nextToken());
                double total = Double.parseDouble(st.nextToken());
                al.setVenta(venta);
                al.setEmpleado(empleado);
                al.setFecha(fe);
                al.setTalla(talla);
                al.setCantidad(cantidad);
                al.setCodigo(codigo);
                al.setModelo(modelo);
                al.setColor(color);
                al.setPrecio(precio);
                al.setTotal(total);
                //System.out.println(al.toString());
                // datos+=al.toString()+"\n";
                datos += "Los zapatos vendidos son: " + al.getModelo() + "\n";
                cadena = archivoLectura.readLine();

            }
            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("no se encuentra el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("no se encuentra el archivo");
            e.printStackTrace();

        }
        return datos;
    }

    public String con3(String nomArchivo) {
        double a = 0;
        String cadena = "", datos = "";
        FileReader fr;

        try {
            fr = new FileReader(nomArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            ventas al = new ventas();
            cadena = archivoLectura.readLine();
            while (cadena != null) {
                StringTokenizer st = new StringTokenizer(cadena, ",");
                int venta = Integer.parseInt(st.nextToken());
                String empleado = st.nextToken();
                String fe = st.nextToken();
                int talla = Integer.parseInt(st.nextToken());
                int cantidad = Integer.parseInt(st.nextToken());
                int codigo = Integer.parseInt(st.nextToken());
                String modelo = st.nextToken();
                String color = st.nextToken();
                double precio = Double.parseDouble(st.nextToken());
                double total = Double.parseDouble(st.nextToken());
                al.setVenta(venta);
                al.setEmpleado(empleado);
                al.setFecha(fe);
                al.setTalla(talla);
                al.setCantidad(cantidad);
                al.setCodigo(codigo);
                al.setModelo(modelo);
                al.setColor(color);
                al.setPrecio(precio);
                al.setTotal(total);
                a += total;
                //  return a;
                //System.out.println(al.toString());
                // datos+=al.toString()+"\n";
                datos = "Las ganacias totales son: " + a;
                cadena = archivoLectura.readLine();

            }
            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("no se encuentra el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("no se encuentra el archivo");
            e.printStackTrace();

        }
        return datos;
    }

//       public float con3(String nomArchivo, String nom) {
//        String datos = "";
//        float ganancias=0;
//        ventas al = null;
//        String cadena = "";
//        FileReader fr;
//        try {
//            al = new ventas();
//            fr = new FileReader(nomArchivo);
//            BufferedReader archivoLectura = new BufferedReader(fr);
//            cadena = archivoLectura.readLine();
//            while (cadena != null) {
//                StringTokenizer st = new StringTokenizer(cadena, ",");
//                int venta = Integer.parseInt(st.nextToken());
//                String empleado = st.nextToken();
//                String fe = st.nextToken();
//                int talla = Integer.parseInt(st.nextToken());
//                int cantidad = Integer.parseInt(st.nextToken());
//                int codigo = Integer.parseInt(st.nextToken());
//                String modelo = st.nextToken();
//                String color = st.nextToken();
//                double precio = Double.parseDouble(st.nextToken());
//                double total = Double.parseDouble(st.nextToken());
//                if (nom.equals(empleado)){
//                      al.setVenta(venta);
//                      al.setEmpleado(empleado);
//                      al.setFecha(fe);
//                      al.setTalla(talla);
//                      al.setCantidad(cantidad);
//                      al.setCodigo(codigo);
//                      al.setModelo(modelo);
//                      al.setColor(color);
//                      al.setPrecio(precio);
//                      al.setTotal(total);
//                      ganancias+=total;
////                    al.setNomCliente(cliente);
////                    al.setFecha(fe);
////                    al.setTipoPago(tipopago);
////                    al.setImporte(importe);
////                    al.setArreglo(arreglo);
////                    al.setNumPedido(pedido);
//                    return ganancias;
//                }
//
//                cadena = archivoLectura.readLine();
//            }
//            archivoLectura.close();
//
//        } catch (FileNotFoundException e) {
//            System.out.println("No se encuentra el archivo");
//            e.printStackTrace();
//        } catch (IOException e) {
//            System.out.println("No se puede leer el archivo");
//            e.printStackTrace();
//
//        }
//        return ganancias;
//    }
    public DefaultTableModel listaventas(){
        Vector ca = new Vector();
        ca.addElement("Venta");
        ca.addElement("Empleado");
        ca.addElement("Fecha");
        ca.addElement("Talla");
        ca.addElement("Cantidad");
        ca.addElement("Codigo");
        ca.addElement("Modelo");
        ca.addElement("Color");
        ca.addElement("Precio");
        ca.addElement("Total");
        DefaultTableModel tabla= new DefaultTableModel(ca,0);
        try{
            FileReader fr = new FileReader("ventas.txt");
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
         //   JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e);
        }
        return tabla;
    }
}
