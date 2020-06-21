package com.comment.manager.manager.controller;
import com.comment.manager.manager.service.AdvertCopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;


@RequiredArgsConstructor
@Controller
public class AdvertCopyController {

    private final AdvertCopyService advertCopyService;


}
