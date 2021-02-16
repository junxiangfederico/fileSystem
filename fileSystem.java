import java.util.ArrayList;
import java.util.List;

public class fileSystem {
    /**
     * Scopo della prova è progettare e implementare una gerarchia di 
     * oggetti utili a realizzare una shell, ossia un semplice interprete
     *  di comandi, per un filesystem elementare. 
     */
    //Campi
    final List<entry> F;

    /**
     *  EFFECTS: istanzia un elemento fileSystem
     *  Un fileSystem è una shell in grado di svolgere le operazioni elementari
     *  ls, size, mkdir, mkfile, cd, pwd
     */
    public fileSystem(){
        F = new ArrayList<>();
    }


    /**
     * Effects: inserisce nel fileSystem la entry
     * @param dir -> entry che si vuole inserire
     */
    public void insert(entry dir){
        F.add(dir);
    }


    /**
     * Fornisce una rappresentazione rappresentativa del fileSystem
     */
    @Override
    public String toString() {
        String output = "";
        for (int i = 0 ; i < F.size(); i++){
            output= output +"nome: "+ F.get(i).entryName() + " grandezza:" + F.get(i).size();
        }
        return output;
    }


    /**
     *  EFFECTS:  crea una directory con nome name, e locaiton location
     *              e la inserisce nel fileSystem.+
     * POST-CONDIZIONE: le due variabili name e location venogno consumate
     * @param name -> il nome della directory che is vuole creare 
     * @param location -> la directory in cui si sta creanod l'elemento
     */
	public void mkdir(String name, String location) {
        directory newDirectory = new directory(name,location);
        insert(newDirectory);
	}

    /**
     *  EFFECTS:  stampa una rappresentazione della current directory
     *  POST-CONDIZIONI: la variabile currentDir viene consumata    
     * @param currentDir -> la directory su cui si vuole chiamare l'ls
     */
	public void ls(String currentDir) {
        for (int i = 0 ; i< F.size() ; i++){
            if (F.get(i).location() == currentDir){
                if (F.get(i).isFile()){
                    System.out.println(F.get(i).entryName()+"("+ F.get(i).size()+")");  
                }else{
                    System.out.println(F.get(i).entryName() + "*");  
                }
            }      
        }
        
	}

    /**
     * EFFECTS:     crea un file di nome string, grandezza parseInt, e location currentDir
     *              e la inserisce ocme entry all'interno del fileSystem.
     * POST-CONDIZIONI:  le variabili vengono consumate. 
     * @param string   -> nome del file
     * @param parseInt -> grandezza del file
     * @param currentDir -> posizione del file
     */
	public void mkfile(String string, int parseInt, String currentDir) {
        file newFile = new file(string, parseInt, currentDir);
        insert(newFile);
	}

    /**
     * EFFECTS: Stampa la grandeza di una directory
     *          La grandezza è la somma delle grandezze di tutte le sue entries
     *          le directory valgono 0, i file valgono file-> grnandeza
     *          se la directory è :/root ->  stampa grandezza complessiva del fileSystem.
     * @param currentDir -> directory di cui si vuole stampare la grandezza
     */
	public void size(String currentDir) {
        int grandezza = 0;
        if (currentDir == ":"){
            for (int i = 0 ; i < F.size(); i++){
                grandezza +=F.get(i).size();
            }
            System.out.println(grandezza);
        }else{
            for (int i = 0 ; i < F.size() ; i++){
                if( F.get(i).location() ==currentDir){
                    grandezza += F.get(i).size();
                }
            }
            System.out.println(grandezza);
        }
        }

        public boolean repOk(){
            if (F.size()> 0 ){
                return true;
            }
            else return false;
        }

}