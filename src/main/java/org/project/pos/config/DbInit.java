package org.project.pos.config;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.project.pos.category.model.CategoryEntity;
import org.project.pos.category.repo.CategoryRepo;
import org.project.pos.constan.DataStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DbInit implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DbInit.class);
    private final CategoryRepo categoryRepo;

    @Override
    public void run(String... args) throws Exception {
        initCategory();
    }

    private void initCategory(){
        if (this.categoryRepo.countByStatus(DataStatus.ACTIVE) > 0){
            return;
        }

        List<CategoryEntity> categoryEntityList = Arrays.asList(
                new CategoryEntity("1111", "Makanan", 10, 20, DataStatus.ACTIVE),
                new CategoryEntity("2222", "Minuman", 10, 20, DataStatus.ACTIVE),
                new CategoryEntity("3333", "Hewan", 10, 20, DataStatus.ACTIVE),
                new CategoryEntity("4444", "Manusia", 10, 20, DataStatus.ACTIVE),
                new CategoryEntity("5555", "Ikan", 10, 20, DataStatus.ACTIVE)
        );

        try {
            this.categoryRepo.saveAll(categoryEntityList);
            log.info("Save Category Successfully");
        }catch (Exception e){
            log.error("Save Category Failed");
        }
    }
}
