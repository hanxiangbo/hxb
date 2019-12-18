package com.hxb.contentcenter.controller;

import com.hxb.contentcenter.domain.dto.content.ShareDTO;
import com.hxb.contentcenter.domain.entity.content.Share;
import com.hxb.contentcenter.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author:hxb
 * @Date: 2019/12/11 13:34
 * @Description:
 */
@RestController
@RequestMapping("/shares")
public class ShareController {

    @Autowired
    private ShareService shareService;

    @GetMapping("/{id}")
    public ShareDTO findById(@PathVariable Integer id) {
        return shareService.findById(id);
    }

    @GetMapping("/test")
    public List<String> test() {
        return shareService.getInstances();
    }
}
