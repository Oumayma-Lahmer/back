package com.fss.pharmacie.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Panier {
    private List<PanierElem> elemList = new ArrayList<>();

    public void ajoutProduit (PanierElem elem){
        elemList.add(elem);
    }

    public void effacerProduit(PanierElem elem){
        elemList.remove(elem);
    }
    public void clear(){
        elemList.clear();
    }
}
