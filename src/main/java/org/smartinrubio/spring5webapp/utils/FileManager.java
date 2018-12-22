package org.smartinrubio.spring5webapp.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileManager {

    public static void saveFile(MultipartFile file) throws IOException {
        String directoryName = "/home/smr/uploads/";

        File directory = new File(directoryName);
        if (! directory.exists()){
            directory.mkdir();
        }

        String destination = directoryName + file.getOriginalFilename();

        file.transferTo(new File(destination));

    }
}
