import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);

		// Create the socket object for carrying the data.
		DatagramSocket ds = new DatagramSocket();

		InetAddress ip = InetAddress.getLocalHost();
		byte buf[] = null;

		while (true)
		{
			String inp = sc.nextLine();

			// convert the String input into the byte array.
			buf = inp.getBytes();

			//  Create the datagramPacket for sending the data.
			DatagramPacket DpSend =
				new DatagramPacket(buf, buf.length, ip, 1234);

			//  invoke the send call to actually send the data.
			ds.send(DpSend);

			if (inp.equals("stop"))
				break;
		}
	}
}
