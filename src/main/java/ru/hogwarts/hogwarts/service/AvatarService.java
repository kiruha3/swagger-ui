package ru.hogwarts.hogwarts.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.hogwarts.model.Avatar;

import java.io.IOException;

public interface AvatarService {
    void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException;

    Avatar findAvatar(Long studentId);

    String getExtensions(String fileName);
}
