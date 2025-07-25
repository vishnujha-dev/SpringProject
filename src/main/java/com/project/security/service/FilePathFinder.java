package com.project.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilePathFinder{
   final File rootDir = new File("D:");
   protected final Path targetDir= Paths.get("D:\\Spring Project\\security\\TargetFolder\\FILE_FOLDER\\");

    BufferedReader reader;
    Logger logger= LoggerFactory.getLogger(FilePathFinder.class);

    List<String> list=new ArrayList<>();
    public List<String> filePathFromFileName(String file){

        try{
            file="file.txt";
            reader=new BufferedReader(new FileReader("D:\\Spring Project\\security\\TargetFolder\\"+file));
             FileWriter writer=new FileWriter("D:\\Spring Project\\security\\TargetFolder\\Output.txt");
            String fileName;
            while ((fileName = reader.readLine()) != null) {

                list.add(fileName +": "+this.searchFileDir(fileName,rootDir));

                writer.write(fileName +": "+this.searchFileDir(fileName,rootDir)+ System.lineSeparator());
            }
            writer.close();
            reader.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    private String searchFileDir(String fileName, File directory) {
        if (directory == null || !directory.isDirectory()) {
            return null;
        }

        File[] files = directory.listFiles();
        if (files == null) return null;

        for (File file : files) {
            if (file.isDirectory()) {
                String result = searchFileDir(fileName, file);
                if (result != null) return result;
            } else if (file.getName().equalsIgnoreCase(fileName)) {
                return file.getAbsolutePath();
            }
        }
        /*Files.walk(directory.toPath()).filter(Files::isRegularFile)
                .filter(Path-> Path.getFileName().toString().equalsIgnoreCase(fileName)).
                map(Path::toAbsolutePath).map(Path::toString).findFirst().orElse(null);
*/
        return null;
    }

    public String fileMover( String sourceFolder ) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\Spring Project\\security\\TargetFolder\\" + sourceFolder));

            String line;
            while ((line = reader.readLine()) != null) {
                line= line.split(": ",2).length==2 ? line.split(": ",2)[1]:"";
                System.out.println("line : "+ line );
                if(line.isEmpty()) continue;
                if(!line.isEmpty()) {
                    Files.copy(Paths.get(line),
                            Paths.get(targetDir.toString()+"/"+Paths.get(line).getFileName()),
                            StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return reader.toString();
    }
}

