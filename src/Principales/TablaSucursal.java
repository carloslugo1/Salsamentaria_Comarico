
package Principales;

import Conexion.Conexion;
import Sucursales.SucursalPOA;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class TablaSucursal extends SucursalPOA{
    Conexion conexion = new Conexion();

    @Override
    public boolean insertarSucursal(int codigo, String ciudad, int telefono, String direccion) {
        boolean resultado = false;
        try {
            String sql = "insert into sucursal(Codigo,ciudad,telefono,Direccion) values ('"+codigo+"','"+ciudad+"','"+telefono+"','"+direccion+"')";
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
    public boolean actualizarSucursal(int codigo, String ciudad, int telefono, String direccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarSucursal(int Codigo) {
          boolean resultado = false;
        try {
            String sql = "Delete from sucursal where Codigo = "+Codigo;
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
    public String consultarSucursal(int Codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public ResultSet cargarSucursal (){
         ResultSet resultado = null;
         try {
            String sql = "select Codigo, ciudad, telefono, direccion from sucursal";
            conexion.conectar();
            Statement st = conexion.conex.createStatement();
            resultado = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
         return resultado;
}
    
}
