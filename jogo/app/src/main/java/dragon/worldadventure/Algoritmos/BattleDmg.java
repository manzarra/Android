package dragon.worldadventure.Algoritmos;

import java.util.Random;

import dragon.worldadventure.Objects.AppData;

public class BattleDmg {

    private int numero;
    private int stack;
    private double critico;
    private double hipotesebaixararmadura;

    /**
     * batalha vai de 0 a 1000 e de 0 a 500 e nada de 500 a 750 e 1 de vida regenera  e de 750 a 1000 vai atacar, se conseguir mandar 3 ataques baseado na sorte sai critico
     * no caso de ataque fazer especie de regra de 3 simples onde a desefa total e 100 e o ataque sera percentagem dai essa percentagem sera a hipotese de perder armadura,
     * ataque maior que a armadura ira sempre tirar 1 ponto de defesa
     */


    public void LetsFight(){
        DecisonofActionHero();
        stack=0;
        critico=0;
        DecisonofActionVillan();
        stack=0;
        critico=0;
    }
    private int NumeroAleatorio(){
        Random r = new Random();
        int min = 1;
        int max = 1000;

        return r.nextInt(max - min + 1) + min;
    }

    private void DecisonofActionVillan(){
        for (double i=0;i<AppData.villan.getLuck();i++){
            numero=NumeroAleatorio();
            if (numero<500){

            }else if(numero<750){
                Heal(false,true);
            }else{
                Dealdmg(false,true);
            }
        }

    }

    private void DecisonofActionHero(){
        if(AppData.selectedherotab1) {
            for (double i = 0; i < AppData.herotab1.getLuck(); i++) {
                numero = NumeroAleatorio();
                if (numero < 500) {

                } else if (numero < 750) {
                    Heal(true, false);
                } else {
                    Dealdmg(true, false);
                }
            }
        }else if(AppData.selectedherotab2){
            for (double i = 0; i < AppData.herotab2.getLuck(); i++) {
                numero = NumeroAleatorio();
                if (numero < 500) {

                } else if (numero < 750) {
                    Heal(true, false);
                } else {
                    Dealdmg(true, false);
                }
            }
        }else if (AppData.selectedherotab3){
            for (double i = 0; i < AppData.herotab2.getLuck(); i++) {
                numero = NumeroAleatorio();
                if (numero < 500) {

                } else if (numero < 750) {
                    Heal(true, false);
                } else {
                    Dealdmg(true, false);
                }
            }
        }
    }

