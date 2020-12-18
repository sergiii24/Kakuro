package dades;

import java.io.File;
import java.io.IOException;
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
}
