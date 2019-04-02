package comunicacion;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPConexion extends Thread {

    DatagramSocket socket;
    int PUERTO = 5000;
    static InetAddress address;

    Observador observer;
    
    static UDPConexion comunicacionActual;
    
    public UDPConexion() {
    	start();
    }
    
    static public UDPConexion getIntance() {
    	if(comunicacionActual != null) {
    		return new UDPConexion();
    	}else {
    		return comunicacionActual;
    	}
    }


    @Override
    public void run() {
        try {
            socket = new DatagramSocket();
            socket.setReuseAddress(true);

            address = InetAddress.getByName("172.30.120.45");
//            socket.bind(new InetSocketAddress(5000)); // <-- now bind it
            //172.30.120.45
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        while (true) {
            recibir();
        }
    }

    public void recibir() {

        byte[] mensaje = new byte[100];
        DatagramPacket datagrama = new DatagramPacket(mensaje, mensaje.length);
        try {

            System.out.println("Esperando respuesta");
            socket.receive(datagrama);
   
            String respuesta = new String(datagrama.getData());

            this.observer.recibido(respuesta);





        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviar(final String mensaje) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                DatagramPacket datagrama = new DatagramPacket(mensaje.getBytes(), mensaje.length(), address, PUERTO);
                try {
                    socket.send(datagrama);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    public interface Observador {
        public void recibido(String respuesta);
    }

    public void setObserver(Observador observer) {
        this.observer = observer;
    }
    
}