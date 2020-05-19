package com.lindeng;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.io.File;
import java.io.IOException;

public class TestFiles {

    private final String path = "C:\\Users\\lindeng\\IdeaProjects\\my_basketball_manager\\src\\test\\java\\com\\lindeng\\";

    @Test
    public void testFiles(){
        FileUtils.listFiles(
                new File("C:\\Users\\lindeng\\IdeaProjects\\my_basketball_manager\\src\\main\\java\\com\\lindeng\\basketballmanager\\model"),
                null, true).stream().forEach(file -> {
            String sourceTemp = readSource();
            String fileName = file.getName().substring(0,file.getName().indexOf(".java"));
            if(StringUtils.isNotBlank(sourceTemp)){
                String real = sourceTemp.replace("<fileName>", fileName);
                File fileNew = new File("C:\\Users\\lindeng\\IdeaProjects\\my_basketball_manager\\src\\main\\java\\com\\lindeng\\basketballmanager\\repository\\"+fileName+"Repository.java");
                try {
                    FileUtils.writeStringToFile(fileNew, real, "utf-8");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private String readSource(){
        try {
            return FileUtils.readFileToString(new File(path+"source"), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
