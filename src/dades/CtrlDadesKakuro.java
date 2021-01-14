package dades;

import domini.Partida;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CtrlDadesKakuro {

    public List<String> getNameKakurosStarted(String user) {

        List<String> nameFiles = new LinkedList<>();

        try {
            List<File> filesInFolder = Files.walk(Paths.get("data/users/" + user + "/continue"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());


            for (File f : filesInFolder) {
                nameFiles.add(f.getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return nameFiles;

    }


    public List<String> getNamePublicKakuros() {

        List<String> nameFiles = new LinkedList<>();

        try {
            List<File> filesInFolder = Files.walk(Paths.get("data/kakuro"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());


            for (File f : filesInFolder) {
                nameFiles.add(f.getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return nameFiles;

    }

    public List<String> getNameKakurosUser(String id) {

        List<String> nameFiles = new LinkedList<>();

        try {
            List<File> filesInFolder = Files.walk(Paths.get("data/users/" + id + "/kakuros"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());


            for (File f : filesInFolder) {
                nameFiles.add(f.getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return nameFiles;

    }

    public void guardar(Partida partida) {

        File users = new File("data/users/" + partida.getUsuari().getId() + "/continue/"+partida.getTauler().getId()+".bin");
        if (!users.exists()) {
            try {
                users.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(users))) {

            salida.writeObject(partida);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }

    public Partida llegirPartidaComençada(String user, String nom) {
        try ( ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("data/users/" + user + "/continue/"+nom ))) {

            return (Partida) entrada.readObject();

        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }

}
