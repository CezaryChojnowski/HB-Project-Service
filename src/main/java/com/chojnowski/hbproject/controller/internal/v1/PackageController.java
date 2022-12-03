package com.chojnowski.hbproject.controller.internal.v1;

import com.chojnowski.hbproject.enums.Bank;
import com.chojnowski.hbproject.transactions_brockers.BankTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "internal/api/v1/packages")
public class PackageController {

    private final BankTaskService bankTaskService;

    @PostMapping()
    public void uploadPackage(@RequestPart(name = "file") MultipartFile multipartFile) {
        bankTaskService.uploadFile(multipartFile, Bank.PKO_BP);
    }
}
