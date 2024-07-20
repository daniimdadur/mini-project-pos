package org.project.pos.config;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.project.pos.auth.model.entity.RoleEntity;
import org.project.pos.auth.model.entity.UserEntity;
import org.project.pos.auth.repository.RoleRepo;
import org.project.pos.auth.repository.UserRepo;
import org.project.pos.category.model.CategoryEntity;
import org.project.pos.category.repo.CategoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DbInit implements CommandLineRunner {
    private final PasswordEncoder encoder;
    private final CategoryRepo categoryRepo;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public void run(String... args) throws Exception {
        initCategory();
        initRole();
        initUser();
    }

    private void initCategory(){
        if (!this.categoryRepo.findAll().isEmpty()){
            return;
        }

        List<CategoryEntity> categoryEntityList = Arrays.asList(
                new CategoryEntity("1111", "Makanan", 10, 20),
                new CategoryEntity("2222", "Minuman", 10, 20),
                new CategoryEntity("3333", "Hewan", 10, 20),
                new CategoryEntity("4444", "Manusia", 10, 20),
                new CategoryEntity("5555", "Ikan", 10, 20)
        );

        try {
            this.categoryRepo.saveAll(categoryEntityList);
            log.info("Save Category SuccessFully");
        }catch (Exception e){
            log.error("Save Category Failed");
        }
    }

    private void initRole(){
        if (this.roleRepo.count() > 0){
            log.info("Role has been initialized");
            return;
        }

        try {
            var roleList = Arrays.asList(
                    new RoleEntity("ROLE_USER"),
                    new RoleEntity("ROLE_ADMIN"),
                    new RoleEntity("ROLE_SUPER_USER")
            );
            this.roleRepo.saveAllAndFlush(roleList);
            log.info("Role has been initialized");
        }catch (Exception e){
            log.error("Save role error: {}", e.getMessage());
        }
    }

    public void initUser() {
        if (this.userRepo.count() > 0){
            log.info("User has been initialized");
            return;
        }
        List<UserEntity> userEntityList = new ArrayList<>();
        RoleEntity roleUser = roleRepo.findByName("ROLE_USER").orElse(null);
        if (roleUser != null){
            userEntityList.add(new UserEntity("user", "satu", "user01@gmail.com", encoder.encode("P@ssW0rd32!"), Arrays.asList(roleUser)));
        }

        RoleEntity roleAdmin = roleRepo.findByName("ROLE_ADMIN").orElse(null);
        if (roleAdmin != null){
            userEntityList.add(new UserEntity("admin", "satu", "admin01@gmail.com", encoder.encode("P@ssW0rd32!"), Arrays.asList(roleAdmin)));
        }

        RoleEntity roleSuperUser = roleRepo.findByName("ROLE_SUPER_USER").orElse(null);
        if (roleSuperUser != null){
            userEntityList.add(new UserEntity("super", "user", "super.user@gmail.com", encoder.encode("P@ssW0rd32!"), Arrays.asList(roleSuperUser)));
        }

        try {
            this.userRepo.saveAllAndFlush(userEntityList);
            log.info("User has been initialized");
        }catch (Exception e){
            log.error("Save user error: {}", e.getMessage());
        }
    }
}