    private void Dealdmg(boolean hero,boolean villan){
        stack++;
        if(hero) {
                if (AppData.selectedherotab1) {

                    if (stack > 2) {
                        AppData.herocrit=true;
                        critico=AppData.stats1.getAtk()*2;

                        if (critico> AppData.villan.getDefense()) {
                            AppData.herodmg=critico-AppData.villan.getDefense();

                        }else if(critico==AppData.villan.getDefense()){
                            hipotesebaixararmadura=100;
                            LowerDefence(true,false,hipotesebaixararmadura);

                        }else if(critico<AppData.villan.getDefense()){
                            hipotesebaixararmadura=(critico*100)/AppData.villan.getDefense();
                            LowerDefence(true,false,hipotesebaixararmadura);
                        }
                    } else {

                        if (AppData.stats1.getAtk() > AppData.villan.getDefense()) {
                            AppData.herodmg = AppData.stats1.getAtk() - AppData.villan.getDefense();

                        } else if (AppData.stats1.getAtk() == AppData.villan.getDefense()) {
                            hipotesebaixararmadura = 100;
                            LowerDefence(true, false, hipotesebaixararmadura);

                        } else if (AppData.stats1.getAtk() < AppData.villan.getDefense()) {
                            hipotesebaixararmadura = (AppData.stats1.getAtk() * 100) / AppData.villan.getDefense();
                            LowerDefence(true, false, hipotesebaixararmadura);
                        }
                    }
                } else if (AppData.selectedherotab2) {
                    if (stack > 2) {
                        AppData.herocrit=true;
                        critico=AppData.stats2.getAtk()*2;

                        if (critico> AppData.villan.getDefense()) {
                            AppData.herodmg=critico-AppData.villan.getDefense();

                        }else if(critico==AppData.villan.getDefense()){
                            hipotesebaixararmadura=100;
                            LowerDefence(true,false,hipotesebaixararmadura);

                        }else if(critico<AppData.villan.getDefense()){
                            hipotesebaixararmadura=(critico*100)/AppData.villan.getDefense();
                            LowerDefence(true,false,hipotesebaixararmadura);
                        }
                    } else {

                        if (AppData.stats2.getAtk() > AppData.villan.getDefense()) {
                            AppData.herodmg = AppData.stats2.getAtk() - AppData.villan.getDefense();

                        } else if (AppData.stats2.getAtk() == AppData.villan.getDefense()) {
                            hipotesebaixararmadura = 100;
                            LowerDefence(true, false, hipotesebaixararmadura);

                        } else if (AppData.stats2.getAtk() < AppData.villan.getDefense()) {
                            hipotesebaixararmadura = (AppData.stats2.getAtk() * 100) / AppData.villan.getDefense();
                            LowerDefence(true, false, hipotesebaixararmadura);
                        }
                    }

                } else if (AppData.selectedherotab3) {
                    if (stack > 2) {
                        AppData.herocrit=true;
                        critico=AppData.stats3.getAtk()*2;

                        if (critico> AppData.villan.getDefense()) {
                            AppData.herodmg=critico-AppData.villan.getDefense();

                        }else if(critico==AppData.villan.getDefense()){
                            hipotesebaixararmadura=100;
                            LowerDefence(true,false,hipotesebaixararmadura);

                        }else if(critico<AppData.villan.getDefense()){
                            hipotesebaixararmadura=(critico*100)/AppData.villan.getDefense();
                            LowerDefence(true,false,hipotesebaixararmadura);
                        }
                    } else {

                        if (AppData.stats3.getAtk() > AppData.villan.getDefense()) {
                            AppData.herodmg = AppData.stats3.getAtk() - AppData.villan.getDefense();

                        } else if (AppData.stats3.getAtk() == AppData.villan.getDefense()) {
                            hipotesebaixararmadura = 100;
                            LowerDefence(true, false, hipotesebaixararmadura);

                        } else if (AppData.stats3.getAtk() < AppData.villan.getDefense()) {
                            hipotesebaixararmadura = (AppData.stats3.getAtk() * 100) / AppData.villan.getDefense();
                            LowerDefence(true, false, hipotesebaixararmadura);
                        }
                    }

            }
        }else if (villan) {
            if (AppData.selectedherotab1) {

                if (stack > 2) {
                    AppData.villancrit=true;
                    critico=AppData.villan.getAtk()*2;

                    if (critico> AppData.stats1.getDefense()) {
                        AppData.herodmg=critico-AppData.stats1.getDefense();

                    }else if(critico==AppData.stats1.getDefense()){
                        hipotesebaixararmadura=100;
                        LowerDefence(false,true,hipotesebaixararmadura);

                    }else if(critico<AppData.stats1.getDefense()){
                        hipotesebaixararmadura=(critico*100)/AppData.stats1.getDefense();
                        LowerDefence(false,true,hipotesebaixararmadura);
                    }
                } else {

                    if (AppData.villan.getAtk() > AppData.stats1.getDefense()) {
                        AppData.villandmg = AppData.villan.getAtk() - AppData.stats1.getDefense();

                    } else if (AppData.villan.getAtk() == AppData.stats1.getDefense()) {
                        hipotesebaixararmadura = 100;
                        LowerDefence(false, true, hipotesebaixararmadura);

                    } else if (AppData.villan.getAtk() < AppData.stats1.getDefense()) {
                        hipotesebaixararmadura = (AppData.villan.getAtk() * 100) / AppData.stats1.getDefense();
                        LowerDefence(false, true, hipotesebaixararmadura);
                    }
                }
            } else if (AppData.selectedherotab2) {
                if (stack > 2) {
                    AppData.villancrit=true;
                    critico=AppData.villan.getAtk()*2;

                    if (critico> AppData.stats2.getDefense()) {
                        AppData.herodmg=critico-AppData.stats2.getDefense();

                    }else if(critico==AppData.stats2.getDefense()){
                        hipotesebaixararmadura=100;
                        LowerDefence(false,true,hipotesebaixararmadura);

                    }else if(critico<AppData.stats2.getDefense()){
                        hipotesebaixararmadura=(critico*100)/AppData.stats2.getDefense();
                        LowerDefence(false,true,hipotesebaixararmadura);
                    }
                } else {

                    if (AppData.villan.getAtk() > AppData.stats2.getDefense()) {
                        AppData.villandmg = AppData.villan.getAtk() - AppData.stats2.getDefense();

                    } else if (AppData.villan.getAtk() == AppData.stats2.getDefense()) {
                        hipotesebaixararmadura = 100;
                        LowerDefence(false, true, hipotesebaixararmadura);

                    } else if (AppData.villan.getAtk() < AppData.stats2.getDefense()) {
                        hipotesebaixararmadura = (AppData.villan.getAtk() * 100) / AppData.stats2.getDefense();
                        LowerDefence(false, true, hipotesebaixararmadura);
                    }
                }

            } else if (AppData.selectedherotab3) {
                if (stack > 2) {
                    AppData.villancrit=true;
                    critico=AppData.villan.getAtk()*2;

                    if (critico> AppData.stats3.getDefense()) {
                        AppData.herodmg=critico-AppData.stats3.getDefense();

                    }else if(critico==AppData.stats3.getDefense()){
                        hipotesebaixararmadura=100;
                        LowerDefence(false,true,hipotesebaixararmadura);

                    }else if(critico<AppData.stats3.getDefense()){
                        hipotesebaixararmadura=(critico*100)/AppData.stats3.getDefense();
                        LowerDefence(false,true,hipotesebaixararmadura);
                    }
                } else {

                    if (AppData.villan.getAtk() > AppData.stats3.getDefense()) {
                        AppData.villandmg = AppData.villan.getAtk() - AppData.stats3.getDefense();

                    } else if (AppData.villan.getAtk() == AppData.stats3.getDefense()) {
                        hipotesebaixararmadura = 100;
                        LowerDefence(false, true, hipotesebaixararmadura);

                    } else if (AppData.villan.getAtk() < AppData.stats3.getDefense()) {
                        hipotesebaixararmadura = (AppData.villan.getAtk() * 100) / AppData.stats3.getDefense();
                        LowerDefence(false, true, hipotesebaixararmadura);
                    }
                }

            }

        }

    }

    private void Heal(boolean hero,boolean villan){
        if (hero) {
            AppData.heroregainhealth++;
        }else if(villan){
            AppData.villanregainhealth++;
        }
    }

    private void LowerDefence(boolean hero,boolean villan,double hipotesebaixararmadura){
        Random r = new Random();
        int min = 1;
        int max = 100;

        if(hero){
            int value=r.nextInt(max - min + 1) + min;
            if(value<hipotesebaixararmadura){
                AppData.villanlosedefence++;
            }

        }else if (villan){
            int value=r.nextInt(max - min + 1) + min;
            if(value<hipotesebaixararmadura){
                AppData.herolosedefence++;
            }

        }
    }

}