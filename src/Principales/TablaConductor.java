
package Principales;

import Conductores.ConductorPOA;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class TablaConductor extends ConductorPOA{
    Conexion conexion = new Conexion();

    @Override
    public boolean insertarConductor(int id, String nombre, int telefono, String placa) {
        boolean resultado = false;
        try {
            String sql = "insert into conductor(id,nombre,telefono,placa) values ('"+id+"','"+nombre+"','"+telefono+"','"+placa+"')";
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
    public boolean actualizarConductor(int id, String nombre, int telefono, String placa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarConductor(int id) {
       boolean resultado = false;
        try {
            String sql = "Delete from cliente where id = "+id;
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
    public String consultarConductor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public ResultSet cargarconductor (){
         ResultSet resultado = null;
         try {
            String sql = "select id,nombre,telefono,placa";
            conexion.conectar();
            Statement st = conexion.conex.createStatement();
            resultado = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
         return resultado;
    }
}


