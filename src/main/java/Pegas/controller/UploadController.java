package Pegas.controller;

import Pegas.dto.TaskCreateUpdateDto;
import Pegas.entity.Status;
import Pegas.entity.Task;
import Pegas.service.TaskService;
import Pegas.service.UploadService;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UploadController {
    private final TaskService taskService;
    private final UploadService uploadService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if(!uploadService.hasCsvFormat(file)){
            return "it's not csv file";
        }
        InputStream inputStream = file.getInputStream();
        CsvParserSettings settings = new CsvParserSettings();
        settings.detectFormatAutomatically();
        settings.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(settings);
        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
        parseAllRecords.forEach(record -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
            LocalDateTime date = LocalDateTime.parse(record.getString("CREATED"), formatter);
            TaskCreateUpdateDto createUpdateDto = new TaskCreateUpdateDto(record.getString("DESCRIPTION"),
                    Status.valueOf(record.getString("STATUS")), date);
            taskService.create(createUpdateDto);
        });
        return "parse successfully";
    }
}
