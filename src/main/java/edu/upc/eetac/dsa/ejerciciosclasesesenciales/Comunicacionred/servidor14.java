package edu.upc.eetac.dsa.ejerciciosclasesesenciales.Comunicacionred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class servidor14 {

	public static void main(String args[]) {
		Server server;
		String clientRequest;
		BufferedReader reader;
		PrintWriter writer;

		server = new Server(8001);
		reader = new BufferedReader(new InputStreamReader(server.in));
		writer = new PrintWriter(new OutputStreamWriter(server.out), true);

		writer.println("Bienvenido al Servidor: " + new Date() + "/n");

		while (true) {
			try {

				Date now = new Date();
				String contenido;
				String contenido2;
				SimpleDateFormat fecha = new SimpleDateFormat(
						"dd/MM/yyyy HH:mm:ss");
				contenido = fecha.format(now);
				SimpleDateFormat fecha2 = new SimpleDateFormat(
						"E, dd M yyyy , HH:mm:ss");
				contenido2 = fecha2.format(now);

				clientRequest = reader.readLine();

				int orden;

				orden = Integer.parseInt(clientRequest);

				if (orden == 0) {
					System.out.println(contenido);
					writer.println(contenido);
				} else if (orden == 1) {
					System.out.println(contenido2);
					writer.println(contenido2);
				} else
					System.exit(0);

			} catch (IOException e) {
			}
		}
	}
}

class Server {
	private ServerSocket server;
	private Socket socket;
	public InputStream in;
	public OutputStream out;

	public Server(int port) {

		try {
			server = new ServerSocket(port);
			System.out.println("Servidor Java Activo! \n");
			socket = server.accept();
			in = socket.getInputStream();
			out = socket.getOutputStream();
		} catch (IOException e) {
			System.out.println("Excepción en el constructor server: " + e);
		}
	}
}