package Conductores;


/**
* Conductores/ConductorOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from conductor.idl
* lunes 13 de mayo de 2019 05:14:30 PM COT
*/

public interface ConductorOperations 
{
  boolean insertarConductor (int id, String nombre, int telefono, String placa);
  boolean actualizarConductor (int id, String nombre, int telefono, String placa);
  boolean eliminarConductor (int id);
  String consultarConductor (int id);
  void shutdown ();
} // interface ConductorOperations