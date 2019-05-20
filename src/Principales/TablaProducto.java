package Principales;
import Producto.* ;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Conexion.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class TablaProducto extends ProductosPOA{
           Conexion conexion = new Conexion();
    @Override
    public boolean insertarProveedor(int id, String nombre, int precio, int id_proveedor) {
 boolean resultado = false;
        try {
            String sql = "insert into productos(id,nombre,precio,id_proveedor) values ('"+id+"','"+nombre+"','"+precio+"','"+id_proveedor+"')";
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
    public boolean actualizarProveedor(int id, String nombre, int precio, int id_proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarProveedor(int id) {
 boolean resultado = false;
        try {
            String sql = "DELETE FROM productos WHERE id ="+id;
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
    public String consultarProveedor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet cargaProducto (){
         ResultSet resultado = null;
         try {
            String sql = "select id, nombre, precio, id_proveedor from productos";
            conexion.conectar();
            Statement st = conexion.conex.createStatement();
            resultado = st.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }
         return resultado;
    
   }
    
     public ResultSet consultarEstado(){
        ResultSet resultado = null;
        try {
            String sentenciaSql = "Select Cod_proveedor, nombre from proveedor";
            conexion.conectar();
            Statement st = conexion.conex.createStatement();
            resultado = st.executeQuery(sentenciaSql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al consultar: "+ e.getMessage());
        }
            return resultado;
    }
    
}
