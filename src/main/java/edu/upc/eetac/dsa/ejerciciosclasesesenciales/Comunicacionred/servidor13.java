package edu.upc.eetac.dsa.ejerciciosclasesesenciales.Comunicacionred;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class servidor13 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			ServerSocket puerto = new ServerSocket(10831);
			System.out.println("Escucho el puerto " + 10831 );

			for ( int numCli = 0; numCli < 3; numCli++) { // aceptamos por ejemplo tres 
														  // clientes como máximo
				
			Date now = new Date();
			String contenido;
			SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			contenido = fecha.format(now);

			Socket canalComunicacion = null;
			OutputStream bufferSalida;
			DataOutputStream datos;
		
			canalComunicacion = puerto.accept();
			bufferSalida = canalComunicacion.getOutputStream();

			datos = new DataOutputStream(bufferSalida);
			datos.writeUTF(contenido);
			datos.writeUTF("");
			datos.close();
			bufferSalida.close();
			canalComunicacion.close();
			}
		}
			catch (IOException ex) {
			Logger.getLogger(servidor12.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}
	}
