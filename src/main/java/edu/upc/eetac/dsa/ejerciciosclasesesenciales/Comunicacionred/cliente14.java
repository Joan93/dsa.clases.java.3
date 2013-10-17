package edu.upc.eetac.dsa.ejerciciosclasesesenciales.Comunicacionred;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cliente14 {

	public static void main(String[] args) {
		try {
			
			Socket s = new Socket("127.0.0.1", 8001);
			PrintStream writer = new PrintStream(s.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			int mensaje;
			Scanner sc = new Scanner(System.in);
	

			System.out.print("Introduce una operación (0 o 1):         ");
			mensaje = Integer.parseInt(sc.next());
			writer.println(mensaje);
			
			String serverrequest = reader.readLine();
			
			System.out.print(serverrequest);
			s.close();
			
			
		} catch (UnknownHostException ex) {
			Logger.getLogger(cliente14.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (IOException ex) {
			Logger.getLogger(cliente14.class.getName()).log(Level.SEVERE, null,
					ex);
		}

	}
}