package br.com.jaiminho.provider;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Provider {

    public abstract String sendSms(MultipartFile multipartFile, String msg);
    protected List<Long> readLines(MultipartFile multipartFile){
        try {
            return Arrays
                    .asList(IOUtils
                            .toString(multipartFile.getInputStream(), StandardCharsets.UTF_8.name())
                            .split("\\n"))
                    .stream()
                    .map(line-> line.replace("\r", ""))
                    .map(line -> StringUtils.deleteWhitespace(line))
                    .map(line -> Long.parseLong(line))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
