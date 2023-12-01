package ru.hogwarts.hogwarts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.hogwarts.model.Avatar;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar,Long> {
    Optional<Avatar> findByStudentId(Long id);
}
