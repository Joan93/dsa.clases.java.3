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

public class servidor12 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			Date now = new Date();
			String contenido;
			SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			contenido = fecha.format(now);

			ServerSocket puerto = null;
			Socket canalComunicacion = null;
			OutputStream bufferSalida;
			DataOutputStream datos;

			puerto = new ServerSocket(10831);
			canalComunicacion = puerto.accept();
			bufferSalida = canalComunicacion.getOutputStream();

			datos = new DataOutputStream(bufferSalida);
			datos.writeUTF(contenido);
			datos.writeUTF("");
			datos.close();
			bufferSalida.close();
			canalComunicacion.close();

		} catch (IOException ex) {
			Logger.getLogger(servidor12.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}
}