package com.numions.infoOrder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController //Se devuele un string , un json etc...
@RequestMapping("info")
//PAtron ressts: Como se comunican las aplicaciones,estructura de endpoints
public class ControllerInfoOrder {

    ListaPedidos lista = new ListaPedidos();


    @PostMapping("addOrder/{idPedido}/{nombre}/{fecha}")
    public ResponseEntity<Object> añadirPedido(@PathVariable int idPedido, @PathVariable Boolean nombre,@PathVariable int fecha) {


        Pedido prueba = new Pedido(idPedido, nombre,fecha);

        lista.addProduct(prueba);

        if (lista.getProductosDelCatalogo().size() == 0) {
            String var = "No hay productos en el catalogo";
            return new ResponseEntity<>(var, HttpStatus.OK);

        } else {
            String var = "Has añadido el producto " + nombre + "\n";
            return new ResponseEntity<>(var, HttpStatus.CREATED);

        }

    }





        @GetMapping("Orders")
        public ResponseEntity<String> mostrarProdcutos(){

            String var1 = "Estas viendo la lista de productos del catalogo \n";
            String var2 = "";

            if (lista.getProductosDelCatalogo().size()==0){
                var2 = "No hay productos \n";
            }
            else {
                for (int i=0;i<lista.size();i++){
                    var2 += lista.getProductosDelCatalogo().get(i).id + "\n";
                }
            }


            return new ResponseEntity<>(var1 + var2, HttpStatus.OK);
        }

  /*      @GetMapping("Catalog/{idProducto}")


        public ResponseEntity<String> mostrar1Producto (@PathVariable int idProducto){
            String var = "Estas viendo el producto" +"" + idProducto;
            return new ResponseEntity<>(var,HttpStatus.OK);
        }*/




    //Cancel Order
    @DeleteMapping("CancelOrder/{idPedido}")

    public ResponseEntity<String> removeId(@PathVariable int idPedido) {

        if (lista.size() == 0) {
            return new ResponseEntity<>("No hay contenido que borrar", HttpStatus.NO_CONTENT);
        }

        int tamano = lista.size();
        String var;
        lista.removePedido(idPedido);

        if (tamano == lista.size()) {

            var = "No se ha podido eliminar el" + "" + idPedido;
        } else {
            var = "Has cancelado el pedido" + "" + idPedido;
        }
        return new ResponseEntity<>(var, HttpStatus.OK);


    }

    @GetMapping("Delivery")
    public ResponseEntity<String> mostrarFecha(){

        String var1 = "La fecha de entrega esperada es \n";
        int var2 = 0;
        for (int i=0; i<lista.size(); i++){
            var2= lista.getProductosDelCatalogo().get(i).fecha;


        }

                return new ResponseEntity<>(var2, HttpStatus.OK);
    }

}

