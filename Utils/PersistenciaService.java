package POO.Projetos.SistemaBancario.Utils;

import POO.Projetos.SistemaBancario.Dominio.Banco;

import java.io.*;

public class PersistenciaService {
    private static final String ARQUIVO = "banco.dat";


    public static void salvar(Banco banco){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))){
            oos.writeObject(banco);
        }catch (IOException e){
            System.out.println("Erro ao salvar os dados: "+e.getMessage());
        }
    }

    public static Banco carregar(){
        File arquivo = new File(ARQUIVO);
        if(!arquivo.exists()){
            return new Banco();
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))){
            return (Banco) ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Erro ao carregar os dados: "+e.getMessage());
        }
        return new Banco();
    }
}
