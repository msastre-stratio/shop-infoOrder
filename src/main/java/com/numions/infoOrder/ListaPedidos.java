package com.numions.infoOrder;

import java.util.ArrayList;
import java.util.List;



    public class ListaPedidos {

               List<Pedido> pedidos;



        public ListaPedidos() {
            this.pedidos =new ArrayList<>();
        }

        public int size(){return pedidos.size();}
        public List<Pedido> getProductosDelCatalogo() {
            return pedidos;
        }

        public void setProductosDelCatalogo(List<Pedido> productosDelCatalogo) {
            this.pedidos = productosDelCatalogo;
        }

        public void addProduct (Pedido prod) {
            pedidos.add(prod);
            System.out.print(pedidos.size());

        }
        public void removePedido(int id) {
            {

                for (int i = 0; i < pedidos.size(); i++) {
                    if (id == pedidos.get(i).id) {
                        pedidos.remove(i);
                    }

                }

            }
        }}


