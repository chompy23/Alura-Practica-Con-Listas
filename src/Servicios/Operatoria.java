package Servicios;

import Modelos.Tarjeta;

import java.util.*;

public class Operatoria {
    private Scanner datos = new Scanner(System.in).useDelimiter("\\n");
    Tarjeta credito;
    List<Tarjeta> listaCompras;
    private int salir;
    private Float sumaValor = 0.0F;
    private Float nuevoLimite = null;
    private Float limite = 0.0F;
    private Float restaValor;

    public void Comprar(){
            listaCompras = new ArrayList<>();
        System.out.println("**********************");
            int salir = 1;
            System.out.println("Valor del Límite de la Tarjeta:");
            limite = datos.nextFloat();
        while (salir != 0 ) {
            credito = new Tarjeta();
            System.out.println("Nombre del Articulo");
            credito.setArticulo(datos.next());
            System.out.println("Valor de la compra :");
            credito.setValorCompra(datos.nextFloat());
            restaValor = credito.getValorCompra();
            sumaValor += restaValor;
            if (sumaValor > limite) {
                System.out.println("Excedió su Límite de Compra");
                salir = 0;
            }else {
                limite -= restaValor;
                listaCompras.add(credito);
                restaValor = 0.0F;
                System.out.println("Escriba ( 0 ) para salir o ( 1 ) para seguir comprando");
                salir = datos.nextInt();
            }


        }
        Finalizar();


    }

    public  void Finalizar(){
        listaCompras.sort(Comparator.comparing(Tarjeta::getValorCompra));
        System.out.println("************************************");
        listaCompras.forEach((lis) -> {
            System.out.println(lis.getArticulo()+" "+lis.getValorCompra());
        });
        System.out.println("El Límite Restante de la Tarjeta es : "+ limite);
        System.out.println("************************************");
    }
}
