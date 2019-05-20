package Principales;

import Conexion.Conexion;
import Ventas.*;
import java.sql.*;
import javax.swing.JOptionPane;

        
public class TablaVenta extends VentaPOA {
    Conexion conexion = new Conexion();

    @Override
    public boolean insertarVenta(int id_venta, double subtotal, double iva, double total_pagar) {
        boolean resultado = false;
        try {
            String sql = "insert into venta(id_venta,subtotal,iva,total_pagar) values ('"+id_venta+"','"+subtotal+"','"+iva+"','"+total_pagar+"')";
            conexion.conectar();
            Statement st = conexion.conex.createStatement();
            int valor = st.executeUpdate(sql);
            if(valor>0){
                resultado = true;
            }
            //Se cierran las conexiones
            conexion.conex.close();
            st.close();
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al insertar. "+e.getMessage());
        }        
        return resultado; 
    }

    @Override
    public boolean actualizarVenta(int id_venta, double producto, double precio, double cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarVenta(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String consultarVenta(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet consultarProductoCombo(){
        ResultSet resultado = null;
        try {
            String sentenciaSql = "select id, nombre, precio from productos";
            conexion.conectar();
            Statement st = conexion.conex.createStatement();
            resultado = st.executeQuery(sentenciaSql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al consultar: "+ e.getMessage());
        }
            return resultado;
    }
   }