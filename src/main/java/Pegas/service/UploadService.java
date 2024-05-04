package Pegas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class UploadService {
    public boolean hasCsvFormat(MultipartFile file){
        String type = "text/csv";
        if(!type.equals(file.getContentType()))
            return false;
        return true;
    }
}
