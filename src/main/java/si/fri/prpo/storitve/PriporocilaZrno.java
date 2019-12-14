package si.fri.prpo.storitve;

import si.fri.prpo.entitete.Priporocilo;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PriporocilaZrno {

    private List<Priporocilo> seznamPriporocil;

    @PostConstruct
    private void init(){
        seznamPriporocil = new ArrayList<>();
    }

    public int vrniIdZadnjegaPriporocila(){
            if(seznamPriporocil.size() > 0){
                return seznamPriporocil.get(seznamPriporocil.size() -1).getId();
            }
            else{
                return -1;
            }
    }

    public List<Priporocilo> vrniVsaPriporocila(){
        return seznamPriporocil;
    }

    public Priporocilo vrniPriporocilo(int priporociloId){
        for(int i=0;i<seznamPriporocil.size();i++){
            if(seznamPriporocil.get(i).getId() == priporociloId){
                return seznamPriporocil.get(i);
            }
        }
        return null;
    }

    public void dodajPriporocilo(Priporocilo priporocilo){
        priporocilo.setId(vrniIdZadnjegaPriporocila()+1);
        seznamPriporocil.add(priporocilo);
    }

    public void posodobiPriporocilo(int priporociloId, Priporocilo priporocilo){
        for(int i=0;i<seznamPriporocil.size();i++){
            if(seznamPriporocil.get(i).getId() == priporociloId){
                seznamPriporocil.get(i).setIdUporabnika(priporocilo.getIdUporabnika());
                seznamPriporocil.get(i).setSeznamPriporocenihArtiklov(priporocilo.getSeznamPriporocenihArtiklov());
            }
        }
    }

    public void odstraniPriporocilo(int priporociloId){
        for(int i=0;i<seznamPriporocil.size();i++){
            if(seznamPriporocil.get(i).getId() == priporociloId){
                seznamPriporocil.remove(i);
            }
        }

    }
}
