import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server
{
	public static void main(String[] args) throws IOException
	{
		// Create a socket to listen at port 1234
		DatagramSocket ds = new DatagramSocket(1234);
		byte[] receive = new byte[65535];

		DatagramPacket DpReceive = null;
		while (true)
		{

			//  create a DatgramPacket to receive the data.
			DpReceive = new DatagramPacket(receive, receive.length);

			// recieve the data in byte buffer.
			ds.receive(DpReceive);

			System.out.println("Client:-" + data(receive));

			// Exit the server if the client sends "stop"
			if (data(receive).toString().equals("stop"))
			{
				System.out.println("Client sent stop");
				break;
			}

			// Clear the buffer after every message.
			receive = new byte[65535];
		}
	}

	// method to convert the byte array
	// data into a string representation.
	public static StringBuilder data(byte[] a)
	{
		if (a == null)
			return null;
		StringBuilder ret = new StringBuilder();
		int i = 0;
		while (a[i] != 0)
		{
			ret.append((char) a[i]);
			i++;
		}
		return ret;
	}
}
