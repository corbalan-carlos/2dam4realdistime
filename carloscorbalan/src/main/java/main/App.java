package main;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TipoDispositivosService a= new TipoDispositivosService();
        System.out.print(a.getTipoDispositivoMasLogs().getNombre());
        RedesService b=new RedesService();
        System.out.print(b.haUsadoRedUsuario(1, 1));
        UsuariosService c=new UsuariosService();
        for (InfoUsuarios iu:c.getInfoUsuarios()) {
        	System.out.println(iu.correo+"\t"+iu.numLogs+"\t"+iu.fechaMinima+"\t"+iu.fechaMaxima);
        }
        
    }
}
