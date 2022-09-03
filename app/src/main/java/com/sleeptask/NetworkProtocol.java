package com.sleeptask;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkProtocol {

    static String ip_address;
	static int network_port;
	public NetworkProtocol(String ip_address , int network_port) {
		this.ip_address = ip_address;
		this.network_port = network_port;


	}
    public static void tcpService() {
		try {
			ServerSocket server=new ServerSocket(network_port);

			Socket socket=new Socket(ip_address, network_port);

			InputStream input=null;

			OutputStream output=null;
			//-----------------
			byte[] cache_pool=new byte[1024];


			socket = server.accept();

			input = socket.getInputStream();

			int byte_length=input.read(cache_pool);
			//---------------

			byte[] file="".getBytes();

			output = socket.getOutputStream();

			output.write(file, 0, file.length);
			//------------------


		} catch (IOException e) {}

	}
	public static void udpService() {
		try {
			DatagramSocket io=new DatagramSocket(network_port);


			byte[] file="".getBytes();
			
			DatagramPacket output_packet=new DatagramPacket(file, 0, file.length, InetAddress.getByAddress(ip_address.getBytes()), network_port);


			byte[] cache_pool=new byte[1024];
			DatagramPacket input_packet=new DatagramPacket(cache_pool, 0, cache_pool.length);
			
			while (true) {
				try {
					io.receive(input_packet);
					int byte_length=input_packet.getLength();
					String read_cache=new String(cache_pool, 0, byte_length);
				} catch (IOException e) {}

			}
		} catch (UnknownHostException e) {
		} catch (SocketException e) {}
	}
}
