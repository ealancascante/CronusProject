package vista;

import controlador.ControladorConsola;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VistaConsola {
    private String entrada = "", respuesta = "", rutaActual = "", cliente = "";
        
    public void interfazConsola(ControladorConsola pControladorConsola) throws IOException{
        mensajeBienvenida();
        //creamos el disco
        while(!pControladorConsola.isTerminarPrograma()){
            System.out.print("<"+ cliente + "@" + rutaActual + ">");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            entrada = br.readLine();
            pControladorConsola.setEntrada(entrada);
            pControladorConsola.atenderConsola();
            respuesta = pControladorConsola.getRespuesta();
            rutaActual = pControladorConsola.getRutaActual();
            cliente = pControladorConsola.getCliente();
            System.out.println(respuesta + "\n");
        }
    }
    
    public void mensajeBienvenida(){
        String bienvenida = 
                  "----------------\n"
                + "   FILE SYSTEM\n"
                + "----------------\n"
                + "Bienvenido :)\n"
                + "Para ayuda en cualquier \n"
                + "momento ejecute comando:\n"
                + "-> \"ayuda\"\n \n"
                + "Por favor, cree el disco.\n";
        System.out.print(bienvenida);
    }
    
    public String getDecision(){
        String decision = "";
        try{
            while(!decision.toLowerCase().equals("y") && !decision.toLowerCase().equals("n")){
                System.out.println("Desea remplazar el original por uno nuevo?(Y/N): ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                decision = br.readLine();
            }
            return decision.toLowerCase();
        }
        catch(Exception e){
            return "n";
        }
    }
}
