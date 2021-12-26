/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

/**
 *
 * @author Victor Rodriguez
 */
public class ventas {

    private int venta;
    private String empleado;
    private String fecha;
    private int talla;
    private int cantidad;
    private int codigo;
    private String modelo;
    private String color;
    private double precio;
    private double total;

    public ventas() {
    }

    public ventas(int venta, String empleado, String fecha, int talla, int cantidad, int codigo, String modelo, String color, double precio, double total) {
        this.venta = venta;
        this.empleado = empleado;
        this.fecha = fecha;
        this.talla = talla;
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.total = total;
    }
    
    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return venta + "," + empleado + "," + fecha + ","+talla+"," + cantidad + "," + codigo + "," + modelo + "," + color + "," + precio + "," + total;
    }

}
