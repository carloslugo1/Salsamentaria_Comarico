package Principales;

import Clientes.ClientePOA;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author FRESKMANN SILVA
 */
public class Cliente extends ClientePOA{
    Conexion conexion = new Conexion();
   @Override
    public boolean insertarCliente(int codigoCliente, String Nit, String nombre, int telefono, String direccion) {
        boolean resultado = false;
        try {
            String sql = "insert into cliente(CodigoCliente,Nit,nombre,telefono,Direccion) values ('"+codigoCliente+"','"+Nit+"','"+nombre+"','"+telefono+"','"+direccion+"')";
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
    public boolean actualizarCliente(int codigoCliente, String Nit, String nombre, int telefono, String direccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   @Override
    public boolean eliminarCliente(int Cod_cliente) {
         boolean resultado = false;
        try {
            String sql = "Delete from cliente where Codigocliente = "+Cod_cliente;
            conexion.conectar();
            Statement st = conexion.conex.createStatement();
            int valor = st.executeUpdate(sql);
            if(valor>0){
                resultado = true;
            }
            //Se cierran las conexiones.
            conexion.conex.close();
            st.close();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al eliminar. "+e.getMessage());
        }        
        return resultado;
    }
   @Override
    public String consultarCliente(int Cod_cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
       
    public ResultSet cargarCliente (){
         ResultSet resultado = null;
         try {
            String sql = "select Codigocliente,Nit, nombre, telefono, Direccion from cliente";
            conexion.conectar();
            Statement st = conexion.conex.createStatement();
            resultado = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
         return resultado;
}

    
    
}
