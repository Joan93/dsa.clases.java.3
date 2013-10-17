package edu.upc.eetac.dsa.ejerciciosclasesesenciales.Comunicacionred;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cliente12 {

	public static void main(String[] args) {
		try {
			System.out.println("Establezco connexión con el servidor");
			Socket canalComunicacion = null;
			InputStream bufferEntrada;
			DataInputStream datos;
			canalComunicacion = new Socket("127.0.0.1", 10831);
			bufferEntrada = canalComunicacion.getInputStream();
			datos = new DataInputStream(bufferEntrada);
			String cadena = new String(datos.readUTF());
			while (cadena.length() > 0) {
				System.out.print(cadena);
				cadena = datos.readUTF();
			}
			datos.close();
			bufferEntrada.close();
			canalComunicacion.close();

		} catch (UnknownHostException ex) {
			Logger.getLogger(cliente12.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (IOException ex) {
			Logger.getLogger(cliente12.class.getName()).log(Level.SEVERE, null,
					ex);
		}

	}
}