package com.numions.infoOrder;

import java.util.Date;
import java.util.List;

public class Pedido {


        int id;
        Boolean status;
        int fecha;

    public Pedido(int id, Boolean status, int fecha) {
        this.id = id;
        this.status = status;
        this.fecha = this.fecha;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate(){
        return fecha;
    }

    public void setDate (int date){
        this.fecha = fecha;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}



